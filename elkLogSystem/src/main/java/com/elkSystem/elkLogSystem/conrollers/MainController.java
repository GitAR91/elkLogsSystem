package com.elkSystem.elkLogSystem.conrollers;

import com.elkSystem.elkLogSystem.annotations.LogObjectId;
import com.elkSystem.elkLogSystem.kafka.KafkaProducer;
import com.elkSystem.elkLogSystem.models.Task;
import com.elkSystem.elkLogSystem.models.impl.SomeObj;
import com.elkSystem.elkLogSystem.models.impl.ThirdPartyObject;
import com.elkSystem.elkLogSystem.service.LogGenerator;
import com.elkSystem.elkLogSystem.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.interceptor.Interceptors;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController(value = "")
@RequiredArgsConstructor
public class MainController {
    Logger logger = LoggerFactory.getLogger(MainController.class);
    private final LogGenerator generator;
    private final KafkaProducer kafkaProducer;
    private final MainService mainService;

    @GetMapping("/generate")
    public ResponseEntity test(@RequestParam(name = "count", defaultValue = "0") Integer count) {
        String requestID = MDC.get("RequestId");
        log.info("Test request received with count: {}", count);
        Task task = new Task("Some task", requestID);
        generator.generate(count);
        return ResponseEntity.ok().body(task);
    }

    @GetMapping("/getObj")
    @LogObjectId
    public SomeObj getObj(){
        log.info("Single simple object");
        SomeObj obj = new SomeObj(1, "Some text");
        return obj;
    }

    @GetMapping("/getObjResponseEntity")
    @LogObjectId
    public ResponseEntity<SomeObj> getObjResponse(){
        log.info("Single response entity object");
        SomeObj obj = new SomeObj(1, "Some text");
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/getObjList")
    @LogObjectId
    public List<SomeObj> getObjList(){
        log.info("Collection object");
        SomeObj obj1 = new SomeObj(1, "Some text 1");
        SomeObj obj2 = new SomeObj(2, "Some text 2");
        SomeObj obj3 = new SomeObj(3, "Some text 3");
        SomeObj obj4 = new SomeObj(4, "Some text 4");
        List<SomeObj> result = Arrays.asList(obj1, obj2, obj3, obj4);
        return result;
    }

    @GetMapping("/getFromThirdParty")
    @LogObjectId
    public ThirdPartyObject getThirdPartyObject(){
        log.info("In main controller");
        ThirdPartyObject object = mainService.getObjectFromApi();
        return object;
    }

    @GetMapping("/sendToBroker")
    public ResponseEntity<String> sendToBroker(){
        Task task = new Task("Task text");
        kafkaProducer.sendToWorker(task);
        return ResponseEntity.ok("Success");
    }
}

package com.elkSystem.elkLogSystem.kafka;

import com.elkSystem.elkLogSystem.models.Task;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;

@Component
public class KafkaProducer {
    @Value("${spring.kafka.task.topic}")
    private String pointCheckingTopic;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    private final KafkaSender<String, Object> kafkaSender;

    @Autowired
    public KafkaProducer(KafkaSender<String, Object> kafkaSender){
        this.kafkaSender = kafkaSender;
    }

    public void sendToWorker(Task task) {
        if (task != null) {
            String requestId = MDC.get("RequestId");
            task.setRequestId(requestId);
            sendData(pointCheckingTopic, task, task.getClass());
        }
    }


    private void sendData(String kafkaTopic, Object value, Class clazz) {
        kafkaSender
                .send(Mono.just(SenderRecord.create(new ProducerRecord<>(kafkaTopic, value), clazz.getSimpleName())))
                .doOnError(e -> LOGGER.error("Send " + clazz.getSimpleName() + " failed", e))
                .subscribe(r -> LOGGER.info(String.format("Message %s sent successfully, topic-partition=%s-%d offset=%d",
                        r.correlationMetadata(),
                        r.recordMetadata().topic(),
                        r.recordMetadata().partition(),
                        r.recordMetadata().offset())));
        System.out.println("msg is sent");
    }
}

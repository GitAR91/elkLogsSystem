package com.elkSystem.elkLogSystem.conrollers;

import com.elkSystem.elkLogSystem.models.elasticsearch.LogDocument;
import com.elkSystem.elkLogSystem.models.impl.SomeObj;
import com.elkSystem.elkLogSystem.service.LogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogsController {
    private final LogService logService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/get_by_request_id")
    public String getLogsById(@RequestParam("requestId")String requestId, Model model){
        List<LogDocument> list = logService.getLogsByRequestId(requestId);
        model.addAttribute("logs", list);
        return "logs";
    }
}

package io.symatic.front8s.controllers;

import io.swagger.annotations.ApiOperation;
import io.symatic.front8s.services.PushMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class PushController {

    PushMessageService pushMessageService;

    @Autowired
    PushController(PushMessageService pushMessageService) {
        this.pushMessageService = pushMessageService;
    }

    @ApiOperation(value = "Push message")
    @RequestMapping(method = RequestMethod.PUT, value = "/push")
    public void push (@RequestBody String message) {
        pushMessageService.pushMessage(message);
    }

}

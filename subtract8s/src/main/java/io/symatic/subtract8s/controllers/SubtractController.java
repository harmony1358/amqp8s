package io.symatic.subtract8s.controllers;

import io.swagger.annotations.ApiOperation;
import io.symatic.subtract8s.services.SubtractMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api")
public class SubtractController {

    private final SubtractMessageService subtractMessageService;

    @Autowired
    public SubtractController(SubtractMessageService subtractMessageService) {
        this.subtractMessageService = subtractMessageService;
    }

    @ApiOperation(value = "Push subtract message")
    @RequestMapping(method = RequestMethod.PUT, value = "/subtract")
    public void subtract(@RequestBody String message) {
        log.info("Received subtract request with message: {}", message);
        subtractMessageService.pushSubtractMessage(message);
    }
}

package io.symatic.front8s.controllers;

import io.swagger.annotations.ApiOperation;
import io.symatic.front8s.services.PushMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for handling push message requests.
 * 
 * <p>This class exposes an endpoint to push messages, which delegates
 * the processing to the PushMessageService.</p>
 */
@RestController
@RequestMapping("api")
public class PushController {

    private PushMessageService pushMessageService;

    /**
     * Constructor for PushController.
     *
     * @param pushMessageService Service to process the push message.
     */
    @Autowired
    public PushController(PushMessageService pushMessageService) {
        this.pushMessageService = pushMessageService;
    }

    /**
     * Endpoint to push a message.
     *
     * @param message the message body provided in the request.
     */
    @ApiOperation(value = "Push message")
    @RequestMapping(method = RequestMethod.PUT, value = "/push")
    public void push(@RequestBody String message) {
        pushMessageService.pushMessage(message);
    }

}

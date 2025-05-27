package io.symatic.red8s.controllers;

import io.swagger.annotations.ApiOperation;
import io.symatic.red8s.services.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for counter operations.
 * 
 * <p>This class provides endpoints for retrieving the current counter value and incrementing the counter.
 * It delegates business logic to the CounterService.</p>
 */
@RestController
@RequestMapping("counter")
public class CounterController {

    private CounterService counterService;

    /**
     * Constructor for CounterController.
     *
     * @param counterService the service handling counter operations.
     */
    @Autowired
    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    /**
     * Endpoint to retrieve the current counter value.
     *
     * @return the current counter value.
     */
    @ApiOperation("Get Counter")
    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public int getCounter() {
        return counterService.getCounter();
    }

    /**
     * Endpoint to increment the counter value.
     *
     * @return the new counter value after increment.
     */
    @ApiOperation("Increment Counter")
    @RequestMapping(method = RequestMethod.PUT, value = "/increment")
    public int incrementCounter() {
        return counterService.incCounter();
    }

}

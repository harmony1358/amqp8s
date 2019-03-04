package io.symatic.red8s.controllers;

import io.swagger.annotations.ApiOperation;
import io.symatic.red8s.services.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("counter")
public class CounterController {

    CounterService counterService;

    @Autowired
    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @ApiOperation("Get Counter")
    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public int getCounter() {
        return counterService.getCounter();
    }

    @ApiOperation("Increment Counter")
    @RequestMapping(method = RequestMethod.PUT, value = "/increment")
    public int incrementCounter() {
        return counterService.incCounter();
    }

}

package io.symatic.red8s.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CounterService {

    public static final String HIT_COUNTER_KEY = "HIT_COUNTER";

    private RedisTemplate<String, Integer> redisTemplate;

    @Autowired
    public CounterService(RedisTemplate<String, Integer> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public int getCounter() {

        return getValue();
    }

    public int incCounter() {

        int v = getValue() + 1;
        redisTemplate.opsForValue().set(HIT_COUNTER_KEY, v);

        return v;
    }


    private int getValue() {

        Integer v = redisTemplate.opsForValue().get(HIT_COUNTER_KEY);

        if (v == null) {
            v = 1;
            redisTemplate.opsForValue().set(HIT_COUNTER_KEY, v);
        }

        return v.intValue();

    }
}

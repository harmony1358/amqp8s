package io.symatic.red8s.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Service for managing the hit counter using Redis.
 * 
 * <p>This service provides methods to get and increment the counter value stored in Redis.
 * It initializes the counter if not present.</p>
 */
@Service
public class CounterService {

    public static final String HIT_COUNTER_KEY = "HIT_COUNTER";

    private RedisTemplate<String, Integer> redisTemplate;

    /**
     * Constructor for CounterService.
     *
     * @param redisTemplate the RedisTemplate for interacting with Redis.
     */
    @Autowired
    public CounterService(RedisTemplate<String, Integer> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * Retrieves the current hit counter value.
     *
     * @return the current counter value.
     */
    public int getCounter() {
        return getValue();
    }

    /**
     * Increments the hit counter by 1.
     *
     * @return the new counter value after increment.
     */
    public int incCounter() {
        int v = getValue() + 1;
        redisTemplate.opsForValue().set(HIT_COUNTER_KEY, v);
        return v;
    }

    /**
     * Retrieves the counter value from Redis, initializing it if needed.
     *
     * @return the integer value of the hit counter.
     */
    private int getValue() {
        Integer v = redisTemplate.opsForValue().get(HIT_COUNTER_KEY);
        if (v == null) {
            v = 1;
            redisTemplate.opsForValue().set(HIT_COUNTER_KEY, v);
        }
        return v.intValue();
    }
}

package io.symatic.red8s.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Redis configuration for the Red8s application.
 * 
 * <p>This configuration class sets up the Jedis connection factory and the RedisTemplate for managing the hit counter.</p>
 */
@Configuration
public class RedisConfig {

    @Value("${redis.host}")
    private String redisHost;

    /**
     * Creates and configures the JedisConnectionFactory.
     *
     * @return the configured JedisConnectionFactory.
     */
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisFactory = new JedisConnectionFactory();
        jedisFactory.setHostName(redisHost);
        return jedisFactory;
    }

    /**
     * Creates and configures the RedisTemplate.
     *
     * @return a RedisTemplate configured for String keys and Integer values.
     */
    @Bean
    public RedisTemplate<String, Integer> redisTemplate() {
        RedisTemplate<String, Integer> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

}

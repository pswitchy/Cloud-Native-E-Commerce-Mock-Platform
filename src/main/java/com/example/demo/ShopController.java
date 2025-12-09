package com.example.demo;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShopController {
    @Autowired private RabbitTemplate rabbitTemplate;
    @Autowired private StringRedisTemplate redisTemplate;

    @Bean public Queue myQueue() { return new Queue("orders"); }

    @GetMapping("/")
    public String health() { return "Mediaocean Shop App is Running!"; }

    @PostMapping("/buy/{item}")
    public String buy(@PathVariable String item) {
        // 1. Send Message to RabbitMQ
        rabbitTemplate.convertAndSend("orders", "New Order: " + item);
        // 2. Increment Counter in Redis
        redisTemplate.opsForValue().increment("sales_count_" + item);
        return "Order Placed for " + item;
    }
}
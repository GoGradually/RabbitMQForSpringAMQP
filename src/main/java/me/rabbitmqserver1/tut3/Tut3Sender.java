package me.rabbitmqserver1.tut3;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.atomic.AtomicInteger;

public class Tut3Sender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private FanoutExchange fanout;

    AtomicInteger dots = new AtomicInteger(0);
    AtomicInteger count = new AtomicInteger(0);

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        ScheduleTimeUpcomingUpdatedMessage message = new ScheduleTimeUpcomingUpdatedMessage(1L, 1L, OffsetDateTime.of(2024, 6, 30, 12, 0, 0, 0, ZoneOffset.of("+09:00")), OffsetDateTime.of(2024, 6, 30, 12, 0, 0, 0, ZoneOffset.of("+09:00")), "1");
        rabbitTemplate.convertAndSend(fanout.getName(), "Orange", message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}

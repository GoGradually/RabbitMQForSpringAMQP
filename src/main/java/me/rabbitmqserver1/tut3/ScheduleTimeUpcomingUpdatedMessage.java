package me.rabbitmqserver1.tut3;

import java.time.OffsetDateTime;

public record ScheduleTimeUpcomingUpdatedMessage(
        Long ownerId,
        Long scheduleId,
        OffsetDateTime newUpcomingTime,
        OffsetDateTime occurredAt,
        String idempotentKey
) {
}


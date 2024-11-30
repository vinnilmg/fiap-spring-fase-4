package com.fiap.spring.batch.batch.domain;

import java.time.LocalDateTime;

public record Person(
        String name,
        String streetName,
        String number,
        String city,
        String country,
        String email,
        String phoneNumber,
        LocalDateTime createDateTime
) {
}

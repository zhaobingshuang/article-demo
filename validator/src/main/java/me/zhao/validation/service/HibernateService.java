package me.zhao.validation.service;

import org.hibernate.validator.constraints.time.DurationMax;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;

@Validated
@Service
public class HibernateService {

    public long durationMax(@DurationMax(minutes = 2) Duration d) {
        return d.toMinutes();
    }

}

package me.zhao.validation.controller;

import java.time.Duration;
import java.util.List;

import me.zhao.validation.service.HibernateService;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * hibernate.validator
 *
 * @author 赵丙双
 */
@RestController
@Validated
public class HibernateController {

    private final HibernateService hibernateService;

    public HibernateController(HibernateService hibernateService) {
        this.hibernateService = hibernateService;
    }

    @GetMapping("durationMax")
    public String durationMax(long minutes) {
        Duration duration = Duration.ofMinutes(minutes);
        return "pass: " + hibernateService.durationMax(duration);
    }

    @GetMapping("length")
    public String length(@Length(min = 2, max = 3) StringBuilder s) {
        return "pass: " + s.toString();
    }

    @GetMapping("range")
    public String range(@Range(min = 3, max = 10) Integer s) {
        return "pass: " + s.toString();
    }

    @GetMapping("uniqueElements")
    public String uniqueElements(@UniqueElements @RequestParam(name = "list", required = false) List<String> list) {
        return "pass: " + list;
    }
}
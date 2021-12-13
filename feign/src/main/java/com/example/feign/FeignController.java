package com.example.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.12.13
 */
@RestController
public class FeignController {

    @GetMapping("/name")
    public String name() {
        return "tom";
    }
}

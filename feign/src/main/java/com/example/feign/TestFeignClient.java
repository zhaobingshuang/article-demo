package com.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.12.13
 */
@FeignClient(name = "test-feign", url = "${feign.url}")
public interface TestFeignClient {

    @GetMapping("/name")
    String name();
}

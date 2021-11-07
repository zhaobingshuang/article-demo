package com.example.client;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "service", url = "127.0.0.1:8081")
public interface FileFeignClient {

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    String upload(@RequestPart("file") MultipartFile file);

    @GetMapping("download")
    Response download();
}

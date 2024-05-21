package com.example.client;

import com.example.entities.Readers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("reader-service")
public interface ReaderClient {
    @GetMapping("/user/{userId}")
    public Readers getReaders(@PathVariable("userId")Integer userId);
}

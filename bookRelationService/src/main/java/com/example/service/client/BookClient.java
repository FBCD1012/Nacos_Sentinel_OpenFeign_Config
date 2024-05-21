package com.example.client;

import com.example.entities.Books;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("book-service")
public interface BookClient {
    //设置相关的书籍接口操作
    @GetMapping("/book/{bookId}")
    public Books getBooks(@PathVariable("bookId") Integer bookId);
}

package com.example.service.impl;

import com.example.entities.Books;
import com.example.entities.Readers;
import com.example.entity.BookRealation;
import com.example.entity.BookRelationDetails;
import com.example.mapper.BookRealationMapper;
import com.example.service.BookRealationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class BookRealationServiceImpl implements BookRealationService {

    @Resource
    BookRealationMapper bookRealationMapper;


    @Override
    public BookRelationDetails getTheBookRelationDetails(Integer rid) {
        List<BookRealation> theReads = bookRealationMapper.getTheReads(rid);
        RestTemplate template=new RestTemplate();
        Readers readers=template.getForObject("http://localhost:8100/user/"+rid, Readers.class);
        List<Books> booksList= theReads.stream()
                .map(b -> template.getForObject("http://localhost:8101/book/" + b.getBid(), Books.class)).toList();
        return new BookRelationDetails(readers,booksList);
    }
}

package com.home.library.controller;

import com.home.library.converter.Converter;
import com.home.library.db.entity.Book;
import com.home.library.dto.BookDto;
import com.home.library.service.BookServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Controller {
    @Autowired
    private BookServiceImpl bookService;
    @Autowired
    private Converter converter;

    @PostMapping("/create-book")
    public BookDto create(@RequestBody BookDto bookDto) {
        Book book = converter.convertToEntity(bookDto);
        Book bookCreated = bookService.saveBook(book);
        return converter.convertToDto(bookCreated);
    }
}

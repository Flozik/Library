package com.home.library.controller;

import com.home.library.converter.Converter;
import com.home.library.db.entity.Book;
import com.home.library.dto.BookDto;
import com.home.library.service.BookServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class Controller {
    @Autowired
    private BookServiceImpl bookService;
    @Autowired
    private Converter converter;

    @PostMapping("/create-book")
    public BookDto createBook(@RequestBody BookDto bookDto) {
        Book book = converter.convertToEntity(bookDto);
        Book bookCreated = bookService.saveBook(book);
        return converter.convertToDto(bookCreated);
    }

    @GetMapping("/book/{bookId}")
    public BookDto getBookById(@PathVariable String bookId) {
        Book book = bookService.getBook(bookId);
        return converter.convertToDto(book);
    }

    @GetMapping("/delete/{bookId}")
    public BookDto deleteBook(@PathVariable String bookId) {
        Book book = bookService.removeBook(bookId);
        return converter.convertToDto(book);
    }

    @PostMapping("/update/{bookId}")
    public BookDto updateBook(@PathVariable String bookId,
                              @RequestBody BookDto bookDto) {
        bookDto.setId(bookId);
        Book newBook = converter.convertToEntity(bookDto);
        Book bookUpdated = bookService.updateBook(newBook);
        return converter.convertToDto(bookUpdated);
    }
}

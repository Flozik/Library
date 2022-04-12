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
        log.info("Converter method createBook. Input value: {}", bookDto);
        Book book = converter.convertToEntity(bookDto);
        bookService.saveBook(book);
        return converter.convertToDto(book);
    }

    @GetMapping("/book/{bookId}")
    public BookDto getBookById(@PathVariable String bookId) {
        log.info("Converter method getBookById. Input value bookId: {}", bookId);
        BookDto bookDto = new BookDto();
        bookDto.setId(bookId);
        Book book = converter.convertToEntity(bookDto);
        Book bookCreated = bookService.getBook(book);
        return converter.convertToDto(bookCreated);
    }

    @GetMapping("/delete/{bookId}")
    public BookDto deleteBook(@PathVariable String bookId) {
        log.info("Converter method deleteBook. Input value bookId: {}", bookId);
        BookDto bookDto = new BookDto();
        bookDto.setId(bookId);
        Book book = converter.convertToEntity(bookDto);
        Book bookDeleted = bookService.removeBook(book);
        return converter.convertToDto(bookDeleted);
    }

    @PostMapping("/update/{bookId}")
    public BookDto updateBook(@PathVariable String bookId,
                              @RequestBody BookDto bookDto) {
        log.info("Controller method updateBook. Input value: {}\n" +
                "Input value: {}", bookId, bookDto);
        bookDto.setId(bookId);
        Book newBook = converter.convertToEntity(bookDto);
        bookService.updateBook(newBook);
        return converter.convertToDto(newBook);
    }
}

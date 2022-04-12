package com.home.library.converter;

import com.home.library.db.entity.Book;
import com.home.library.dto.BookDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Converter {
    @Autowired
    private ModelMapper modelMapper;

    public Book convertToEntity(BookDto bookDto) {
        log.info("Converter method convertToEntity. Input value: {}", bookDto);
        Book book = modelMapper.map(bookDto, Book.class);
        return book;
    }

    public BookDto convertToDto(Book book) {
        log.info("Converter method convertToDto. Input value: {}", book);
        BookDto bookDto = modelMapper.map(book, BookDto.class);
        return bookDto;
    }
}

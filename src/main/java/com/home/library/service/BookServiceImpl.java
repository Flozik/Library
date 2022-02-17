package com.home.library.service;

import com.home.library.db.dao.BookDao;
import com.home.library.db.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public Book saveBook(Book book) {
        book = bookDao.insert(book);
        return book;
    }
}

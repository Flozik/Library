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
        log.info("Service method getBook. Input value bookId: {}", book);
        book = bookDao.insert(book);
        return book;
    }

    @Override
    public Book getBook(String id) {
        log.info("Service method getBook. Input value bookId: {}", id);
        return bookDao.findById(id).orElse(null);
    }

    @Override
    public Book getBook(Book book) {
        log.info("Service method getBook. Input value: {}", book);
        return this.getBook(book.getId());
    }

    @Override
    public Book removeBook(String id) {
        log.info("Service method removeBook. Input value bookId: {}", id);
        Book book = this.getBook(id);
        /*if (book == null) {
            return null;
        } else {*/
            bookDao.delete(book);
//        }
        return book;
    }

    @Override
    public Book removeBook(Book book) {
        log.info("Service method removeBook. Input value bookId: {}", book);
        return this.removeBook(book.getId());
    }

    @Override
    public Book updateBook(Book newBook) {
        log.info("Service method updateBook. Input value bookId: {}", newBook);
        Book oldBook = this.getBook(newBook);
        if (oldBook.getId().equals(newBook.getId())) {
            oldBook.setName(newBook.getName());
            oldBook.setPageCount(newBook.getPageCount());
            oldBook.setGenre(newBook.getGenre());
            oldBook.setAuthorId(newBook.getAuthorId());
        }

        return bookDao.save(oldBook);
    }
}

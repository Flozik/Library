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

    @Override
    public Book getBook(String id) {
        return bookDao.findById(id).orElse(null);
    }

    @Override
    public Book getBook(Book book) {
        return this.getBook(book.getId());
    }

    @Override
    public Book removeBook(String id) {
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
        return this.removeBook(book.getId());
    }

    @Override
    public Book updateBook(Book newBook) {
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

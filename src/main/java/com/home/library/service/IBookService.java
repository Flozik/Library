package com.home.library.service;

import com.home.library.db.entity.Book;

public interface IBookService {
    /**
     * save book entity into database
     * @param book new entity which represent book object
     * @return saved entity with generated id
     */
    public Book saveBook(Book book);

    /**
     * find book object with id
     * @param id identifier for book finding
     * @return book object or null if object was not found
     */
    public Book getBook(String id);

    /**
     * find book object. This method calls getBook(String id)
     * @param book object for book finding
     * @return book object or null if object was not found
     */
    public Book getBook(Book book);

    /**
     * delete book from database. The book will be removed by id but first method must find book
     * @param id identifier for book deleting
     * @return removed book object or null if book id does not remove
     */
    public Book removeBook(String id);

    /**
     * delete book from database. This method calls removeBook(String id)
     * @param book object for removing
     * @return removed book object or null if book does not remove
     */
    public Book removeBook(Book book);

    /**
     * update book in database. The book will be updated by book object
     * @param newBook object for updating
//     * @param bookDto object which was converted from user
     * @return updated book object or null if book does not update
     */
    public Book updateBook(Book newBook);
}

package com.home.library.db.dao;

import com.home.library.db.entity.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends BaseDao<Book, String> {
}

package com.home.library.db.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseDao<T, ID> extends MongoRepository<T, ID> {
}

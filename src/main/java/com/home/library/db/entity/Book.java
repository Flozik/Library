package com.home.library.db.entity;

import com.home.library.db.Genre;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Book {
    @Id
    private String id;
    private String name;
    private int pageCount;
    private Genre genre;
    private Long authorId;
}

package com.home.library.dto;

import com.home.library.db.Genre;
import lombok.Data;

@Data
public class BookDto {
    private String id;
    private String name;
    private int pageCount;
    private Genre genre;
    private Long authorId;
}

package com.home.library.db.entity;

import com.home.library.db.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private Long id;
    private String name;
    private String surname;
    private Date birthday;
    private Gender gender;
    private byte course;
}

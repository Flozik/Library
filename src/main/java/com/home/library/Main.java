package com.home.library;

 import com.home.library.db.Genre;
 import com.home.library.db.dao.BookDao;
 import com.home.library.db.entity.Book;
 import org.springframework.boot.CommandLineRunner;
 import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(BookDao bookDao) {
        return args -> {
            Book book = new Book(
                    "Witcher", 636, Genre.ROMANCE, 1L
            );
            bookDao.insert(book);
            System.out.println(book);
        };
    }
}

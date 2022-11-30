package com.rexinc.sdjpaintro.bootstrap;

import com.rexinc.sdjpaintro.domain.Book;
import com.rexinc.sdjpaintro.repository.BookRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component
public class DataInitializer implements CommandLineRunner {
    BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        bookRepository.save(new Book("Eze goes to school", "123esb", "McMillian"));
        bookRepository.save(new Book("Chike and The River", "1357esb", "McMillian"));
        bookRepository.save(new Book("Agbo Lives In Calabar", "1997esb", "McMillian"));


        bookRepository.findAll().forEach((book)->{
            System.out.println("Book Id: " + book.getId());
            System.out.println("Book Title: " + book.getTitle());
        });
    }
}

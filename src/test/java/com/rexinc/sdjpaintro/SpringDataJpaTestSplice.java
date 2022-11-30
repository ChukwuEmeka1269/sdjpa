package com.rexinc.sdjpaintro;


import com.rexinc.sdjpaintro.domain.Book;
import com.rexinc.sdjpaintro.repository.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.rexinc.sdjpaintro.bootstrap"})
public class SpringDataJpaTestSplice {

    @Autowired
    BookRepository bookRepository;


    @Commit
    @Order(1)
    @Test
    void testBookRepository(){
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(3);

        Book book = new Book("Book1", "123sb", "Me");
        bookRepository.save(book);

        long countAfterSave = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfterSave);
    }

    @Order(2)
    @Test
    void testBookRepositoryTrx(){
       long count = bookRepository.count();

       assertThat(count).isEqualTo(4);
    }
}

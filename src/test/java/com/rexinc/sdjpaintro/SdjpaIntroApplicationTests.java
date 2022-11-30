package com.rexinc.sdjpaintro;

import com.rexinc.sdjpaintro.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SdjpaIntroApplicationTests {

	@Autowired
	BookRepository bookRepository;

	@Test
	@DisplayName("Test Count of Books in BookRepository")
	void testBookRepository(){
		long count = bookRepository.count();

		assertThat(count).isGreaterThan(0);

	}

	@Test
	void contextLoads() {
	}

}

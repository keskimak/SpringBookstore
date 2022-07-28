package com.example.NooraBookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.NooraBookstore.domain.Book;
import com.example.NooraBookstore.domain.BookRepository;
import com.example.NooraBookstore.domain.Category;
import com.example.NooraBookstore.domain.CategoryRespitory;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRespitory catRespitory;
	
	@Test
	public void createBook() {
		Book book = new Book("Raamattu", "Paavali", "45456-44", 1500, 0.50, new Category( "Fantasy"));	
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	
		
		
	}

	

}

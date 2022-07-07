package com.example.NooraBookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.NooraBookstore.domain.Book;
import com.example.NooraBookstore.domain.BookRepository;
import com.example.NooraBookstore.domain.Category;
import com.example.NooraBookstore.domain.CategoryRespitory;

@SpringBootApplication
public class NooraBookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(NooraBookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRespitory catRespitory)
	{return (args) -> {
		 System.out.println("Saving books to the database");
		 Category cat1 = new Category("Fantasy");
		 Category cat2 = new Category("Romance");
		 catRespitory.save(cat1);
		 catRespitory.save(cat2);
		 Book b1 = new Book("Lord of the Rings", "J.R.R. Tolkien", "4545-5", 1954, 16.20, cat1);
		 Book b2 = new Book("Harry Potter and the philosopher's stone", "J.K. Rowling", "434344545-5", 1996, 19.95, cat1);
		 repository.save(b1);	 
		 repository.save(b2);	
		 
		};
		}


}

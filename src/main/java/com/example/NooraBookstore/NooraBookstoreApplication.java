package com.example.NooraBookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;

import com.example.NooraBookstore.domain.Book;
import com.example.NooraBookstore.domain.BookRepository;
import com.example.NooraBookstore.domain.Category;
import com.example.NooraBookstore.domain.CategoryRespitory;
import com.example.NooraBookstore.domain.User;
import com.example.NooraBookstore.domain.UserRepository;

@SpringBootApplication
public class NooraBookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(NooraBookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRespitory catRespitory, UserRepository userRepository) {
		return (args) -> {
			System.out.println("Saving books to the database");
			Category cat1 = new Category("Fantasy");
			Category cat2 = new Category("Romance");
			catRespitory.save(cat1);
			catRespitory.save(cat2);
			Book b1 = new Book("Lord of the Rings", "J.R.R. Tolkien", "4545-5", 1954, 16.20, cat1);
			Book b2 = new Book("Harry Potter and the philosopher's stone", "J.K. Rowling", "434344545-5", 1996, 19.95,
					cat1);
			repository.save(b1);
			repository.save(b2);

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
			
		};
	}

}

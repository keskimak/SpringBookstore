package com.example.NooraBookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.NooraBookstore.services.UserDetailServiceImpl;
import com.example.NooraBookstore.web.BookController;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class NooraBookstoreApplicationTests {

	@Autowired
	private BookController controller;
	
	@Autowired
	private UserDetailServiceImpl userdetSerImp;
	
	
	@Test
	public void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
		assertThat(userdetSerImp).isNotNull();
	}

}

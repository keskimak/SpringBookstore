package com.example.NooraBookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.NooraBookstore.domain.Book;


@Controller
public class BookController {
	List<Book> bookList = new ArrayList<Book>();
	
	@GetMapping("/index")
	public String listBooks(@ModelAttribute Book book, Model model) {
		
		
		model.addAttribute("bookList", bookList);
		return "index";

}







}
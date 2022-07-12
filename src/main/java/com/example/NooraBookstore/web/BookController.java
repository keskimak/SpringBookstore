package com.example.NooraBookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.NooraBookstore.domain.Book;
import com.example.NooraBookstore.domain.BookRepository;
import com.example.NooraBookstore.domain.Category;
import com.example.NooraBookstore.domain.CategoryRespitory;

@Controller
public class BookController {
	List<Book> bookList = new ArrayList<Book>();
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRespitory catRespitory;

	//Lists books in the index page. Maybe change the name of the page? 
	@RequestMapping("/index")
	public String listBooks(@ModelAttribute Book book, Model model) {

		model.addAttribute("bookList", repository.findAll());
		return "index";

	}

	//Add new book to the database
	@RequestMapping("/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", catRespitory.findAll());
		return "addbook";
	}

	@PostMapping("/save")
	public String saveBook(Book book) {

		repository.save(book);

		return "redirect:index";

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
		return "redirect:../index";
	}

	@RequestMapping(value = "/edit/{id}")
	public String addBook(@PathVariable("id") Long id, Model model){
		model.addAttribute("book", repository.findById(id));
		model.addAttribute("categories", catRespitory.findAll());
		
		return "edit";
		}


}
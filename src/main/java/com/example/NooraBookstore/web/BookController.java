package com.example.NooraBookstore.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.NooraBookstore.domain.Book;
import com.example.NooraBookstore.domain.BookRepository;
import com.example.NooraBookstore.domain.Category;
import com.example.NooraBookstore.domain.CategoryRespitory;
import com.example.NooraBookstore.domain.UserRepository;

@Controller
public class BookController {
	

	List<Book> bookList = new ArrayList<Book>();
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRespitory catRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private HttpSession session;
	

	// Lists books in the index page "booklist".
	@RequestMapping("/booklist")
	public String listBooks(@ModelAttribute Book book, Model model) {

		model.addAttribute("bookList", repository.findAll());
		return "booklist";

	}

	// Return books in JSON
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}

	// Return book by id in JSON
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long id) {
		return repository.findById(id);
	}

	// Add new book to the database
	@RequestMapping("/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", catRepository.findAll());
		return "addbook";
	}

	@PostMapping("/save")
	public String saveBook(Book book) {

		repository.save(book);

		return "redirect:booklist";

	}

	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
		return "redirect:../booklist";
	}

	@RequestMapping(value = "/edit/{id}")
	public String addBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", repository.findById(id));
		model.addAttribute("categories", catRepository.findAll());

		return "edit";
	}
	
	@RequestMapping(value ="/login")
	public String loginPage() {
		return "login";
	}


}
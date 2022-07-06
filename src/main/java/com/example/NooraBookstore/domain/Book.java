package com.example.NooraBookstore.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DecimalFormat;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private String isbn;
	private int pubYear;
	private double price;

	

	public Book() {

	}

	public Book(String title, String author, String isbn, int pubYear, double price) {
		this.title = title;
		this.author=author;
		this.isbn = isbn;
		this.pubYear = pubYear;
		this.price =price;
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}
	public Long getId() {
		return id;
	}
	
	public Long setId(Long id) {
		return this.id=id;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPubYear() {
		return pubYear;
	}

	public void setPubYear(int pubYear) {
		this.pubYear = pubYear;
	}

	public double getPrice() {
	
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", pubYear=" + pubYear
				+ ", price=" + price + "]";
	}

	



}

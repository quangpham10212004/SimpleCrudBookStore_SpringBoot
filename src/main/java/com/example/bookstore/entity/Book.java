package com.example.bookstore.entity;

import org.springframework.context.annotation.Configuration;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long Id;
	private String title, author;
	private double price;
	private int quantity;
	private int published_year;
	public Book(String title, String author, double price, int quantity, int published_year) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.quantity = quantity;
		this.published_year = published_year;
	}
	
	public Book() {}

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPublished_year() {
		return published_year;
	}

	public void setPublished_year(int published_year) {
		this.published_year = published_year;
	}
	public Long getId() {
		return this.Id;
	}
	@Override
	public String toString() {
		return "Book [Id=" + Id + ", title=" + title + ", author=" + author + ", price=" + price + ", quantity="
				+ quantity + ", published_year=" + published_year + "]";
	}
	
	
	
}

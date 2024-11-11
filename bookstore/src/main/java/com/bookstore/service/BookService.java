package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bRepo;

	public Book save(Book book) {
		Book save = bRepo.save(book);
		return save;

	}
 public List<Book> getAllBook(){
	 return bRepo.findAll();	 
 }
	
 public Book getBookById(int id)
 { 
	 return  bRepo.findById(id).get();
 }
	
}

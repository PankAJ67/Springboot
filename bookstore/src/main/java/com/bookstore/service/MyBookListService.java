package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.MyBookList;
import com.bookstore.repository.MyBookRepository;

@Service
public class MyBookListService {

	@Autowired
	private MyBookRepository mybook;
	
	
	public void saveMyBook(MyBookList book) {
		 mybook.save(book);
	
	}
	public List<MyBookList> getAllBook(){
		 return mybook.findAll();	 
	 }
	
public void deleteById(int id ) {
	mybook.deleteById(id);
}
	
	 
	
}

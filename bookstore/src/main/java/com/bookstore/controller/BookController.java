package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.entity.Book;
import com.bookstore.entity.MyBookList;
import com.bookstore.service.BookService;
import com.bookstore.service.MyBookListService;


@Controller
public class BookController {

	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService myBookService;

	@GetMapping("/")
	public String home() {
		System.out.println("ok");
		return "home";
	}

	

//	@GetMapping("/availableBook")
//	public String getAllBook() {
//	
//		return "book_list";
//	}

	@GetMapping("/availableBook")
	public ModelAndView  getAllBook() {
	List<Book> list= service.getAllBook();
//	ModelAndView m =new ModelAndView();
//	m.setViewName("book_list");
//	m.addAllObjects("book", liust);
	// object bna ke set and view kr sakte hai ye 
	return  new  ModelAndView("book_list","book",list);
	}
	
//	@GetMapping("/availableBook")
//	public String getAllBook() {
//	
//		return "book_list";
//	}	
	
	
	@GetMapping("/bookRegister")
	public String bookRegister() {
		return "book_register";
	}
	
	
	

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book book) {
//		System.out.println(book.toString());
		service.save(book);
		return "redirect:/";

	}
	
//	@GetMapping("/my_book")
//	public String getMyBook()
//	{
//		return"mybook";
//		
//	}
	
	@GetMapping("/my_book")
	public String getMyBook(Model model)
	{
		List<MyBookList>list = myBookService.getAllBook();
		model.addAttribute("book",list );
		return"mybook";
		
	}

	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable int id )
	{  Book b = service.getBookById(id);
	MyBookList mb =new MyBookList(b.getId(),b.getName(),b.getAuther(), b.getPrice());
	myBookService.saveMyBook(mb);
		return "redirect:/my_book";
	}
	
	@RequestMapping("/edit/{id}")
	public String bookEdit(@PathVariable("id") int id , Model model  ) {
      Book b= service.getBookById(id);
      model.addAttribute("book", b);
		return"bookEdit";
	}
	 
}

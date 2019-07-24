package com.vinay.book.service;

import java.util.List;

import com.vinay.book.model.Book;

public interface BookService {
	
	// add book
		long save(Book book);
		
		//get book
		Book get(long id );
		
		//get total book
		List<Book> list();
		
		 // update book
		 void update(long id,Book book);
		
		 // delete book
		 void delete(long id);


}

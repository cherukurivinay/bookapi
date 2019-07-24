package com.vinay.book.dao;

import java.util.List;

import com.vinay.book.model.Book;

public interface BookDao {
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

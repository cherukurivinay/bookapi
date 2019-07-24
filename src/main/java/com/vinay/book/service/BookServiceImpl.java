package com.vinay.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vinay.book.dao.BookDao;
import com.vinay.book.model.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;

	@Override
	@Transactional
	public long save(Book book) {
		
		return bookDao.save(book);
	}

	@Override
	@Transactional
	public Book get(long id) {
		
		return bookDao.get(id);
	}
     
	@Transactional
	@Override
	public List<Book> list() {
		// TODO Auto-generated method stub
		return bookDao.list();
	}
    
	
	@Transactional
	@Override
	public void update(long id, Book book) {
	    bookDao.update(id, book);

	}
    
	@Transactional
	@Override
	public void delete(long id) {
		bookDao.delete(id);
	}

}

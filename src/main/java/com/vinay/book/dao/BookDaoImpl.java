package com.vinay.book.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vinay.book.model.Book;

@Repository
public class BookDaoImpl implements BookDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//save 
    @Override
	public long save(Book book) {
		sessionFactory.getCurrentSession().save(book);
		return book.getId();
	}
    
    //get
	@Override
	public Book get(long id) {
		 return sessionFactory.getCurrentSession().get(Book.class,id);
		
	}
	
    //get list
	@Override
	public List<Book> list() {
		List<Book> list=sessionFactory.getCurrentSession().createQuery("from Book").list();
		return list;
	}
    
	//update
	@Override
	public void update(long id, Book book) {
		Session session=sessionFactory.getCurrentSession();
		Book oldbook=session.byId(Book.class).load(id);
		oldbook.setAuthor(book.getAuthor());
		oldbook.setTitle(book.getTitle());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session=sessionFactory.getCurrentSession();
		Book book=session.byId(Book.class).load(id);
		
		session.delete(book);;
	}

}

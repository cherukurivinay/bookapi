package com.vinay.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vinay.book.model.Book;
import com.vinay.book.service.BookService;

@RestController
public class BookController {
  @Autowired
  private BookService bookService;
  
  @GetMapping("/api/books")
  public ResponseEntity<List<Book>> list(){
	  List<Book> list=bookService.list();
	  return ResponseEntity.ok().body(list);
  }
  
  @PostMapping("/api/book")
  public ResponseEntity<?> save(@RequestBody Book book){
	  long id=bookService.save(book);
	 return ResponseEntity.ok().body("Book is save with id"+id);
  }
  
  @GetMapping("/api/books/{id}")
  public ResponseEntity<Book> get(@PathVariable("id")int id){
	  Book book=bookService.get(id);
	  return ResponseEntity.ok().body(book);
  }
  
  // update
  
  @PutMapping("/api/books/{id}")
  public ResponseEntity<?> updatet(@PathVariable("id")int id, @RequestBody Book book){
	  bookService.update(id, book);;
	  return ResponseEntity.ok().body("Book has been updated");
  }
  
  // delete
  @DeleteMapping("/api/books/{id}")
  public ResponseEntity<?> delete(@PathVariable("id")int id){
	  bookService.delete(id);
	  return ResponseEntity.ok().body("book has been deleted");
  }
  
  
  

}

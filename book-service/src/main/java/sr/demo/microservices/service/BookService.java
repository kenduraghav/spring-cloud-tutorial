package sr.demo.microservices.service;

import java.util.List;

import sr.demo.microservices.model.Book;

public interface BookService {

	
	public Book createBook(Book book);
	
	public List<Book> findAll();
	
	public Book findByBookId(long id);
	
	public Book updateBook(Book book);
	
	public void deleteBookById(long id);
}

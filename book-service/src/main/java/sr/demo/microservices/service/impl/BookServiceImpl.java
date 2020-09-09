package sr.demo.microservices.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sr.demo.microservices.dao.BookRepository;
import sr.demo.microservices.model.Book;
import sr.demo.microservices.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public Book createBook(Book book) {
		return (Book) bookRepository.save(book);
	}

	@Override
	public List<Book> findAll() {
		List<Book> books = bookRepository.findAll();
		return books;
	}

	@Override
	public Book findByBookId(long id) {
		return (Book) bookRepository.findById(id).orElse(null);
	}

	@Override
	public Book updateBook(Book book) {
		return (Book) bookRepository.save(book);
	}

	@Override
	public void deleteBookById(long id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
	}

}

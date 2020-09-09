package sr.demo.microservices.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sr.demo.microservices.model.Book;
import sr.demo.microservices.service.BookService;

@RestController
@RequestMapping(path = "/books")
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping
	public List<Book> findAll() {
		return bookService.findAll();
	}
	
	@GetMapping("/{id}")
	public Book findByBookId(@PathVariable("id") long id) {
		return bookService.findByBookId(id);
	}

	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return bookService.createBook(book);
	}
	
	@PutMapping(path = "/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable("id") long id) {
		book.setId(id);
		return bookService.updateBook(book);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable("id") long id) {
		bookService.deleteBookById(id);
	}
	
}

package sr.demo.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sr.demo.microservices.model.BookRating;
import sr.demo.microservices.service.RatingService;

@RestController
@RequestMapping(path = "/ratings")
public class RatingController {

	@Autowired
	RatingService ratingService;

	@GetMapping
	public List<BookRating> findRatingsByBookId(@RequestParam(required = false, defaultValue = "0") Long bookId) {
		if(bookId.equals(0L)) {
			return ratingService.findAllRatings();
		}
		return ratingService.findRatingsByBookId(bookId);
	}

	@PostMapping
	public BookRating createBook(@RequestBody BookRating book) {
		return ratingService.createRating(book);
	}
	
	@PutMapping(path = "/{id}")
	public BookRating updateBook(@RequestBody BookRating book, @PathVariable("id") long id) {
		book.setId(id);
		return ratingService.updateRating(book);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable("id") long id) {
		ratingService.deleteRating(id);
	}
	
}

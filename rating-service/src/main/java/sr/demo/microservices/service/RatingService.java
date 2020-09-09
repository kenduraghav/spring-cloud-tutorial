package sr.demo.microservices.service;

import java.util.List;

import sr.demo.microservices.model.BookRating;

public interface RatingService {

	
	public BookRating createRating(BookRating book);
	
	public List<BookRating> findAllRatings();
	
	public List<BookRating> findRatingsByBookId(Long id);
	
	public BookRating updateRating(BookRating book);
	
	public void deleteRating(long id);
}

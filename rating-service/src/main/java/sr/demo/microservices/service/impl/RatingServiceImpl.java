package sr.demo.microservices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sr.demo.microservices.model.BookRating;
import sr.demo.microservices.repo.BookRatingRepository;
import sr.demo.microservices.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	BookRatingRepository ratingRepository;
	
	@Override
	public BookRating createRating(BookRating book) {
		return (BookRating) ratingRepository.save(book);
	}

	@Override
	public List<BookRating> findAllRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public List<BookRating> findRatingsByBookId(Long bookId) {
		return ratingRepository.findByBookId(bookId).get();
	}

	@Override
	public BookRating updateRating(BookRating book) {
		return (BookRating) ratingRepository.save(book);
	}

	@Override
	public void deleteRating(long id) {
		ratingRepository.deleteById(id);
	}

}

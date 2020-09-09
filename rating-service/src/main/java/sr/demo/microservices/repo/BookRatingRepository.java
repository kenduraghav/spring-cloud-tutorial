package sr.demo.microservices.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sr.demo.microservices.model.BookRating;

@Repository
public interface BookRatingRepository extends JpaRepository<BookRating,Long> {

	public Optional<List<BookRating>> findByBookId(Long bookId);
}

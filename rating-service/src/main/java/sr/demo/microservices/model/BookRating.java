package sr.demo.microservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "book_rating")
public class BookRating {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(name="book_id")
	private Long bookId;
	private int  stars;
	
	public BookRating() {
		
	}
	

	public BookRating(Long bookId, int stars) {
		this.bookId = bookId;
		this.stars = stars;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public Long getBookId() {
		return bookId;
	}


	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}


	public int getStars() {
		return stars;
	}


	public void setStars(int stars) {
		this.stars = stars;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookRating [id=").append(id).append(", bookId=").append(bookId).append(", stars=").append(stars)
				.append("]");
		return builder.toString();
	}

	

}

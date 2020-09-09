package sr.demo.microservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sr.demo.microservices.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

	
}

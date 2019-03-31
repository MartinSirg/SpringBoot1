package com.martinsirg.springbootapp1.repositories;

import com.martinsirg.springbootapp1.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}

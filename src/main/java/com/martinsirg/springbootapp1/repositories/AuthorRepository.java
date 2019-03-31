package com.martinsirg.springbootapp1.repositories;

import com.martinsirg.springbootapp1.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}

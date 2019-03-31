package com.martinsirg.springbootapp1.repositories;

import com.martinsirg.springbootapp1.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}

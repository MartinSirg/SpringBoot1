package com.martinsirg.springbootapp1.bootstrap;


import com.martinsirg.springbootapp1.model.Author;
import com.martinsirg.springbootapp1.model.Book;
import com.martinsirg.springbootapp1.model.Publisher;
import com.martinsirg.springbootapp1.repositories.AuthorRepository;
import com.martinsirg.springbootapp1.repositories.BookRepository;
import com.martinsirg.springbootapp1.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){

        //Harper Collins publisher
        Publisher hc = new Publisher("Harper Collins", "Random street 1");
        Publisher wrox = new Publisher("Wrox", "Random street 2");
        publisherRepository.save(hc);
        publisherRepository.save(wrox);



        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", hc);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", wrox);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        publisherRepository.save(hc);
        publisherRepository.save(wrox);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}

package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("eric", "Evans");
        Book ddd = new Book("fuck it", "fuck it");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Evan", "rod");
        Book book = new Book("Evan and rods book", "not duck it");
        rod.getBooks().add(book);
        book.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(book);

        // publisher data demo
        //    String city, String address, String state, String zip

        Publisher pub = new Publisher("Cincinnati", "151 west 7th street", "OH", "45215");
        publisherRepository.save(pub);

        ddd.setPublisher(pub);
        pub.getBooks().add(ddd);

        authorRepository.save(rod);
        bookRepository.save(ddd);
        publisherRepository.save(pub);

        System.out.println(publisherRepository.findAll());
        System.out.println(pub.getBooks().size());

        System.out.println("started in repo");
        System.out.println("number of books" + bookRepository.count());
        System.out.println("number of authors" + authorRepository.count());
        System.out.println("publishers count is " + publisherRepository.count() + ", and the object is" + publisherRepository.findById(new Long(5)));


    }
}

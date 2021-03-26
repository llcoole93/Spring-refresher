package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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

        System.out.println("started in repo");
        System.out.println("number of books" + bookRepository.count());
        System.out.println("number of authors" + authorRepository.count());


    }
}

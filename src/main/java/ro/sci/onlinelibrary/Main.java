package ro.sci.onlinelibrary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.model.book.BookRental;

import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
@SpringBootApplication
@ComponentScan("ro.sci.onlinelibrary")
@MapperScan("ro.sci.onlinelibrary.repository")
public class Main {

    public static void main(String[] args) {
        System.getProperties().put("server.port", 8181);
        SpringApplication.run(Main.class, args);
    }

    public void executeThreads(final List<Book> bookList) throws InterruptedException {
        final BookRental bookRental = new BookRental();
        final Book randomBook = bookList.get(1);

        Thread rentBook1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bookRental.rentBook(bookList, randomBook);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread rentBook2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bookRental.rentBook(bookList, randomBook);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread rentBook3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bookRental.rentBook(bookList, randomBook);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        rentBook1.start();
        rentBook2.start();
        rentBook3.start();

        rentBook1.join();
        rentBook2.join();
        rentBook3.join();

    }
}

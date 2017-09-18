package ro.sci.onlinelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.service.BookService;

import java.util.List;

/**
 * Created by iulia on 9/18/2017.
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        List<Book> books = bookService.findAll();
        for (Book book: books) {
            System.out.println(book.getTitle());
        }
        return "hello";
    }
}

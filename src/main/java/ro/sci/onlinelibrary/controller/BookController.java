package ro.sci.onlinelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.service.BookService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iulia on 9/18/2017.
 */
@RestController
public class BookController {
   // private List<Book> books  = new ArrayList<Book>();

    @Autowired
    private BookService bookService;

    /*@RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        List<Book> books = bookService.findAll();
        for (Book book: books) {
            System.out.println(book.getTitle());
        }
        return "hello";

    }*/

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ModelAndView getBooks() {
        List<Book> books = bookService.findAll();
        return new ModelAndView("bookView", "books", books);
    }

    @RequestMapping(value = "/books/search", method = RequestMethod.GET)
    public List<Book> getBooksByAuthor(@RequestParam(value = "author", required = false) String bookAuthor, Model map) {
        List<Book> books = bookService.findBookByAuthor(bookAuthor);
        map.addAttribute("Authors: "+ bookAuthor);
       return books;
    }


}

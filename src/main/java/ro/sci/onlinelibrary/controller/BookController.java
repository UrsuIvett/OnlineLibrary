package ro.sci.onlinelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
=======
>>>>>>> origin/Iulia
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.service.BookService;

<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> origin/Iulia
import java.util.List;

/**
 * Created by iulia on 9/18/2017.
 */
@RestController
public class BookController {
   // private List<Book> books  = new ArrayList<Book>();

    @Autowired
    private BookService bookService;

<<<<<<< HEAD
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
    public String getBooksByAuthor(@RequestParam(value = "author", required = false) String bookAuthor, Model map) {
       map.addAttribute("Authors: "+ bookAuthor);
       return "bookView";
=======
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getBooks() {
        List<Book> books = bookService.findAll();
        return new ModelAndView("bookView", "books", books);
    }

    @RequestMapping(value = "/books/search/title", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showBooksByTitle(@RequestParam(value = "search", required = false, defaultValue = "") String titleSearch) {
        List books = bookService.findBookByTitle(titleSearch);
        return new ModelAndView("titleView", "search", books);

    }

    @RequestMapping(value = "/books/search/author", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showBooksByAuthor(@RequestParam(value = "search", required = false, defaultValue = "") String authorSearch) {
        List books = bookService.findBookByAuthor(authorSearch);
        return new ModelAndView("authorView", "search", books);

>>>>>>> origin/Iulia
    }


}

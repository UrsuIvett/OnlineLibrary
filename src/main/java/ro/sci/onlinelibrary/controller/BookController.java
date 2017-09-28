package ro.sci.onlinelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.service.BookService;

import java.util.List;

/**
 * Created by iulia on 9/18/2017.
 */
@RestController
public class BookController {

    // private List<Book> books  = new ArrayList<Book>();

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getBooks() {
        List<Book> books = bookService.findAll();
        return new ModelAndView("categoriesView", "books", books);
    }

//    @RequestMapping(value = "/books/Search", method = RequestMethod.GET)
//    @ResponseBody
//    public ModelAndView showBooksByTitle(@RequestParam(value = "search", required = false, defaultValue = "") String titleSearch) {
//        List books = bookService.findBookByTitle(titleSearch);
//        return new ModelAndView("titleView", "search", books);
//
//    }

    @RequestMapping(value = "/books/search", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showBooksByAuthor(@RequestParam(value = "search", required = false, defaultValue = "") String authorSearch) {
        List books = bookService.findBookByAuthor(authorSearch);
        return new ModelAndView("authorView", "search", books);

    }


}

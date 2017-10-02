package ro.sci.onlinelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
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

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getBooks() {
        List<Book> books = bookService.findAll();
        return new ModelAndView("bookView", "books", books);
    }

    @RequestMapping(value = "/books/search", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView searchBooks(@RequestParam(value = "searchField", required = false, defaultValue = "") String search) {
        List books = bookService.findByField(search);
        return new ModelAndView("searchView", "searchResult", books);


    }
//
//    @RequestMapping(value = "/books/search/author", method = RequestMethod.GET)
//    @ResponseBody
//    public ModelAndView showBooksByAuthor(@RequestParam(value = "search", required = false, defaultValue = "") String authorSearch) {
//        List books = bookService.findBookByAuthor(authorSearch);
//        return new ModelAndView("authorView", "search", books);
//
//    }

//    @RequestMapping(value = "/addbook", method = RequestMethod.POST)
//             public String addBook(@ModelAttribute("addBook") Book book,ModelMap model){
//
//        model.addAttribute("title",book.getTitle());
//        model.addAttribute("author", book.getAuthor());
//        model.addAttribute("publishingHouse", book.getPublishingHouse());
//        model.addAttribute("bookType", book.getBookType());
//        model.addAttribute("bookLanguage", book.getBookLanguage());
//        model.addAttribute("nrPages", book.getNrPages());
//        model.addAttribute("isbn", book.getIsbn());
//
//        return "result";
//     }



}

package ro.sci.onlinelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.repository.BookRepository;
import ro.sci.onlinelibrary.service.BookService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by iulia on 9/18/2017.
 */
@RestController
public class BookController {

    private static final Logger LOGGER = Logger.getLogger("Onlinelibrary");

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    //Show all books

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getBooks() {
        List<Book> books = bookService.findAll();

        return new ModelAndView("bookView", "books", books);
    }

    //Show all books by a criteria

    @RequestMapping(value = "/books/search", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView searchBooks(@RequestParam(value = "searchField", required = false, defaultValue = "") String search) {
        List books = bookService.findByField(search);

        return new ModelAndView("searchView", "searchResult", books);

    }

    // Submit new book

    @RequestMapping(value = "/books/submit", method = RequestMethod.GET)
    public String bookForm(Model model) {
        model.addAttribute("book", new Book());

        return "submitBook";
    }

    @RequestMapping(value = "/books/submit", method = RequestMethod.POST)
    public String bookSubmit(@ModelAttribute Book book, Model model) {
        bookService.add(book);
        model.addAttribute("book", book);

        return "resultBook";

    }

    // Delete book

    @RequestMapping(value = "/books/delete/{id}", method = RequestMethod.GET)
    public String deleteBookForm(@PathVariable("id") Integer id, Model model) {
        Book currentBook = bookService.searchById(id);
        model.addAttribute("book", currentBook);

        return "deleteBook";
    }

    @RequestMapping(value = "/books/delete/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView deleteBook(@PathVariable("id") Integer id, Model model) {

        LOGGER.log(Level.INFO, "Deleting book with id " + id);

        Book book = bookService.searchById(id);
        bookService.delete(book);

        model.addAttribute("book", book);

        return new ModelAndView("bookView", "books", book);
    }

    // Update book

    @RequestMapping(value = "/books/{id}", method = RequestMethod.POST)
    public ModelAndView updateBook(@PathVariable("id") Integer id, @ModelAttribute Book book) {

        LOGGER.log(Level.INFO, "Updating booking");
        Book updatedBook = bookService.searchById(id);
        updatedBook.setTitle(book.getTitle());


        bookService.update(updatedBook);

        return new ModelAndView("bookView", "books", bookService.findAll());
    }
}

package ro.sci.onlinelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
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
@Controller
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

    //Search books

    @RequestMapping(value = "/books/search", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView searchBooks(@RequestParam(value = "searchField", required = false, defaultValue = "") String search) {
        List books = bookService.findByField(search);

        return new ModelAndView("searchView", "searchResult", books);

    }

    // Submit new book

    @GetMapping(value = "/newBook")
    public String bookForm(Model model) {
        model.addAttribute("book", new Book());

        return "submitBook";
    }


    @PostMapping(value = "/newBook")
    @ResponseBody
    public String bookForm(@ModelAttribute Book book) {
        LOGGER.log(Level.INFO, "Adding a new book");
        bookRepository.add(book);
        return "Book saved!";
    }

    // Delete book

    @RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteBook(Book book) {
        LOGGER.log(Level.INFO, "Deleting book");
        bookRepository.delete(book.getId());
        return "Book deleted";
    }

    // Update book
    @GetMapping(value = "/updateBook/")
    public String updateBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "updateBook";
    }



    //Update a book
    @RequestMapping(value = "/bookIsUpdated/", method = RequestMethod.POST)
    public String updateBookForm(@ModelAttribute Book book) {
        Book updateBook = bookService.searchById(book.getId());
        updateBook.setTitle(book.getTitle());
        updateBook.setAuthor(book.getAuthor());
        updateBook.setPublishingHouse(book.getPublishingHouse());
        updateBook.setBookType(book.getBookType());
        updateBook.setBookLanguage(book.getBookLanguage());
        updateBook.setNrPages(book.getNrPages());
        updateBook.setIsbn(book.getIsbn());
        bookRepository.update(updateBook);
        return "updateBook";
    }


//    @PostMapping(value = "/updateBook/{id}")
//    @ResponseBody
//    public String updateBookForm(@ModelAttribute Book book) {
//        Book updateBook = bookRepository.searchById(book.getId());
////        updateBook.setId(book.getId());
////        updateBook.setTitle(book.getTitle());
////        updateBook.setAuthor(book.getAuthor());
////        updateBook.setPublishingHouse(book.getPublishingHouse());
////        updateBook.setBookType(book.getBookType());
////        updateBook.setBookLanguage(book.getBookLanguage());
////        updateBook.setNrPages(book.getNrPages());
////        updateBook.setIsbn(book.getIsbn());
//        LOGGER.log(Level.INFO, "Updating book");
//        bookRepository.update(updateBook);
//        return "Book updated!";
//    }
//
////    @RequestMapping(value = "/comment", method = RequestMethod.POST)
////    @ResponseBody
////    public ModelAndView getComment() {
////        Review_1 review = new Review_1();
////        return new ModelAndView("commentView", "comment", review);
////
////    }
}

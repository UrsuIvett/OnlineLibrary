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

    //Show all books

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getBooks(@RequestParam(value = "searchField", required = false, defaultValue = "") String search) {
        List<Book> books = bookService.findByField(search);
        return new ModelAndView("books", "searchResult", books);
    }

    //Ask view book
    @GetMapping(value = "/readBook/{id}")
    public String bookView(Model model, @PathVariable(name = "id") int id) {
        Book book = bookService.searchById(id);
        model.addAttribute("book", book);
        return "readBook";
    }

    //Ask submit new book
    @GetMapping(value = "/addBook")
    public String bookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
        }

    //Submit new book
    @PostMapping(value = "/addBook")
    public String bookForm(Model model, @ModelAttribute Book book) {
        bookService.add(book);
        model.addAttribute("message", "Book saved!");
        model.addAttribute("searchResult", bookService.getAll());
        return "books";

        }

    //Delete a book

    @RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET)
    public String deleteBook(Model model, @PathVariable(name = "id") int id) {
        bookService.delete(id);
        model.addAttribute("message", "Book deleted!");
        model.addAttribute("searchResult", bookService.getAll());
        return "books";
    }

    //Ask for update a book
    @GetMapping(value = "/updateBook/{id}")
    public String updateBookForm(Model model, @PathVariable(name = "id") int id) {
        Book book = bookService.searchById(id);
        model.addAttribute("book", book);
        return "updateBook";
    }

    //Update a book
    @PostMapping(value = "/updateBook/{id}")
    public String updateBookForm(Model model, @ModelAttribute Book book) {
        Book updateBook = bookService.searchById(book.getId());
        updateBook.setTitle(book.getTitle());
        updateBook.setAuthor(book.getAuthor());
        updateBook.setPublishingHouse(book.getPublishingHouse());
        updateBook.setBookType(book.getBookType());
        updateBook.setBookLanguage(book.getBookLanguage());
        updateBook.setNrPages(book.getNrPages());
        updateBook.setIsbn(book.getIsbn());
        bookService.update(updateBook);
        model.addAttribute("message", "Book updated!");
        model.addAttribute("searchResult", bookService.getAll());
        return "books";
    }
}

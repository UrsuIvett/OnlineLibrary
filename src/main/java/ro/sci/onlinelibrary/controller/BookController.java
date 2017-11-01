package ro.sci.onlinelibrary.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.repository.BookRepository;
import ro.sci.onlinelibrary.service.BookService;
import java.util.List;




@Controller
public class BookController {

    private static final Logger LOGGER = LoggerFactory.getLogger("BookController");

    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;

    //Show all books
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getBooks() {
        List<Book> books = bookService.getAll();
        return new ModelAndView("bookView", "books", books);
    }

    //Search books from repository
    @RequestMapping(value = "/books/search", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView searchBooks(@RequestParam(value = "searchField", required = false, defaultValue = "") String search) {
        List books = bookService.findByField(search);
        return new ModelAndView("searchView", "searchResult", books);
    }

    //Ask submit new book
    @GetMapping(value = "/newBook")
    public String bookForm(Model model) {
        model.addAttribute("book", new Book());
        return "submit";
    }

    //Submit new book
    @PostMapping(value = "/newBook")
    @ResponseBody
    public String bookForm(@ModelAttribute Book book) {
        bookRepository.add(book);
        LOGGER.info("New book was added to Database, with following id: "+book.getId());
        return "Book saved!";

    }

    //Delete a book

    @RequestMapping(value  = "/deleteBook/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteBook(Book book) {
        bookRepository.delete(book.getId());
        LOGGER.info("New book was deleted from Database, with following id: "+book.getId());
        return "Book deleted";
    }


    //Ask for update a book
    @GetMapping(value = "/updateBook/{id}")
    public String updateBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "updateBook";
    }

    //Update a book
    @PostMapping(value = "/updateBook/{id}")
    public String updateBookForm(@ModelAttribute Book book) {
        Book updateBook = bookRepository.searchById(book.getId());
        updateBook.setTitle(book.getTitle());
        updateBook.setAuthor(book.getAuthor());
        updateBook.setPublishingHouse(book.getPublishingHouse());
        updateBook.setBookType(book.getBookType());
        updateBook.setBookLanguage(book.getBookLanguage());
        updateBook.setNrPages(book.getNrPages());
        updateBook.setIsbn(book.getIsbn());
        bookRepository.update(updateBook);
        LOGGER.info("A book was updated with following id: "+updateBook.getId());
        return "Book updated!";
    }

//    //Ask for update a book
//    @GetMapping(value = "/updateBook/{id}")
//    public String updateBookForm(Model model) {
//        model.addAttribute("book", new Book());
//        return "updateBook";
//    }
//
//    //Update a book
//    @RequestMapping(value = "/updateBook/{id}", method = RequestMethod.POST)
//    public String updateBookForm(@ModelAttribute Book book) {
//        Book updateBook = bookService.searchById(book.getId());
//        updateBook.setTitle(book.getTitle());
//        updateBook.setAuthor(book.getAuthor());
//        updateBook.setPublishingHouse(book.getPublishingHouse());
//        updateBook.setBookType(book.getBookType());
//        updateBook.setBookLanguage(book.getBookLanguage());
//        updateBook.setNrPages(book.getNrPages());
//        updateBook.setIsbn(book.getIsbn());
//        bookRepository.update(updateBook);
//        return "updateBook";
//    }
}
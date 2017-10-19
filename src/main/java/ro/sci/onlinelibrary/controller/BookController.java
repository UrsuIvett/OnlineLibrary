package ro.sci.onlinelibrary.controller;

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

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    //Show all books
    @GetMapping(value = "/books")
    @ResponseBody
    public ModelAndView getBooks() {
        List<Book> books = bookService.getAll();
        return new ModelAndView("booksView", "books", books);
    }

    //Search books from repository
    @GetMapping(value = "/books/search")
    @ResponseBody
    public ModelAndView searchBooks(@RequestParam(value = "searchField", required = false, defaultValue = "") String search) {
        List books = bookService.findByField(search);
        return new ModelAndView("bookSearchView", "searchResult", books);
    }
    //todo exception id
    //show book by id
    @GetMapping(value = "/books/searchById")
    @ResponseBody
    public ModelAndView searchBookById(@RequestParam(value = "search", required = false, defaultValue = "0") Integer searchById) {
        Book book = bookService.findById(searchById);
        return new ModelAndView("searchBookByIdView", "searchResultById", book);
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
        return "Book saved!";
    }

    //Delete a book

    @RequestMapping(value  = "/deleteBook/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteBook(Book book) {
        bookRepository.delete(book.getId());
        return "Book deleted";
    }

    //Ask for update a book
    @GetMapping(value = "/updateBook/")
    public String updateBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "updateBook";
    }

    //Update a book
    @RequestMapping(value = "/doUpdate/", method = RequestMethod.POST)
    public String updateBookForm(@ModelAttribute Book book) {
        Book updateBook = bookService.findById(book.getId());
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

}
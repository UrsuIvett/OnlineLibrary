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
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getBooks() {
        List<Book> books = bookService.findAll();
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
        return "Book saved!";
    }

    //Delete a book

    @RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteBook(Book book) {
        bookRepository.delete(book.getId());
        return "Book deleted";
    }

//    @RequestMapping(value = "/comment", method = RequestMethod.POST)
//    @ResponseBody
//    public ModelAndView getComment() {
//        Review review = new Review();
//        return new ModelAndView("commentView", "comment", review);
//    }


//
//
//    @RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET)
//    public String deleteBookingForm(@PathVariable("id") Integer id, Model model) {
//
//        Book currentBook = bookService.searchById(id);
//        model.addAttribute("booking", currentBook);
//        return "deletebook";
//    }
    //Ask to update an existing book
    @RequestMapping(value = "/updateBook/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String updateBook(Book book) {
        bookRepository.update(book.getId());
        return "Book updated";
    }

//    //Update an existing book
//    @PostMapping(value = "/updateBook")
//    @ResponseBody
//    public String bookForm(@ModelAttribute Book book) {
//        bookRepository.(book);
//        return "Book saved!";
//    }
}
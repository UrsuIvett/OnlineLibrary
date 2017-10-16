package ro.sci.onlinelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.repository.BookRepository;
import ro.sci.onlinelibrary.service.BookService;

import java.util.List;

/**
 * Created by iulia on 9/18/2017.
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;
    private BookRepository bookRepository;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getBooks() {
        List<Book> books = bookService.getAll();
        return new ModelAndView("booksView", "books", books);
    }

    @RequestMapping(value = "/books/search", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView searchBooks(@RequestParam(value = "searchField", required = false, defaultValue = "") String search) {
        List books = bookService.findByField(search);
        return new ModelAndView("bookSearchView", "searchResult", books);
    }

    @RequestMapping(value = "/books/searchById", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView searchBookById(@RequestParam(value = "search", required = false, defaultValue = "0") Integer searchById) {
        List books = bookService.findById(searchById);
        return new ModelAndView("searchBookByIdView", "searchResultById", books);
    }

    //Ask submit new book
    @GetMapping(value = "/newBook")
    public String bookForm(Model model) {
        model.addAttribute("book",new Book());
        return "submit";
    }

    //Submit new book
    @PostMapping(value = "/newBook")
    @ResponseBody
    public String bookForm(@ModelAttribute Book book) {
        bookRepository.add(book);
        return "Book saved!";
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

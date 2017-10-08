package ro.sci.onlinelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.model.user.Customer;
import ro.sci.onlinelibrary.service.BookService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
public class BookController {

    @Autowired
    private BookService bookService;


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

    //Submit new book
    @RequestMapping(value = "/newBook", method = RequestMethod.GET)
//    public String bookForm(Model model) {
//        model.addAttribute("book", new Book());
//        return "submit";
    public ModelAndView newBook(ModelAndView model) {
        Book book = new Book();
        model.addObject("book", book);
        model.setViewName("BookForm");
        return model;
    }

    @RequestMapping(value = "/saveBook", method = RequestMethod.POST)
//    public String saveBook(@ModelAttribute Book book, Model model) {
//        bookService.add(book);
//        model.addAttribute("book", book);
//        return "results";
    public ModelAndView saveBook(@ModelAttribute Book book) {
        if (book.getId() == 0) { // if book id is 0 then creating the
            //book other updating the book
            bookService.add(book);
        } else {
            bookService.update(book);
        }
        return new ModelAndView("redirect:/");
    }

    //Delete a book
//    @RequestMapping(value = "/bookS/delete/{id}", method = RequestMethod.GET)
//    public String deleteBookForm(@PathVariable("id") Integer id, Model model) {
//
//        Book book = bookService.searchById(id);
//        model.addAttribute("booking", book);
//        return "deleteBookView";
//    }

    @RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET)
    public String deleteBookingForm(@PathVariable("id") Integer id, Model model) {

        Book currentBook = bookService.searchById(id);
        model.addAttribute("booking", currentBook);
        return "deletebook";
    }
}
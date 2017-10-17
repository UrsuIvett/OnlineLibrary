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
        List<Book> books = bookService.getAll();
        return new ModelAndView("booksView", "books", books);
    }

    //Search books from repository
    @RequestMapping(value = "/books/search", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView searchBooks(@RequestParam(value = "searchField", required = false, defaultValue = "") String search) {
        List books = bookService.findByField(search);
        return new ModelAndView("bookSearchView", "searchResult", books);
    }

    @RequestMapping(value = "/books/searchById", method = RequestMethod.GET)
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
    @GetMapping(value = "/updateBook/{id}")
    public String updateBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "updateBook";
    }

    //Update a book
    @PostMapping(value = "/updateBook/{id}")
    @RequestMapping
    public String updateBookForm(@PathVariable("id") Integer id,@ModelAttribute Book book) {
        Book updateBook = bookService.findById(id);
        updateBook.setId(book.getId());
        updateBook.setTitle(book.getTitle());
        updateBook.setAuthor(book.getAuthor());
        updateBook.setPublishingHouse(book.getPublishingHouse());
        updateBook.setBookType(book.getBookType());
        updateBook.setBookLanguage(book.getBookLanguage());
        updateBook.setNrPages(book.getNrPages());
        updateBook.setIsbn(book.getIsbn());
        bookService.update(updateBook);
        return "Book updated!";
    }

//    @RequestMapping(value = "/comment", method = RequestMethod.POST)
//    @ResponseBody
//    public ModelAndView getComment() {
//        Review review = new Review();
//        return new ModelAndView("commentView", "comment", review);
//    }

//    @RequestMapping(value = "/rooms/{id}", method = RequestMethod.POST)
//    public ModelAndView updateRoom(@PathVariable("id") Integer id, @ModelAttribute Room room) {
//
//        LOGGER.log(Level.INFO, "Updating room");
//        Room updatedRoom = roomService.searchByRoomNumber(id);
//
//        updatedRoom.setRoomType(room.getRoomType());
//        updatedRoom.setBedType(room.getBedType());
//        updatedRoom.setBedNumber(room.getBedNumber());
//        updatedRoom.setOceanView(room.isOceanView());
//        updatedRoom.setAirConditioning(room.isAirConditioning());
//        updatedRoom.setBalcony(room.isBalcony());
//        updatedRoom.setPricePerNight(room.getPricePerNight());
//
//        roomService.update(updatedRoom);
//
//        return new ModelAndView("rooms", "rooms", roomService.getAll());
//    }

}
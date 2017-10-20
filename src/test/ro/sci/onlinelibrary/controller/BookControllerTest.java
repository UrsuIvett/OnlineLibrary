package ro.sci.onlinelibrary.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.repository.BookRepository;
import ro.sci.onlinelibrary.service.BookService;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {
    @Mock
    private BookService bookService;
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookController bookController;

    @Test
    public void getBooks() throws Exception {
        //given
        Book book1 = new Book();
        List<Book> bookList = Arrays.asList(new Book("Cei trei iezi"), new Book("Cei trei purcelusi"));

        when(bookService.getAll()).thenReturn(bookList);

        //when
        ModelAndView modelAndView = bookController.getBooks();

        //then
        List<Book> resultBooks = (List<Book>) modelAndView.getModel().get("books");
        assertNotNull(resultBooks);
        assertEquals(2, resultBooks.size());
        assertEquals("Cei trei iezi", resultBooks.get(0).getTitle());
        assertEquals("Cei trei purcelusi", resultBooks.get(1).getTitle());
    }
}
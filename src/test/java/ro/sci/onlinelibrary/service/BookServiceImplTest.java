package ro.sci.onlinelibrary.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.model.book.BookLanguage;
import ro.sci.onlinelibrary.model.book.BookType;
import ro.sci.onlinelibrary.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Ivett on 31-Oct-17.
 */
public class BookServiceImplTest {
    private Book book1;
    private Book book2;
    private List<Book> bookList = new ArrayList<Book>();

    @Mock
    private BookRepository bookRepositoryMock;

    @InjectMocks
    private BookServiceImpl bookService;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        book1 = new Book();
        book1.setId(1);
        book1.setTitle("Lord of the rings-Vol1");
        book1.setAuthor("J. R. R. Tolkien");
        book1.setPublishingHouse("Big World");
        book1.setBookLanguage(BookLanguage.ENGLISH);
        book1.setBookType(BookType.FANTASY);
        book1.setNrPages(678);
        book1.setIsbn("1078");
        book2 = new Book();
        book2.setId(2);
        book2.setTitle("Lord of the rings- Vol2");
        book2.setAuthor("J. R. R. Tolkien");
        book2.setPublishingHouse("Big World");
        book2.setBookLanguage(BookLanguage.ROMANIAN);
        book2.setBookType(BookType.FANTASY);
        book2.setNrPages(678);
        book2.setIsbn("1079");
        bookList.add(book1);
        bookList.add(book2);
        when(bookRepositoryMock.getAll()).thenReturn(bookList);

    }

    @Test
    public void findAll() throws Exception {
        assertEquals(2, bookService.getAll().size());
        verify(bookRepositoryMock, times(1)).getAll();
    }

    @Test
    public void findByField() throws Exception {

    }

    @Test
    public void add() throws Exception {
        bookList.add(book1);
        assertEquals(3, bookService.getAll().size());
    }


    @Test
    public void delete() throws Exception {
        bookService.delete(book1.getId());
        bookService.delete(book2.getId());
        verify(bookRepositoryMock, times(1)).delete(book1.getId());
        verify(bookRepositoryMock, times(1)).delete(book2.getId());
    }

    @Test
    public void update() throws Exception {
        book2.setId(3);
        bookService.update(book2);
        when(bookRepositoryMock.searchById(3)).thenReturn(book2);
        assertEquals(3, bookRepositoryMock.searchById(3).getId());
    }

    @Test
    public void searchById() throws Exception {

    }

}
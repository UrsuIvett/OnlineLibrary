package ro.sci.onlinelibrary.repository;

import ro.sci.onlinelibrary.model.Book;

import java.util.List;

/**
 * Created by Ivett on 17-Sep-17.
 */
public class BookRepositoryImpl<T extends Book> extends BaseRepository implements BookRepository<Book> {
    public List<Book> getAll() {
        return null;
    }
}

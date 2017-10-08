package ro.sci.onlinelibrary.model.book;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;

/**
 * Created by Ivett on 14-Sep-17.
 */
@Entity
public class Book {
    private int id;
    private String title;
    private String author;
    private String publishingHouse;
    private BookType bookType;
    private BookLanguage bookLanguage;
    private int nrPages;
    private String isbn;

    public Book(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public BookLanguage getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(BookLanguage bookLanguage) {
        this.bookLanguage = bookLanguage;
    }

    public int getNrPages() {
        return nrPages;
    }

    public void setNrPages(int nrPages) {
        this.nrPages = nrPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (nrPages != book.nrPages) return false;
        if (!title.equals(book.title)) return false;
        if (!author.equals(book.author)) return false;
        if (!publishingHouse.equals(book.publishingHouse)) return false;
        if (bookType != book.bookType) return false;
        if (bookLanguage != book.bookLanguage) return false;
        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + publishingHouse.hashCode();
        result = 31 * result + bookType.hashCode();
        result = 31 * result + bookLanguage.hashCode();
        result = 31 * result + nrPages;
        result = 31 * result + isbn.hashCode();
        return result;
    }
}

package ro.sci.onlinelibrary.model.book;

/**
 * Created by Ivett on 14-Sep-17.
 */
public class Book {
    private String author;
    private String publishingHouse;
    private Type type;
    private Language language;
    private int nrPages;
    private String isbn;

    public Book(String author, String publishingHouse) {
        this.author = author;
        this.publishingHouse = publishingHouse;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public int getNrPages() {
        return nrPages;
    }

    public void setNrPages(int noOfPages) {
        this.nrPages = nrPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

}

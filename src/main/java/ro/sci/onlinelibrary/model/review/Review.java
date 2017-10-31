package ro.sci.onlinelibrary.model.review;

import javax.persistence.Entity;

/**
 * Created by Ivett on 14-Sep-17.
 */

@Entity
public class Review {
    private int id;
    private String comment;
    private int bookId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}

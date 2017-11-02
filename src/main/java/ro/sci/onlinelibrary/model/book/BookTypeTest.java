package ro.sci.onlinelibrary.model.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by iulia on 11/2/2017.
 */
class BookTypeTest {
    @Test
    public void testCreateInvalidBookType() throws IllegalArgumentException {
        try {
            BookType bookType = BookType.valueOf("none");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid book type");
        }

    }

}
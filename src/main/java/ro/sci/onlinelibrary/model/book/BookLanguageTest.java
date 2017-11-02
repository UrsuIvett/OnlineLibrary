package ro.sci.onlinelibrary.model.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by iulia on 11/2/2017.
 */
class BookLanguageTest {
    @Test
    public void testCreateInvalidBookLanguage() throws IllegalArgumentException {
        try {
            BookLanguage bookLanguage = BookLanguage.valueOf("none");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid book language");
        }

    }

}
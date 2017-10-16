package ro.sci.onlinelibrary.model.book;
import org.junit.Test;

/**
 * Created by NORBI on 16.10.2017.
 */

public class BookLanguageTest {
    @Test
    public void testCreateInvalidBookLanguage() throws IllegalArgumentException {
        try {
            BookLanguage bookLanguage = BookLanguage.valueOf("asdasd");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid book language");
        }

    }

}
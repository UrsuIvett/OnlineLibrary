package ro.sci.onlinelibrary.model.book;
import org.junit.Test;

/**
 * Created by NORBI on 16.10.2017.
 */
public class BookTypeTest {
    @Test
    public void testCreateInvalidBookType() throws IllegalArgumentException {
        try {
            BookType bookType = BookType.valueOf("1234567");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid book type");
        }

    }
}
package ro.sci.onlinelibrary.model.book;

import java.util.List;

/**
 * Created by iulia on 10/18/2017.
 */
public class BookRental {
        public void rentBook(List<Book> books, Book randomBook) throws InterruptedException {
            while (true) {
                synchronized (this) {
                    while (randomBook.isOnLoan(false)) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Book is available" + randomBook.getTitle() + randomBook.getAuthor());
                    randomBook.isOnLoan(true);
                    notifyAll();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                }

            }
        }
    }

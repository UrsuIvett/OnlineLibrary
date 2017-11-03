package ro.sci.onlinelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.onlinelibrary.model.review.Review;
import ro.sci.onlinelibrary.repository.BookRepository;
import ro.sci.onlinelibrary.repository.ReviewRepository;

import java.util.List;

/**
 * Created by Ivett on 17-Oct-17.
 */

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> findAll(int bookId) {
        return reviewRepository.getAll(bookId);
    }

    @Override
    public void add(Review review) {
    this.reviewRepository.add(review);
    }
}

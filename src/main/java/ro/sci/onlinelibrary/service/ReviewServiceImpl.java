package ro.sci.onlinelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.onlinelibrary.model.review.Review;
import ro.sci.onlinelibrary.repository.ReviewRepository;

import java.util.List;

/**
 * Created by iulia on 10/19/2017.
 */
@Service("reviewService")
public class ReviewServiceImpl implements ReviewService<Review> {

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

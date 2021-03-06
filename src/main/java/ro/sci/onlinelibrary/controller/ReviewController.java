package ro.sci.onlinelibrary.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.model.review.Review;
import ro.sci.onlinelibrary.repository.BookRepository;
import ro.sci.onlinelibrary.repository.ReviewRepository;
import ro.sci.onlinelibrary.repository.UserRepository;
import ro.sci.onlinelibrary.service.BookService;
import ro.sci.onlinelibrary.service.ReviewService;
import ro.sci.onlinelibrary.service.UserService;

import java.util.List;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ReviewRepository reviewRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReviewController.class.getName());

    //Ask submit new comment
    @GetMapping(value = "books/newReview")
    public String reviewForm(Model model) {
        model.addAttribute("review", new Review());
        return "newReview";
    }

    //Submit new book
    @PostMapping(value = "books/newReview")
    @ResponseBody
    public String reviewForm(@ModelAttribute Review review) {
        reviewRepository.add(review);
        return "Comment saved!";
    }

    @RequestMapping(value = "/books/review/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getReviews(Book book) {
        List<Review> reviews = reviewService.findAll(book.getId());
        LOGGER.info("new comment was added");
        return new ModelAndView("reviewView", "reviews", reviews);
    }


}
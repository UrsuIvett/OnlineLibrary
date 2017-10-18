package ro.sci.onlinelibrary.service;

import ro.sci.onlinelibrary.model.review.Review;

import java.util.List;

/**
 * Created by Ivett on 17-Oct-17.
 */


public interface ReviewService<T extends Review> {

    List<T> findAll(int id);
    void add (Review review);
}

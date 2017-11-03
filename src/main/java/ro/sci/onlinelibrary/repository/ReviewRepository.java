package ro.sci.onlinelibrary.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import ro.sci.onlinelibrary.model.review.Review;
import ro.sci.onlinelibrary.model.user.User;

import java.util.List;

/**
 * Created by Ivett on 17-Oct-17.
 */
public interface ReviewRepository extends Repository<Review> {

    @Select("SELECT * FROM review where book_id=#{bookId}")
    List<Review> getAll(int bookId);

    @Insert("INSERT INTO review(comment,book_id) values(#{comment},#{bookId})")
    void add(Review review);
}

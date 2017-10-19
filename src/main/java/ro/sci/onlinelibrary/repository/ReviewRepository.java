package ro.sci.onlinelibrary.repository;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import ro.sci.onlinelibrary.model.review.Review;

import java.util.List;

/**
 * Created by iulia on 10/19/2017.
 */
public interface ReviewRepository extends Repository<Review> {

    @Select("SELECT * FROM review where book_id=#{bookId}")
    List<Review> getAll(int bookId);

    @Insert("INSERT INTO review(id,comment,book_id) values(#{id},#{comment},#{bookId})")
    void add (Review review);
}
package ro.sci.onlinelibrary.repository;

import ro.sci.onlinelibrary.model.user.User;

/**
 * Created by iulia on 9/15/2017.
 */

public interface Repository<T> {
        void add(T t);
        void delete(T t);
        void update(T t);
        T searchById(Integer id);
}
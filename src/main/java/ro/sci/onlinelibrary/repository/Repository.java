package ro.sci.onlinelibrary.repository;

/**
 * Created by ivett on 9/15/2017.
 */

public interface Repository<T> {
        void add(T t);
        void delete(int id);
        void update(T t);
        T getById(Integer id);
}
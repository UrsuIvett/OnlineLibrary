package ro.sci.onlinelibrary.repository;

import java.util.List;

/**
 * Created by Ivett on 17-Sep-17.
 */
public interface Repository<T> {
    List<T> getAll();
}

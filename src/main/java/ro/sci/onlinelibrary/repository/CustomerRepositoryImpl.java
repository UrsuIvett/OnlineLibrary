package ro.sci.onlinelibrary.repository;

import ro.sci.onlinelibrary.model.Customer;

import java.util.List;

/**
 * Created by Ivett on 17-Sep-17.
 */
public class CustomerRepositoryImpl<T extends Customer> extends BaseRepository implements CustomerRepository<Customer> {

    public List<Customer> getAll() {
        return null;
    }
}

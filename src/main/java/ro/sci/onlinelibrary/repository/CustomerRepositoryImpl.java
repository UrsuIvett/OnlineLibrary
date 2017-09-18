package ro.sci.onlinelibrary.repository;

import ro.sci.onlinelibrary.model.customer.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iulia on 9/15/2017.
 */
public class CustomerRepositoryImpl implements CustomerRepository<Customer> {
    List<Customer> customers = new ArrayList<Customer>();

    public List<Customer> getAll() {
        return null;
    }

    public List<Customer> getCustomersByLastName() {
        return null;
    }

    public List<Customer> getCustomersByEmail() {
        return null;
    }

    public void add(Customer customer) {
        customers.add(customer);

    }

    public void delete(Customer customer) {
        customers.remove(customer);

    }

    public void update(Customer customer) {
        customers.set(customers.indexOf(customer), customer);

    }
}

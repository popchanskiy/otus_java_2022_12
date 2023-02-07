package homework;

import java.util.*;

public class CustomerReverseOrder {

    private Stack<Customer> customers;

    public CustomerReverseOrder() {
        this.customers = new Stack<>();
    }

    public void add(Customer customer) {
        customers.push(customer);
    }

    public Customer take() {
        return customers.empty() ? null : customers.pop();
    }
}

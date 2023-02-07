package homework;

import java.util.*;

import static homework.Customer.*;

public class CustomerService {
    private TreeMap<Customer, String> customers = new TreeMap<>(Comparator.comparingLong(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        Map.Entry<Customer, String> entry = customers.firstEntry();
        Customer customer = new Customer(entry.getKey());
        return new AbstractMap.SimpleEntry<>(customer, entry.getValue());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        return customer.getScores() > MAX_SCORE ? null : customers.ceilingEntry(customer);
    }


    public void add(Customer customer, String data) {
        if (!customers.containsKey(customer)) {
            customers.put(customer, data);
        }

    }
}


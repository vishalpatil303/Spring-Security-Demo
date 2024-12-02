package in.spring.SpringSecuirty.service;

import in.spring.SpringSecuirty.model.Customer;
import in.spring.SpringSecuirty.repository.CustomerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private PasswordEncoder passwordEncoder;

    public CustomerService(CustomerRepository customerRepository,PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Customer registerCustomer(Customer customer){
        String password = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(password);
        return customerRepository.save(customer);
    }
}

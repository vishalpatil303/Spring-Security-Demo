package in.spring.SpringSecuirty.repository;

import in.spring.SpringSecuirty.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository  extends CrudRepository<Customer,Long> {

    Optional<Customer> findByEmail(String email);
}

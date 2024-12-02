package in.spring.SpringSecuirty.controller;

import in.spring.SpringSecuirty.model.Customer;
import in.spring.SpringSecuirty.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/registerCustomer")
    public ResponseEntity<String> registerCustomer(@RequestBody Customer customer){
    try {
        Customer c = customerService.registerCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(("User is created"));
    } catch (Exception e) {
     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
    }
}

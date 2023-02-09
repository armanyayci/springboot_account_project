package com.project1.account.Controller;

import com.project1.account.Business.abstracts.CustomerService;
import com.project1.account.DTO.CreateCustomerDTO;
import com.project1.account.DTO.CustomerViewDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("create")
    public ResponseEntity<?> createCustomer(@RequestBody CreateCustomerDTO createCustomerDTO){

        customerService.createCustomer(createCustomerDTO);
        return ResponseEntity.ok(createCustomerDTO);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<CustomerViewDTO> getCustomerByID(@PathVariable("id") int id){

        return ResponseEntity.ok(customerService.getCustomer(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<CustomerViewDTO>> getCustomers()
    {
        return ResponseEntity.ok(customerService.getCustomerList());
    }












}

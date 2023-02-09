package com.project1.account.Controller;

import com.project1.account.Business.abstracts.CustomerService;
import com.project1.account.DTO.Customer.CreateCustomerDTO;
import com.project1.account.DTO.Customer.CustomerViewDTO;
import com.project1.account.DTO.Customer.UpdateCustomerDTO;
import com.project1.account.shared.GenericResponse;
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

    @GetMapping("list")
    public ResponseEntity<List<CustomerViewDTO>> getCustomers()
    {
        return ResponseEntity.ok(customerService.getCustomerList());
    }


    @PutMapping("update/{id}")
    public ResponseEntity<CustomerViewDTO> updateCustomer(@PathVariable("id") int id,@RequestBody UpdateCustomerDTO updateCustomerDTO)
    {
        CustomerViewDTO customerViewDTO = customerService.updateCustomer(id,updateCustomerDTO);
        return ResponseEntity.ok(customerViewDTO);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<GenericResponse> deleteCustomer(@PathVariable("id") int id)
    {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok(new GenericResponse("Customer Deleted"));
    }















}

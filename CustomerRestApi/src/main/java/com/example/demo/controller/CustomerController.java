package com.example.demo.controller;



import com.example.demo.customerdto.CustomerDto;
import com.example.demo.customerdto.CustomerDtoMapper;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.serviceimp.servicepackage.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/application")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerDtoMapper customerDtoMapper;


    @GetMapping("/customers")
    public List<CustomerDto> getCustomerDetails(){
        return this.customerService.getCustomerDetails();

    }
    @PostMapping("/add")
    public CustomerEntity createCustomer(@RequestBody CustomerDto customerDto) {
    CustomerEntity customerEntity = customerDtoMapper.toEntity(customerDto);
    customerService.saveCustomer(customerEntity);
        return customerEntity;
    }


    @PutMapping("customer/{id}")
    public CustomerDto updateCustomer(@PathVariable int id , @RequestBody CustomerDto customerDto)
    {
        CustomerDto updatedcustomer = null;
        CustomerDto existingcustomer = customerService.getCustomerById(id);
        if (existingcustomer != null)
        {
            existingcustomer.setCustomerName(customerDto.getCustomerName());
            existingcustomer.setCustomerId(customerDto.getCustomerId());
            existingcustomer.setCustomerAge(customerDto.getCustomerAge());
            updatedcustomer = customerService.updateCustomer(existingcustomer);
        }
        return updatedcustomer;


    }
    @DeleteMapping("deletecustomer/{id}")
    public String deleteCustomer(@PathVariable int id , @RequestBody CustomerDto customerDto)
    {
        CustomerDto exitingCustomer = customerService.getCustomerById(id);
        if (exitingCustomer == null) {
            return "Customer not found";
        }

        customerService.deleteCustomer(id);

        return "Customer deleted successfully";

    }




}

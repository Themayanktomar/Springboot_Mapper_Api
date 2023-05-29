package com.example.demo.serviceimp.servicepackage;

import com.example.demo.customerdto.CustomerDto;
import com.example.demo.entity.CustomerEntity;


import java.util.List;

public interface CustomerService {

     List<CustomerDto> getCustomerDetails();
     CustomerDto saveCustomer(CustomerEntity customer);
     public CustomerDto updateCustomer(CustomerDto customerDto);
     void deleteCustomer(int customerId);
     CustomerDto getCustomerById(int id);

}

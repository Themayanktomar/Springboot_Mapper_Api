package com.example.demo.serviceimp;

import com.example.demo.customerdto.CustomerDto;
import com.example.demo.customerdto.CustomerDtoMapper;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.repository.CustomerRepository;

import com.example.demo.serviceimp.servicepackage.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceImplementation implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerDtoMapper customerDtoMapper ;

    @Override
    public List<CustomerDto> getCustomerDetails() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        return customerEntities.stream()
                .map(customerDtoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto saveCustomer(CustomerEntity customer) {
        CustomerEntity savedCustomer = customerRepository.save(customer);
        return customerDtoMapper.toDTO(savedCustomer);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto1) {
        CustomerEntity existingCustomer = customerRepository.findById(customerDto1.getCustomerId()).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setCustomerName(customerDto1.getCustomerName());
            existingCustomer.setCustomerAge(customerDto1.getCustomerAge());
            CustomerEntity updatedCustomer = customerRepository.save(existingCustomer);
            return customerDtoMapper.toDTO(updatedCustomer);
        }
        return null;


    }


    @Override
    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public CustomerDto getCustomerById(int id) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        return customerEntity.map(customerDtoMapper::toDTO).orElse(null);
    }


}

//package com.example.demo.controller;
//
//import com.example.demo.customerdto.CustomerDto;
//import com.example.demo.customerdto.CustomerDtoMapper;
//import com.example.demo.entity.CustomerEntity;
//import com.example.demo.serviceimp.servicepackage.CustomerService;
//import jakarta.inject.Inject;
//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//class CustomerControllerTest {
//    @Mock
//    private CustomerService customerService;
//
//    @Mock
//    CustomerDtoMapper customerDtoMapper;
//
//    @InjectMocks
//    CustomerController customerController;
//
//    @BeforeEach
//    public void setUp()
//    {
//        MockitoAnnotations.initMocks(this);
//    }
//
//
//
//    @Test
//    void getCustomerDetails() {
//        List<CustomerDto> expected = Arrays.asList(
//                new CustomerDto(1, "Alice", 25),
//                new CustomerDto(2, "Bob", 30));
//        when(customerService.getCustomerDetails()).thenReturn(expected);
//
//        // Act
//        List<CustomerDto> actual = customerController.getCustomerDetails();
//
//        // Assert
//        assertEquals(expected.size(), actual.size());
//        for (int i = 0; i < expected.size(); i++) {
//            CustomerDto expectedDto = expected.get(i);
//            CustomerDto actualDto = actual.get(i);
//            assertEquals(expectedDto.getCustomerid(), actualDto.getCustomerid());
//            assertEquals(expectedDto.getCustomer_name(), actualDto.getCustomer_name());
//            assertEquals(expectedDto.getCustomer_age(), actualDto.getCustomer_age());
//        }
//    }
//
//    @Test
//    void createCustomer() {
//        // Arrange
//        CustomerDto inputDto = new CustomerDto(3, "Charlie", 35);
//        CustomerEntity inputEntity = new CustomerEntity(3, "Charlie", 35);
//        when(customerDtoMapper.toEntity(inputDto)).thenReturn(inputEntity);
//
//        CustomerDto expectedDto = new CustomerDto(3, "Charlie", 35);
//        CustomerEntity expectedEntity = new CustomerEntity(3, "Charlie", 35);
//        when(customerService.saveCustomer(inputEntity)).thenReturn(expectedEntity);
//        when(customerDtoMapper.toDTO(expectedEntity)).thenReturn(expectedDto);
//
//        // Act
//        CustomerDto actualDto = customerController.createCustomer(inputDto);
//
//        // Assert
//        assertEquals(expectedDto.getCustomerid(), actualDto.getCustomerid());
//        assertEquals(expectedDto.getCustomer_name(), actualDto.getCustomer_name());
//        assertEquals(expectedDto.getCustomer_age(), actualDto.getCustomer_age());
//    }
//    }
//
//
//    @Test
//    void updateCustomer() {
//    }
//}

package com.example.demo.customerdto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data
public class CustomerDto {
    private int customerId;
    private String customerName;

    private int customerAge;



}

package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customerinfo")
public class CustomerEntity {

    @Id
    @Column(name = "customerid")
    private int customerId;
    @Column(name = "customer_name")
    private  String customerName;
    @Column(name = "customer_age")
    private int customerAge;
}

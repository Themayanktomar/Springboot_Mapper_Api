package com.example.demo.customerdto;

import com.example.demo.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerDtoMapper {
    @Mapping(source = "customerId", target = "customerId")
    @Mapping(source = "customerName", target = "customerName")
    @Mapping(source = "customerAge", target = "customerAge")
    CustomerDto toDTO(CustomerEntity customerEntity);


    @Mapping(source = "customerId", target = "customerId")
    @Mapping(source = "customerName", target = "customerName")
    @Mapping(source = "customerAge", target = "customerAge")
    CustomerEntity toEntity(CustomerDto customerDto);


}




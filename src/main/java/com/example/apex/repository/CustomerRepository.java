package com.example.apex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apex.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    //testing git push

}

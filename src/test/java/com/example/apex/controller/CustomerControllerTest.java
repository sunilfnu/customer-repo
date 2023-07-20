package com.example.apex.controller;

import com.example.apex.model.Customer;
import com.example.apex.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CustomerControllerTest {

    //Sunil change


    
    /*
    * Roshan's Change
    * */

    /**
     *  Method Signature
     *  1) When invoking that method, what arguments to pass
     *  2) What is the return type
     *  3) Visibility of that method
     * */



    /**
     *  3As principle
     *  Arrange
     *  Act
     *  Assert
     * */

    @Mock CustomerRepository repo;
    @InjectMocks CustomerController controller;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateCustomer(){
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("Thoth");

        Customer savedCustomer = new Customer();
        savedCustomer.setId(1001L);
        savedCustomer.setFirstName("Thoth");

        when(repo.save(any())).thenReturn(savedCustomer);

        // Act
        Customer actual = controller.createCustomer(customer);

        // Assert
        assertEquals(actual.getId(), savedCustomer.getId());
        assertEquals(actual.getFirstName(), savedCustomer.getFirstName());
    }


    //test2

    @Test
    void testFindById() {
        long id = 1001l;

        Customer returnedCustomer = new Customer();
        returnedCustomer.setId(1001L);
        returnedCustomer.setFirstName("Thoth");

        when(repo.findById(any())).thenReturn(Optional.of(returnedCustomer));

        // Act
        Customer customer = controller.getById(id);

        //Assert
        assertEquals(id, customer.getId());
    }



    //test3
}
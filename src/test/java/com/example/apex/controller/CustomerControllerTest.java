package com.example.apex.controller;

import com.example.apex.model.Customer;
import com.example.apex.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CustomerControllerTest {
    private Logger logger = LoggerFactory.getLogger(CustomerControllerTest.class);

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
        logger.info("Inside test create...");
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("Thoth");

        Customer savedCustomer = new Customer();
        savedCustomer.setId(1001L);
        savedCustomer.setFirstName("Thoth");

        logger.info("After customer is created...");

        when(repo.save(any())).thenReturn(savedCustomer);

        // Act
        Customer actual = controller.createCustomer(customer);

        // Assert
        assertEquals(actual.getId(), savedCustomer.getId());
        assertEquals(actual.getFirstName(), savedCustomer.getFirstName());
    }


    //test2


    //test3
}
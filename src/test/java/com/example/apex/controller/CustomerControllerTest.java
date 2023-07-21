package com.example.apex.controller;

import com.example.apex.model.Customer;
import com.example.apex.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CustomerControllerTest {

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


    @Test
    void testGetAllCustomer(){
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setFirstName("Andrew");

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setFirstName("Austin");

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);

        Mockito.when(repo.findAll()).thenReturn(customerList);

        List<Customer> customer = controller.getAll();

        assertEquals(2, customer.size());
        assertEquals(customer, customerList);
        Mockito.verify(repo, Mockito.times(1)).findAll();
    }
}
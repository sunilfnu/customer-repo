package com.example.apex.controller;

import com.example.apex.model.Customer;
import com.example.apex.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CustomerControllerTest {
    private Logger logger = LoggerFactory.getLogger(CustomerControllerTest.class);
    //Suranjan Change123
    /*
    * Roshan Change
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
        logger.info("Inside test create...");
        // Arrange
        //Creating Customer
        //adfasdf
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

    @Test
    void testFindById() {
        logger.info("Inside test find by Id");
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


    //Pushed the code so that easier to pull rather than see my screen
    //I am confused on this method. Specifically, on how to test this method, because it has no return type, so
    // return null rakhne ki k rakhne also Mockito.when garda k rakhne
    @Test
    void testDeleteCustomerById(){
        long id = 120L;
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("Austin");

        //Mockito.when(repo.deleteById(id)).thenReturn(null);

        controller.deleteById(id);

        Mockito.verify(repo, Mockito.times(1)).deleteById(Mockito.anyLong());
    }
}
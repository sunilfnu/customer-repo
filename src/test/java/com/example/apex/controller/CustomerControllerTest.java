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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CustomerControllerTest {
    private Logger logger = LoggerFactory.getLogger(CustomerControllerTest.class);
    @Mock
    CustomerRepository repo;
    @InjectMocks
    CustomerController controller;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);  // mockito initializes mocks before the execution of each individual test method.
    }
    @Test // how to test it orderly?

    public void testCreateCustomer(){

        Customer customer = Customer.builder().id(10L).firstName("nish").lastName("ghi").emailId("n@gmail.com").build();
        Customer expcustomer = Customer.builder().id(10L).firstName("nish").lastName("ghi").emailId("n@gmail.com").build();
        when(repo.save(any())).thenReturn(expcustomer);
        //Act
        Customer actual = controller.createCustomer(customer);
        //Assert
        assertEquals(expcustomer.getId(),actual.getId());
        assertEquals(expcustomer.getFirstName(),actual.getFirstName());
        assertEquals(expcustomer.getLastName(),actual.getLastName());
    }

    @Test
    public void testGetAllCustomer() {
        Customer customer1 = Customer.builder().id(1L).firstName("nis").build();
        Customer customer2 = Customer.builder().id(2L).firstName("nik").build();

        List<Customer> customerList = Arrays.asList(customer1, customer2);
        when(repo.findAll()).thenReturn(customerList);
        List<Customer> customers = controller.getAll();
        assertEquals(2, customers.size());
        assertEquals(customerList, customers);
        Mockito.verify(repo, Mockito.times(1)).findAll();
    }
    @Test
    public void testDeleteCustomerById(){
        long id = 120L;
        Customer customer = Customer.builder().id(120L).firstName("niki").lastName("priya").build();
        Customer expecCustomer = Customer.builder().id(120L).firstName("niki").lastName("priya").build();
        controller.deleteById(id);
        Mockito.verify(repo, Mockito.times(1)).deleteById(Mockito.anyLong());
    }

    @Test
    public void testFindById(){
        Customer customer = Customer.builder().id(12L).firstName("nis").lastName("ghi").build();
        Customer  expectedCustomer = Customer.builder().id(12L).firstName("nis").lastName("ghi").build();
        logger.info("find byid is executed");
        when(repo.findById(12L)).thenReturn(Optional.of(expectedCustomer));
        Customer actualCust = controller.getById(12L);
        assertEquals(expectedCustomer.getId(),actualCust.getId());

    }
    @Test
    public void testUpdateCustomer(){
        // we  give this below value
        Customer customer = Customer.builder().id(2L).firstName("nishchal").lastName("Ghimire").build();
        // again test against the give above value.
        Customer expectedCustomer = Customer.builder().id(2L).firstName("nishchal").lastName("Ghimire").build();
        logger.info("After the customer is updated");

        when(repo.save(any(Customer.class))).thenReturn(expectedCustomer);
        //Act
        Customer actual = controller.updateCustomer(customer);
        //Assert
        assertEquals(expectedCustomer.getId(),actual.getId());
        assertEquals(expectedCustomer.getFirstName(),actual.getFirstName());
        assertEquals(expectedCustomer.getLastName(),actual.getLastName());

    }

}
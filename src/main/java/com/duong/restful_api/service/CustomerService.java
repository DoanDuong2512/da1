package com.duong.restful_api.service;

import com.duong.restful_api.entity.Customer;
import com.duong.restful_api.entity.User;
import com.duong.restful_api.exception.NotFoundException;
import com.duong.restful_api.model.dto.CustomerDto;
import com.duong.restful_api.model.dto.UserDto;
import com.duong.restful_api.model.request.CreateCustomerRequest;
import com.duong.restful_api.model.request.CreateUserRequest;
import com.duong.restful_api.model.request.UpdateCustomerRequest;
import com.duong.restful_api.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<CustomerDto> getListCustomers(){
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> result = new ArrayList<>();
        for (Customer customer : customers) {
            result.add(modelMapper.map(customer, CustomerDto.class));
        }
        return result;
    }
    public CustomerDto getCustomerById(int id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new NotFoundException("Khong thay");
        }
        return modelMapper.map(customer, CustomerDto.class);
    }


    public List<CustomerDto> searchCustomer(String keyword) {
        List<Customer> customers = customerRepository.findByFirstNameContainingOrLastNameContaining(keyword);
        List<CustomerDto> result = new ArrayList<>();
        for (Customer customer : customers) {
            result.add(modelMapper.map(customer, CustomerDto.class));
        }
        return result;
    }

    public CustomerDto createCustomer(CreateCustomerRequest req) {
        Customer customer = new Customer();
        customer.setFirstName(req.getFirstName());
        customer.setLastName(req.getLastName());
        customer.setPhone(req.getPhone());
        customer.setEmail(req.getEmail());
        customer.setAddress(req.getAddress());
        customer.setRegistrationDate(req.getRegistrationDate());
        customerRepository.save(customer);
        return modelMapper.map(customer, CustomerDto.class);
    }
    public CustomerDto updateCustomer(int id, UpdateCustomerRequest req) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new NotFoundException("Khong thay");
        }
        customer.setFirstName(req.getFirstName());
        customer.setLastName(req.getLastName());
        customer.setPhone(req.getPhone());
        customer.setEmail(req.getEmail());
        customer.setAddress(req.getAddress());
        customer.setRegistrationDate(req.getRegistrationDate());
        customerRepository.save(customer);
        return modelMapper.map(customer, CustomerDto.class);
    }

    public void deleteCustomer(int id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new NotFoundException("Khong thay");
        }
        customerRepository.delete(customer);
    }
}

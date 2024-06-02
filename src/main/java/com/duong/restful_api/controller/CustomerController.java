package com.duong.restful_api.controller;
import com.duong.restful_api.model.dto.CustomerDto;
import com.duong.restful_api.model.dto.UserDto;
import com.duong.restful_api.model.request.CreateCustomerRequest;
import com.duong.restful_api.model.request.UpdateCustomerRequest;
import com.duong.restful_api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<?> getListCustomers() {
        List<CustomerDto> customers = customerService.getListCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchCustomer(@RequestParam(name = "keyword", required = false, defaultValue = "") String keyword) {
        List<CustomerDto> customers = customerService.searchCustomer(keyword);
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable int id) {
        CustomerDto result = customerService.getCustomerById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity<?> createCustomer(@Validated @RequestBody CreateCustomerRequest req) {
        CustomerDto result = customerService.createCustomer(req);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable int id, @Validated @RequestBody UpdateCustomerRequest req) {
        List<CustomerDto> result = (List<CustomerDto>) customerService.updateCustomer(id, req);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Xoa thanh cong");
    }
}

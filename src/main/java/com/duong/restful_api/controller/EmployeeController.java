package com.duong.restful_api.controller;
import com.duong.restful_api.model.dto.CustomerDto;
import com.duong.restful_api.model.dto.UserDto;
import com.duong.restful_api.model.dto.EmployeeDto;
import com.duong.restful_api.model.request.CreateEmployeeRequest;
import com.duong.restful_api.model.request.UpdateEmployeeRequest;
import com.duong.restful_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getListEmployees() {
        List<EmployeeDto> employees = employeeService.getListEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchEmployee(@RequestParam(name = "name", required = false, defaultValue = "") String keyword) {
        List<EmployeeDto> employees = employeeService.searchEmployee(keyword);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int id) {
        EmployeeDto result = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> createEmployee(@Validated @RequestBody CreateEmployeeRequest req) {
        EmployeeDto result = employeeService.createEmployee(req);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable int id, @Validated @RequestBody UpdateEmployeeRequest req) {
        EmployeeDto result = employeeService.updateEmployee(id, req);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Xoa nhan vien thanh cong");
    }
}
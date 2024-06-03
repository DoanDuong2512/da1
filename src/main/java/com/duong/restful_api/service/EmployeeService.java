package com.duong.restful_api.service;

import com.duong.restful_api.entity.Customer;
import com.duong.restful_api.entity.Employee;
import com.duong.restful_api.exception.NotFoundException;
import com.duong.restful_api.model.dto.CustomerDto;
import com.duong.restful_api.model.dto.EmployeeDto;
import com.duong.restful_api.model.request.CreateEmployeeRequest;
import com.duong.restful_api.model.request.UpdateEmployeeRequest;
import com.duong.restful_api.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<EmployeeDto> getListEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> result = new ArrayList<>();
        for (Employee employee : employees) {
            result.add(modelMapper.map(employee, EmployeeDto.class));
        }
        return result;
    }

    public EmployeeDto getEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            throw new NotFoundException("Không tìm thấy nhân viên");
        }
        return modelMapper.map(employee, EmployeeDto.class);
    }

    public List<EmployeeDto> searchEmployee(String keyword) {
        List<Employee> employees = employeeRepository.findByFirstNameContainingOrLastNameContaining(keyword);
        List<EmployeeDto> result = new ArrayList<>();
        for (Employee employee : employees) {
            result.add(modelMapper.map(employee, EmployeeDto.class));
        }
        return result;
    }

    public EmployeeDto createEmployee(CreateEmployeeRequest req) {
        Employee employee = new Employee();
        employee.setFirstName(req.getFirstName());
        employee.setLastName(req.getLastName());
        employee.setPosition(req.getPosition());
        employee.setPhone(req.getPhone());
        employee.setEmail(req.getEmail());
        employee.setHireDate(req.getHireDate());
        employee.setSalary(req.getSalary());
        employeeRepository.save(employee);
        return modelMapper.map(employee, EmployeeDto.class);
    }

    public EmployeeDto updateEmployee(int id, UpdateEmployeeRequest req) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            throw new NotFoundException("Không tìm thấy nhân viên");
        }
        employee.setFirstName(req.getFirstName());
        employee.setLastName(req.getLastName());
        employee.setPosition(req.getPosition());
        employee.setPhone(req.getPhone());
        employee.setEmail(req.getEmail());
        employee.setHireDate(req.getHireDate());
        employee.setSalary(req.getSalary());
        employeeRepository.save(employee);
        return modelMapper.map(employee, EmployeeDto.class);
    }

    public void deleteEmployee(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            throw new NotFoundException("Không tìm thấy nhân viên");
        }
        employeeRepository.delete(employee);
    }
}
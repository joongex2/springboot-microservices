package net.javaguides.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.mapper.AutoEmployeeMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        // convert dto to employee
//        Employee employee = new Employee(
//                employeeDto.getId(),
//                employeeDto.getFirstName(),
//                employeeDto.getLastName(),
//                employeeDto.getEmail()
//        );

        // Employee employee = modelMapper.map(employeeDto, Employee.class);

        Employee employee = AutoEmployeeMapper.MAPPER.employeeDtoToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        // convert employee to dto
//        EmployeeDto savedEmployeeDto = new EmployeeDto(
//                savedEmployee.getId(),
//                savedEmployee.getFirstName(),
//                savedEmployee.getLastName(),
//                savedEmployee.getEmail()
//        );

        // EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class);

        EmployeeDto savedEmployeeDto = AutoEmployeeMapper.MAPPER.employeeToEmployeeDto(savedEmployee);

        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeebyId(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

//        EmployeeDto employeeDto = new EmployeeDto(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail()
//        );

        // EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.employeeToEmployeeDto(employee);

        return employeeDto;
    }
}

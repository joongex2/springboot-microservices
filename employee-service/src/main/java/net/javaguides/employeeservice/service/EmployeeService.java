package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employee);

    EmployeeDto getEmployeebyId(Long employeeId);
}

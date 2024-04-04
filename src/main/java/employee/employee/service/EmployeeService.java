package employee.employee.service;

import employee.employee.domain.EmployeeDetails;
import employee.employee.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDetails> getAllEmployee();

    List<String> getAllNames();

    EmployeeDto registerEmployee(EmployeeDto employeeDto);

    EmployeeDto updateEmployee(EmployeeDto employeeDto);

    EmployeeDto deleteEmployee(int id);

    EmployeeDto findById(int id);
}

package employee.employee.controller;

import employee.employee.domain.EmployeeDetails;
import employee.employee.dto.EmployeeDto;
import employee.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDetails>> getallemployee() {
        return ResponseEntity.ofNullable(employeeService.getAllEmployee());
    }

    @GetMapping("/allnames")
    public ResponseEntity<List<String>> getAllNames() {
        return ResponseEntity.ok(employeeService.getAllNames());
    }

    @PostMapping("/register")
    public ResponseEntity<EmployeeDto> registerEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto registeredEmployee = employeeService.registerEmployee(employeeDto);
        return ResponseEntity.ok(registeredEmployee);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeDto> updateemployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto updatedEmployee = employeeService.updateEmployee(employeeDto);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable int id) {
        EmployeeDto deletedEmployee = employeeService.deleteEmployee(id);
        return ResponseEntity.ok(deletedEmployee);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable int id) {
        EmployeeDto employeeDto = employeeService.findById(id);
        return ResponseEntity.ok(employeeDto);
    }


}

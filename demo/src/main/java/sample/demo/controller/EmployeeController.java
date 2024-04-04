package sample.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.demo.domain.EmployeeDetails;
import sample.demo.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<List<EmployeeDetails>> getAllEmployee() {
        return ResponseEntity.of(Optional.ofNullable(employeeService.getAllEmployees()));
    }
}

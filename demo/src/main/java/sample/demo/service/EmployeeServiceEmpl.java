package sample.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.demo.domain.EmployeeDetails;
import sample.demo.repo.EmployeeRepo;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceEmpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public List<EmployeeDetails> getAllEmployees() {
        log.info("totla number of employee found "+String.valueOf(employeeRepo.findAll().size()));
        return employeeRepo.findAll();
    }
}

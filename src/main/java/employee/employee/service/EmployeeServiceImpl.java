package employee.employee.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import employee.employee.domain.EmployeeDetails;
import employee.employee.dto.EmployeeDto;
import employee.employee.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<EmployeeDetails> getAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public List<String> getAllNames() {
        return employeeRepo.getNames();
    }

    @Override
    public EmployeeDto registerEmployee(EmployeeDto employeeDto) {

        Assert.notNull(employeeDto, "Employee Cannot be null");
        Assert.notNull(employeeDto.getName(), "User name Canner be null");
        Assert.notNull(employeeDto.getEmail(), "email connot be null");
        Assert.notNull(employeeDto.getPhone(), "phone number cannot be null");
        Assert.notNull(employeeDto.getSalary(), "salary cannot be null");

        EmployeeDetails employeeDetails = objectMapper.convertValue(employeeDto, EmployeeDetails.class);
        employeeRepo.save(employeeDetails);
        employeeDto = objectMapper.convertValue(employeeDetails, EmployeeDto.class);
        return employeeDto;
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Assert.notNull(employeeDto, "Employee Cannot be null");
        Assert.notNull(employeeDto.getName(), "User name Canner be null");
        Assert.notNull(employeeDto.getEmail(), "email connot be null");
        Assert.notNull(employeeDto.getPhone(), "phone number cannot be null");
        Assert.notNull(employeeDto.getSalary(), "salary cannot be null");

        EmployeeDetails employeeDetails = objectMapper.convertValue(employeeDto, EmployeeDetails.class);
        employeeRepo.save(employeeDetails);
        employeeDto = objectMapper.convertValue(employeeDetails, EmployeeDto.class);
        return employeeDto;

    }

    @Override
    public EmployeeDto deleteEmployee(int id) {
        Optional<EmployeeDetails> employeeDetails = employeeRepo.findById(id);
        EmployeeDto employeeDto = objectMapper.convertValue(employeeDetails, EmployeeDto.class);
        employeeRepo.deleteById(id);

        return employeeDto;
    }

    @Override
    public EmployeeDto findById(int id) {

        Optional<EmployeeDetails> employeeDetails = employeeRepo.findById(id);
        EmployeeDto employeeDto = objectMapper.convertValue(employeeDetails, EmployeeDto.class);

        employeeDto.setId(employeeDetails.get().getId());
        employeeDto.setName(employeeDetails.get().getName());
        employeeDto.setEmail(employeeDetails.get().getEmail());
        employeeDto.setSalary(employeeDetails.get().getSalary());
        employeeDto.setPhone(employeeDetails.get().getPhone());


        log.info(employeeDto.getName() + "--------name ----------");
        log.info(employeeDetails.get().getName());
        log.info(employeeDto.getEmail() + "-------------emial-------");
        log.info(employeeDto.getSalary() + "=======================salary=========");
        return employeeDto;
    }
}

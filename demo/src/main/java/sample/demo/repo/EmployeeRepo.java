package sample.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.demo.domain.EmployeeDetails;

public interface EmployeeRepo extends JpaRepository<EmployeeDetails,Integer> {

}

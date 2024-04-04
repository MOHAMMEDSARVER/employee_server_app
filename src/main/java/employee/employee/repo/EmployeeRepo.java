package employee.employee.repo;

import employee.employee.domain.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<EmployeeDetails, Integer> {
    @Query("select p.name from EmployeeDetails p")
    List<String> getNames();
}

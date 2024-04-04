package employee.employee.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.UUID;

import static java.util.UUID.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "salary")
    private String salary;


    @PrePersist
    public void onPersist() {
        Random random = new Random();
        int min = 1; // Minimum value
        int max = 20000; // Maximum value
        int randomInt = random.nextInt(max - min + 1) + min;
        this.id = randomInt;
    }

}

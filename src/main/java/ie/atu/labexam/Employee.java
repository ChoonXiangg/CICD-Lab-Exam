package ie.atu.labexam;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String employeeCode;
    @Size(min = 1, max = 100, message = "Size of name must be between 1 and 100")
    private String name;
    @Email(message = "Email must be email")
    private String email;
    private String position;
    @Positive(message = "Salary must be positive")
    private float salary;
    private Date dateOfJoining;
}

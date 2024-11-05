package ie.atu.labexam;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService myService;
    private List<Employee> employeeList = new ArrayList();
    private Map<String, String> errorList = new HashMap<>();
    public EmployeeController(EmployeeService myService){
        this.myService = myService;
    }
    @PostMapping
    public Map<String, String> addEmployee(@Valid @RequestBody Employee employee){
        employeeList = myService.addEmployee(employee);
        errorList.put("message", "Employee added successfully");
        errorList.put("employeeCode", "");
        errorList.put("timestamp", "");
        return errorList;
    }
    @GetMapping("/{employeeCode}")
    public List<Employee> retrieveEmployee(@Valid @RequestBody Employee employee, @PathVariable String employeeCode){
        employeeList = myService.retrieveEmployee(employee, employeeCode);
        return employeeList;
    }
    @PutMapping("/{employeeCode}")
    public Map<String, String> updateEmployee(@Valid @RequestBody Employee employee, @PathVariable String employeeCode){
        employeeList = myService.updateEmployee(employee, employeeCode);
        errorList.put("message", "Employee updated successfully");
        errorList.put("employeeCode", "");
        errorList.put("timestamp", "");
        return errorList;
    }
    @DeleteMapping("/{employeeCode}")
    public Map<String, String> removeEmployee(@Valid @RequestBody Employee employee, @PathVariable String employeeCode){
        employeeList = myService.updateEmployee(employee, employeeCode);
        errorList.put("message", "Employee deleted successfully");
        errorList.put("employeeCode", "");
        errorList.put("timestamp", "");
        return errorList;
    }
}

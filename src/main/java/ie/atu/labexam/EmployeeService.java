package ie.atu.labexam;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> myList = new ArrayList();
    public List<Employee> addEmployee(Employee employee){
        myList.add(employee);
        return myList;
    }
    public List<Employee> retrieveEmployee(Employee employee, String employeeCode){
        for(Employee e : myList){
            if(e.getEmployeeCode().equals(employeeCode)){
                myList.add(e);
            }
        }
        return myList;
    }
    public List<Employee> updateEmployee(Employee employee, String employeeCode){
        for(Employee e : myList){
            if(e.getEmployeeCode().equals(employeeCode)){
                myList.remove(e);
            }
        }
        myList.add(employee);
        return myList;
    }
    public List<Employee> removeEmployee(Employee employee, String employeeCode){
        for(Employee e : myList){
            if(e.getEmployeeCode().equals(employeeCode)){
                myList.remove(e);
            }
        }
        return myList;
    }
}

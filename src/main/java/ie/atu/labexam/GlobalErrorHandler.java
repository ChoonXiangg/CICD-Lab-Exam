package ie.atu.labexam;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> display(MethodArgumentNotValidException ex){
        Map<String, String> errorList = new HashMap<>();
        errorList.put("error","InvalidEmployeeDataException");
        for(FieldError error:ex.getBindingResult().getFieldErrors()){
            String errorMessage = error.getDefaultMessage();
            errorList.put("message", errorMessage);
        }
        errorList.put("timestamp", "");
        errorList.put("status", "400");
        return ResponseEntity.status(400).body(errorList);
    }
    public ResponseEntity<Map<String, String>> display2(ClassNotFoundException ex){
        Map<String, String> errorList = new HashMap<>();
        errorList.put("error","EmployeeNotFoundException");
        errorList.put("message", "Employee with code not found");
        errorList.put("timestamp", "");
        errorList.put("status", "404");
        return ResponseEntity.status(404).body(errorList);
    }
}

package com.CodeDecode_CRUD.demo.Controller;

import com.CodeDecode_CRUD.demo.Entity.Employee;
import com.CodeDecode_CRUD.demo.Exception.BusinessException;
import com.CodeDecode_CRUD.demo.Exception.ControllerException;
import com.CodeDecode_CRUD.demo.Service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/code")
public class EmployeeController
{
    @Autowired
    private EmployeeServiceInterface employeeServiceInterface;

    // To Create a Employee Entity.
    @PostMapping("/save")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
    {
            Employee employeeSaved = employeeServiceInterface.addEmployee(employee);
            return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
    }


    // To get all the Employees
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        List<Employee> allEmployees = employeeServiceInterface.getAllEmployees();
        return new ResponseEntity<List<Employee>> (allEmployees, HttpStatus.OK);
    }


    // To get all the Employee by Id
    @GetMapping("/emp/{empId}")
    public ResponseEntity<Employee> getEmpById(@PathVariable ("empId") Long empId)
    {
            Employee empRetrieved = employeeServiceInterface.getEmpById(empId);
            return new ResponseEntity<Employee>(empRetrieved, HttpStatus.OK);
    }


    // To delete an employee of a particular Id
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<Void> deleteEmpById(@PathVariable ("empId") Long empId)
    {
        employeeServiceInterface.deleteEmpById(empId);
        return new ResponseEntity<Void> (HttpStatus.ACCEPTED);
    }


    // To update the Employee entity
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
    {
        Employee employeeSaved = employeeServiceInterface.addEmployee(employee);
        return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
    }
}

package com.rutik.jpademo.employee;

import com.rutik.product_management.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan

@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public void addProduct(Employee employee){
        employeeService.addEmployee(employee);
    }
    @PutMapping(("/update/{id}"))
    public void updateProduct(@PathVariable int id, @RequestBody Employee employee){
        employeeService.updateEmployee(id, employee);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }
    @GetMapping("/get/{id}")
    public Employee get(@PathVariable int id){
        return employeeService.getEmployee(id);
    }
    @GetMapping("/getall")
    List<Employee> getProducts(){
        return employeeService.getEmployees();
    }
}

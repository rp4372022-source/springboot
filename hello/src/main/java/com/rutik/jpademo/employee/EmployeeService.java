package com.rutik.jpademo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo repo;

    public void addEmployee(Employee employee) {
        repo.save(employee);
    }
    public void updateEmployee(int id, Employee employee) {
        repo.save(employee); //same it checks if employee exists
    }
    public void deleteEmployee(int id) {
        repo.deleteById(id);
    }
    public List<Employee> getEmployees(){
        return repo.findAll();
    }
    public Employee getEmployee(int id){
        return repo.findById(id).orElse(new Employee());
    }
}

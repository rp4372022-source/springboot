package com.rutik.jdbctemplate.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

@Repository
public class EmployeeRepo {

    JdbcTemplate template;

    private JdbcTemplate getTemplate() {
        return template;
    }
    @Autowired
    private void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employees(id, name, role) VALUES (?, ?, ?);";
        template.update(sql, employee.getId(), employee.getName(), employee.getRole());
    }
    public void updateEmployee(int id, Employee employee) {
        String sql = "UPDATE employees SET name = ?, role= ? WHERE id = ?;";
        template.update(sql, employee.getName(), employee.getRole(), id);
    }
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?;";
        template.update(sql, id);
    }
    public List<Employee> getEmployees(){
        String sql = "SELECT * FROM employees";
        //row mapper
//        RowMapper<Employee> mapper = new RowMapper<Employee>() {
//            @Override
//            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
//                return new Employee(
//                        rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3)
//                );
//            }
//        };
//        List<Employee> employeeList = template.query(sql, mapper);
//        return employeeList;

        //shoter version
        return template.query(sql, ((rs, rowNum) ->
            new Employee(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3)
            )
        ));
    }
    public Employee getEmployee(int id){

        String sql = "SELECT * FROM employees WHERE id = ?;";

        List<Employee> employees = template.query(
            sql,
            (rs, rowNum) -> new Employee(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3)
            ),
            id
        );

        return employees.removeFirst();
    }
}

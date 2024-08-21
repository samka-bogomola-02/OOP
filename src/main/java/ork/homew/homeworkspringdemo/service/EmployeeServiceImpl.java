package ork.homew.homeworkspringdemo.service;

import org.springframework.stereotype.Service;
import ork.homew.homeworkspringdemo.exception.EmployeeAlreadyAddedException;
import ork.homew.homeworkspringdemo.exception.EmployeeNotFoundException;
import ork.homew.homeworkspringdemo.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import java.util.Collection;
import java.util.Collections;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employeeList;
    public EmployeeServiceImpl() {
        this.employeeList = new ArrayList<>();
    }
    @Override
    public Employee add(String name, String lastName) {
        Employee employee = new Employee(name, lastName);
        if (employeeList.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        }
        employeeList.add(employee);
        return employee;
    }
    @Override
    public Employee remove(String name, String lastName) {
        Employee employee = new Employee(name, lastName);
        if (employeeList.contains(employee)){
            employeeList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }
    @Override
    public Employee find(String name, String lastName) {
        Employee employee = new Employee(name, lastName);
        if (employeeList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employeeList);
    }
}
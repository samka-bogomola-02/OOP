package ork.homew.homeworkspringdemo.service;

import org.springframework.stereotype.Service;
import ork.homew.homeworkspringdemo.exception.EmployeeAlreadyAddedException;
import ork.homew.homeworkspringdemo.exception.EmployeeNotFoundException;
import ork.homew.homeworkspringdemo.model.Employee;

import java.util.*;

import java.util.Collection;
import java.util.Collections;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String name, String lastName) {
        Employee employee = new Employee(name, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String name, String lastName) {
        Employee employee = new Employee(name, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String name, String lastName) {
        Employee employee = new Employee(name, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
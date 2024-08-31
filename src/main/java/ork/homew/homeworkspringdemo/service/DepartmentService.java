package ork.homew.homeworkspringdemo.service;

import org.springframework.stereotype.Service;
import ork.homew.homeworkspringdemo.model.Employee;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;


    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public Employee getMaxSalaryEmployee(int departmentId) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
               .max(Comparator.comparingDouble(x -> x.getSalary()))
                .orElseThrow(() -> new RuntimeException("ошибочка вышла :("));
    }

    public Employee getMinSalaryEmployee(int departmentId) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .min(Comparator.comparingDouble(x -> x.getSalary()))
                .orElseThrow(() -> new RuntimeException("здесь пусто"));
    }

    public List<Employee> getAllDepartmentEmployee(int departmentId) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeService.findAll().stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartmentId()));
    }

}

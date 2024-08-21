package ork.homew.homeworkspringdemo.service;

import ork.homew.homeworkspringdemo.model.Employee;

import java.util.Collection;

public interface EmployeeService{
    Employee add(String name, String lastName);
    Employee remove(String name, String lastName);
    Employee find(String name, String lastName);

    Collection<Employee> findAll();
}

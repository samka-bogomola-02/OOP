package ork.homew.homeworkspringdemo.model;

import java.util.Objects;

public class Employee {
    private final String name;
    private final String lastName;
    private int departmentId;
    private double salary;

    public Employee(String name, String lastName, int departmentId, double salary) {
        this.name = name;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return name + " " + lastName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int department) {
        this.departmentId = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return departmentId == employee.departmentId && Double.compare(salary, employee.salary)
                == 0 && Objects.equals(name, employee.name) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, departmentId, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + departmentId +
                ", salary=" + salary +
                '}';
    }
}

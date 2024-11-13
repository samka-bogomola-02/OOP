package ka.irissin.testmockitodemo.service;


import ka.irissin.testmockitodemo.exception.EmployeeAlreadyAddedException;
import ka.irissin.testmockitodemo.exception.EmployeeNotFoundException;
import ka.irissin.testmockitodemo.exception.EmployeeStorageIsFullException;
import model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void setUp() {
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee("John", "Doe", 1, 50000);
        assertEquals(employee, employeeService.add(employee));
        assertEquals(1, employeeService.getAll().size());
    }

    @Test
    public void testAddEmployeeAlreadyExists() {
        Employee employee = new Employee("John", "Doe", 1, 50000);
        employeeService.add(employee);

        assertThrows(EmployeeAlreadyAddedException.class, () -> {
            employeeService.add(employee);
        });
    }

    @Test
    public void testAddEmployeeStorageIsFull() {
        for (int i = 0; i < 5; i++) {
            employeeService.add(new Employee("Employee" + i, "LastName" + i, 1, 50000));
        }

        assertThrows(EmployeeStorageIsFullException.class, () -> {
            employeeService.add(new Employee("Overflow", "Employee", 1, 50000));
        });
    }

    @Test
    public void testFindEmployee() {
        Employee employee = new Employee("John", "Doe", 1, 50000);
        employeeService.add(employee);

        assertEquals(employee, employeeService.find("John", "Doe"));
    }

    @Test
    public void testFindEmployeeNotFound() {
        assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.find("Nonexistent", "Employee");
        });
    }

    @Test
    void testAddReturnsNull() {
        String firstName = "John";
        String lastName = "Doe";
        int department = 1;
        int salary = 50000;

        // Act
        Employee employee = employeeService.add(firstName, lastName, department, salary);

        // Assert
        assertNull(employee, "Expected add method to return null");
    }

    @Test
    public void testRemoveEmployee() {
        Employee employee = new Employee("John", "Doe", 1, 50000);
        employeeService.add(employee);

        assertEquals(employee, employeeService.remove("John", "Doe"));
        assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.find("John", "Doe");
        });
    }

    @Test
    public void testRemoveNonexistentEmployee() {
        assertNull(employeeService.remove("Nonexistent", "Employee"));
    }

    @Test
    public void testGetAllEmployees() {
        assertTrue(employeeService.getAll().isEmpty());

        employeeService.add(new Employee("John", "Doe", 1, 50000));
        employeeService.add(new Employee("Jane", "Doe", 2, 60000));

        Collection<Employee> employees = employeeService.getAll();
        assertEquals(2, employees.size());
    }

}
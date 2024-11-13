package ka.irissin.testmockitodemo.service;

import ka.irissin.testmockitodemo.exception.EmployeeNotFoundException;
import model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DepartmentServiceTest {
    private EmployeeService employeeServiceMock;
    private DepartmentService departmentService;

    @BeforeEach
    public void setUp() {
        employeeServiceMock = Mockito.mock(EmployeeService.class);
        departmentService = new DepartmentService(employeeServiceMock);
    }

    @Test
    void getEmployeeSalarySum() {
        Employee emp1 = new Employee("John", "Doe", 1, 50000);
        Employee emp2 = new Employee("Jane", "Doe", 1, 60000);
        when(employeeServiceMock.getAll()).thenReturn(Arrays.asList(emp1, emp2));

        double sum = departmentService.getEmployeeSalarySum(1);
        assertEquals(110000, sum);
    }

    @Test
    void getEmpWithMinSalary() {
        Employee emp1 = new Employee("John", "Doe", 1, 50000);
        Employee emp2 = new Employee("Jane", "Doe", 1, 60000);
        when(employeeServiceMock.getAll()).thenReturn(Arrays.asList(emp1, emp2));

        double minSalary = departmentService.getEmpWithMinSalary(1);
        assertEquals(50000, minSalary);
    }

    @Test
    public void testGetEmpWithMinSalaryNotFound() {
        when(employeeServiceMock.getAll()).thenReturn(Collections.emptyList());

        assertThrows(EmployeeNotFoundException.class, () -> {
            departmentService.getEmpWithMinSalary(1);
        });
    }

    @Test
    void getEmpWithMaxSalary() {
        Employee emp1 = new Employee("John", "Doe", 1, 50000);
        Employee emp2 = new Employee("Jane", "Doe", 1, 60000);
        when(employeeServiceMock.getAll()).thenReturn(Arrays.asList(emp1, emp2));

        double maxSalary = departmentService.getEmpWithMaxSalary(1);
        assertEquals(60000, maxSalary);
    }

    @Test
    public void testGetEmpWithMaxSalaryNotFound() {
        when(employeeServiceMock.getAll()).thenReturn(Collections.emptyList());

        assertThrows(EmployeeNotFoundException.class, () -> {
            departmentService.getEmpWithMaxSalary(1);
        });
    }

    @Test
    void getAll() {
        Employee emp1 = new Employee("John", "Doe", 1, 50000);
        Employee emp2 = new Employee("Jane", "Doe", 2, 60000);
        when(employeeServiceMock.getAll()).thenReturn(Arrays.asList(emp1, emp2));

        List<Employee> employees = departmentService.getAll(1);
        assertEquals(1, employees.size());
        assertEquals(emp1, employees.get(0));
    }

    @Test
    void testGetAll() {
        Employee emp1 = new Employee("John", "Doe", 1, 50000);
        Employee emp2 = new Employee("Jane", "Doe", 2, 60000);
        when(employeeServiceMock.getAll()).thenReturn(Arrays.asList(emp1, emp2));

        Map<Integer, List<Employee>> groupedEmployees = departmentService.getAll();
        assertEquals(2, groupedEmployees.size());
        assertTrue(groupedEmployees.containsKey(1));
        assertTrue(groupedEmployees.containsKey(2));
        assertEquals(1, groupedEmployees.get(1).size());
        assertEquals(emp1, groupedEmployees.get(1).get(0));
    }

    @Test
    void fireAllInDepartment() {
        Employee emp1 = new Employee("John", "Doe", 1, 50000);
        Employee emp2 = new Employee("Jane", "Doe", 1, 60000);
        when(employeeServiceMock.getAll()).thenReturn(Arrays.asList(emp1, emp2));

        departmentService.fireAllInDepartment(1);
        verify(employeeServiceMock).remove(emp1.getFirstName(), emp1.getLastName());
        verify(employeeServiceMock).remove(emp2.getFirstName(), emp2.getLastName());
    }

}
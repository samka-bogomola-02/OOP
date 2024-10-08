package ka.irissin.testmockitodemo.service;

import model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public interface EmployeeService {
    Employee add (String firstName, String lastName, int department, int salary);

    Employee remove (String firstName, String lastName);

    Employee find (String firstName, String lastName);

    Collection<Employee> getAll();
}

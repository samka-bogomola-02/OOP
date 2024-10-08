package ka.irissin.testmockitodemo.controller;

import ka.irissin.testmockitodemo.service.DepartmentService;
import model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/salary/min")
    public double getMin(@PathVariable("id") int departmentId) {
        return departmentService.getEmpWithMinSalary(departmentId);
    }

    @GetMapping("/{id}/salary/max")
    public double getMax(@PathVariable("id") int departmentId) {
        return departmentService.getEmpWithMaxSalary(departmentId);
    }

    @GetMapping("/{id}/salary/sum")
    public double getSum(@PathVariable("id") int departmentId) {
        return departmentService.getEmployeeSalarySum(departmentId);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getAll(@PathVariable int id) {
        return departmentService.getAll(id);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getAll() {
        return departmentService.getAll();
    }
}

package ork.homew.homeworkspringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ork.homew.homeworkspringdemo.model.Employee;
import ork.homew.homeworkspringdemo.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getMaxSalaryEmployee(@RequestParam("departmentId") int departmentId){
        return departmentService.getMaxSalaryEmployee(departmentId);
    }
    @GetMapping("/min-salary")
    public Employee getMinSalaryEmployee(@RequestParam("departmentId") int departmentId){
        return departmentService.getMinSalaryEmployee(departmentId);
    }
    @GetMapping("/all/department")
    public List<Employee> getAllDepartmentEmployee(@RequestParam("departmentId") int departmentId){
        return departmentService.getAllDepartmentEmployee(departmentId);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllEmployees(){
        return departmentService.getAllEmployees();
    }

}

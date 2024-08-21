package ork.homew.homeworkspringdemo.controller;

import ork.homew.homeworkspringdemo.model.Employee;
import ork.homew.homeworkspringdemo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String name, @RequestParam String lastName){
        return service.add(name, lastName);
    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String name, @RequestParam String lastName){
        return service.remove(name, lastName);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String name, @RequestParam String lastName){
        return service.find(name, lastName);
    }
    @GetMapping
    public Collection<Employee> findAll(){
        return service.findAll();
    }
}
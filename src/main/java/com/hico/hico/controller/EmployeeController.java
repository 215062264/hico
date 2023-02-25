package com.hico.hico.controller;

import com.hico.hico.entity.Employee;
import com.hico.hico.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    @GetMapping
    public List<Employee> getAllEmployees(){
        List<Employee> employees = service.getAllEmployees();
        service.sortEmployeesByFirstName(employees);
        return employees;
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployee(@PathVariable long id){
         log.info("Employee: " + service.findById(id));
        return service.findById(id);
    }

    @PostMapping("/save")
    @ResponseBody
    public Employee save(@RequestBody Employee employee){
        log.info("Created Employee: " + employee.toString());
        return service.save(employee);
    }

    @DeleteMapping
    public void deleteEmployee(@PathVariable long id){
        service.deleteEmployee(id);
    }


}

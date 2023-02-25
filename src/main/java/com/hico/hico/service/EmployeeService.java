package com.hico.hico.service;

import com.hico.hico.entity.Employee;
import com.hico.hico.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    public EmployeeRepository repository;
    public Employee save(Employee employee){return repository.save(employee);}

    public List<Employee> getAllEmployees(){return repository.findAll();}

    public void deleteEmployee(long id){
        repository.deleteById(id);
    }

    public void sortEmployeesByFirstName(List<Employee> employees){
        employees.sort(Comparator.comparing(Employee::getFirstName));
    }

    public Optional<Employee> findById(long id) {
        return repository.findById(id);
    }
}

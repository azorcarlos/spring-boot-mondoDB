package br.com.spring.mongodb.service;

import br.com.spring.mongodb.model.Employee;
import br.com.spring.mongodb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(String id) {
        return repository
                .findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Employee not found."));
    }

    @Override
    public Employee save(Employee employee) {
        System.out.println(employee);
        Employee chefe =
                repository.findById(employee.getHead().getId())
                .orElseThrow(()-> new IllegalArgumentException("Head not Found"));
        employee.setHead(chefe);
        return repository.save(employee);
    }

    @Override
    public List<Employee> findEmployeeForRangeAndAge(Integer first, Integer last) {
        return repository.findEmployeeForRangeAndAge(first, last);
    }

    @Override
    public List<Employee> findByName(String name) {
        return repository.findByName(name);
    }
}

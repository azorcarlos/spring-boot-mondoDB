package br.com.spring.mongodb.service;

import br.com.spring.mongodb.model.Employee;

import java.util.List;

public interface EmployeeServices {

    public List<Employee> findAll();
    public Employee findById(String id);
    public Employee save(Employee employee);
    public List<Employee> findEmployeeForRangeAndAge(Integer first, Integer last);
    public List<Employee> findByName(String name);
}

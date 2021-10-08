package br.com.spring.mongodb.controller;

import br.com.spring.mongodb.model.Employee;
import br.com.spring.mongodb.service.EmployeeServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionarios")
@RequiredArgsConstructor
public class EmployeeController {

    private EmployeeServices employeeServices;

    @GetMapping
    public List<Employee> findAll(){
        return employeeServices.findAll();
    }

    @GetMapping(value = "/{id}")
    public Employee findById(@PathVariable String id){
        return employeeServices.findById(id);

    }

    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employeeServices.save(employee);
    }

    @GetMapping(value ="/range")
    public List<Employee> findByRangeAndAge(
            @RequestParam("first") Integer first,
            @RequestParam("last") Integer last){
        return employeeServices.findEmployeeForRangeAndAge(first, last);
    }

    @GetMapping(value ="/find-name")
    public List<Employee> findByName(
            @RequestParam("nome") String name){
        return employeeServices.findByName(name);
    }

}

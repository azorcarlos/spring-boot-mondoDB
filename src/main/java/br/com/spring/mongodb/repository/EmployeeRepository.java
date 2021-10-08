package br.com.spring.mongodb.repository;

import br.com.spring.mongodb.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    @Query("{ $and: [{ 'age': { $gte: ?0 } }, { 'age': { $lte: ?1 } } ] }")
    public List<Employee> findEmployeeForRangeAndAge(Integer first, Integer last);
    public List<Employee> findByName(String name);

}

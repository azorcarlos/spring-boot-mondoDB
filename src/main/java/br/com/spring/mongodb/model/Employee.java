package br.com.spring.mongodb.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;


@Data
@Document
@ToString
public class Employee {
    @Id
    private String id;
    private String name;
    private Integer age;
    private BigDecimal wages;
    @DBRef
    private Employee head;


}

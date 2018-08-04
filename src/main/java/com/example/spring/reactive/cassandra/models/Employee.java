package com.example.spring.reactive.cassandra.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * @author alanqtruong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("employee")
public class Employee {

    @PrimaryKey
    private EmployeeKey employeeKey;

    @Column
    private String title;

    @Column
    private String department;

    @Column
    private double salary;

}

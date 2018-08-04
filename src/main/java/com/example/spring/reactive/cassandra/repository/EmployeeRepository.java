package com.example.spring.reactive.cassandra.repository;

import com.example.spring.reactive.cassandra.models.Employee;
import com.example.spring.reactive.cassandra.models.EmployeeKey;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

/**
 * @author alanqtruong
 */
@Repository
public interface EmployeeRepository extends ReactiveCassandraRepository<Employee, EmployeeKey> {

}

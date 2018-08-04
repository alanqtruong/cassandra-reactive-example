package com.example.spring.reactive.cassandra;

import com.example.spring.reactive.cassandra.models.Employee;
import com.example.spring.reactive.cassandra.models.EmployeeKey;
import com.example.spring.reactive.cassandra.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 *  @author alanqtruong
 */
@Slf4j
@SpringBootApplication(scanBasePackages = "com.example.spring.reactive.cassandra")
public class SpringReactiveCassandraApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringReactiveCassandraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        employeeRepository.insert(new Employee(new EmployeeKey("Joe Doe", LocalDateTime.now(), UUID.randomUUID()), "Engineer 1", "IT", 200000)).log().subscribe();
        employeeRepository.insert(new Employee(new EmployeeKey("Sally May", LocalDateTime.now(), UUID.randomUUID()), "Senior Engineer 1", "IT", 300000)).log().subscribe();
        employeeRepository.insert(new Employee(new EmployeeKey("Dennis Johnson", LocalDateTime.now(), UUID.randomUUID()), "Accountant", "Accounting", 100000)).log().subscribe();
        Flux<Employee> employeeFlux = employeeRepository.findAll();
        log.info("employeeList: " + employeeFlux.collectList().block().toString());
    }
}
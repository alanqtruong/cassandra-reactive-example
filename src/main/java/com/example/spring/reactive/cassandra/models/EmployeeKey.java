package com.example.spring.reactive.cassandra.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.springframework.data.cassandra.core.cql.Ordering.DESCENDING;
import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

/**
 * @author alanqtruong
 */
@PrimaryKeyClass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeKey {

    @PrimaryKeyColumn(name = "full_name", type = PARTITIONED)
    private String fullName;

    @PrimaryKeyColumn(name = "date_of_birth", ordinal = 0)
    private LocalDateTime dateOfBirth;

    @PrimaryKeyColumn(name = "employee_id", ordinal = 1, ordering = DESCENDING)
    private UUID id;

}

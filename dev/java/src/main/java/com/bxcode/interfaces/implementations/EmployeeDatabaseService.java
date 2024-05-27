package com.bxcode.interfaces.implementations;

import com.bxcode.dto.Employee;
import com.bxcode.interfaces.contracts.IGenericDatabaseService;

import java.util.List;

/**
 * EmployeeDatabaseService
 * <p>
 * EmployeeDatabaseService class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */
public class EmployeeDatabaseService implements IGenericDatabaseService<Employee> {

    @Override
    public Employee getById(long id) {
        return Employee.builder()
                .id(1L)
                .name("Employee 1")
                .description("Employee 1")
                .build();
    }

    @Override
    public List<Employee> getAll() {
        return List.of(Employee.builder()
                .id(1L)
                .name("Employee 2")
                .description("Employee 2")
                .build());
    }
}



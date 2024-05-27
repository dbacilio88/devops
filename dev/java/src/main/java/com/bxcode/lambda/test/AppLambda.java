package com.bxcode.lambda.test;

import com.bxcode.dto.Employee;
import com.bxcode.dto.Product;
import com.bxcode.lambda.contracts.IMathFunctional;
import com.bxcode.lambda.contracts.IPrinterFunctional;
import lombok.extern.log4j.Log4j2;

/**
 * AppLambda
 * <p>
 * AppLambda class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */

@Log4j2
public class AppLambda {


    public static void main(String[] args) {
        IMathFunctional addition = (a, b) -> a + b;
        IMathFunctional subtraction = (a, b) -> a - b;
        IMathFunctional division = (a, b) -> a / b;
        IMathFunctional multiplication = (a, b) -> a * b;

        log.info("addition: {}", addition.sum(1.3, 2.3));
        log.info("subtraction: {}", subtraction.execute(1.2, 2.2));
        log.info("addition: {}", division.execute(1.2, 2.2));
        log.info("multiplication: {}", multiplication.execute(1.2, 2.2));


        IPrinterFunctional<String> printString = log::info;
        printString.print("Hola mundo");

        IPrinterFunctional<Product> printProduct = log::debug;
        printProduct.print(Product.builder()
                .id(1L)
                .name("Producto expression lambda")
                .description("Producto expression lambda")
                .build());

        IPrinterFunctional<Employee> printEmployee = log::debug;

        printEmployee.print(Employee.builder()
                .id(1L)
                .name("Employee expression lambda")
                .description("Employee expression lambda")
                .build());
    }
}



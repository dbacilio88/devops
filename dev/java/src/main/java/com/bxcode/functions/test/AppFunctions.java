package com.bxcode.functions.test;

import lombok.extern.log4j.Log4j2;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;


/**
 * AppFunctions
 * <p>
 * AppFunctions class.
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
public class AppFunctions {


    static BiFunction<String, String, String> biFunction = (a, b) -> a.toUpperCase() + " - " + b.toLowerCase();
    static BinaryOperator<String> binaryFunction = (a, b) -> a.toUpperCase() + " - " + b.toLowerCase();
    // Definir un BinaryOperator que encuentra el máximo de dos números
    static BinaryOperator<Integer> maxOperator = (a, b) -> a > b ? a : b;


    public static void main(String[] args) {
        log.info("biFunction {}", biFunction.apply("Hola", "mundo"));
        log.info("binaryFunction {}", binaryFunction.apply("java", "jdk"));

        // Usar el BinaryOperator
        int result = maxOperator.apply(10, 5);
        // Imprimir el resultado
        log.info("El máximo de 10 y 5 es: {}", result);
    }
}
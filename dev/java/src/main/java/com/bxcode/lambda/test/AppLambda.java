package com.bxcode.lambda.test;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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

        List<Integer> numbers = new ArrayList<>(10);
        //similar a un for
        IntStream repeat = IntStream.range(1, 11);
        /**
         * @apiNote expression lambda
         * repeat.forEach(i -> numbers.add(i));
         * referencia a métodos
         */
        repeat.forEach(numbers::add);
        log.info("numbers {}", numbers);
    }
}



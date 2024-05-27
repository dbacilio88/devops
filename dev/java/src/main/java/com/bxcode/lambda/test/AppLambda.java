package com.bxcode.lambda.test;

import lombok.extern.log4j.Log4j2;

import java.util.function.BiPredicate;

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

        //expresión lambda:
        BiPredicate<String, String> equalsEL = (s1, s2) -> s1.equals(s2);
        //referencia a método arbitraria:
        BiPredicate<String, String> equalsRM = String::equals;

        log.info("equalsEL: {}", equalsEL.test("1", "1"));
        log.info("equalsRM : {}", equalsRM.test("2", "1"));
    }
}
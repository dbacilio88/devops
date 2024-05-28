package com.bxcode.lambda.contracts;

/**
 * IMathFunctional
 * <p>
 * IMathFunctional interface.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 27/05/2024
 */
@FunctionalInterface
public interface IMathFunctional {

    Double execute(Double a, Double b);

    default Double sum(Double a, Double b) {
        return a + b;
    }
}
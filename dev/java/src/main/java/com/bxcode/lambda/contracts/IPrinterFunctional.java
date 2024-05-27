package com.bxcode.lambda.contracts;

/**
 * IPrinterFunctional
 * <p>
 * IPrinterFunctional interface.
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
public interface IPrinterFunctional<T> {
    void print(T t);

}



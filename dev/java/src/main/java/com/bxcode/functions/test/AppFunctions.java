package com.bxcode.functions.test;

import com.bxcode.dto.Product;
import lombok.extern.log4j.Log4j2;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;


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

    private static Random random = new Random();

    // Definir un Supplier que genera un número aleatorio entre 0 y 100
    static Supplier<Integer> randomSupplier = () -> random.nextInt(101);

    static Supplier<Product> productSupplier = () -> Product.builder()
            .id(1L)
            .name("product supplier")
            .description("product supplier")
            .build();


    public static void main(String[] args) {

        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5);
        List<Integer> squares = new LinkedList<>();

        numbers.forEach(n -> squares.add(n * n));
        log.info("number squares {}", squares);

        Map<Boolean, String> map = Map.of(true, "Hello", false, "World");

        map.forEach((k, v) -> log.info("key {} - value {}", k, v));


        // Obtener el número aleatorio usando el Supplier
        int number = randomSupplier.get();
        log.info("number random {}", number);

        // Generar una secuencia de 5 números enteros usando el Supplier
        Stream<Integer> integerStream = Stream.generate(randomSupplier).limit(10);
        integerStream.forEach(log::info);

        log.info("product supplier {}", productSupplier.get());

    }
}
package com.bxcode.functions.test;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


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


    static Predicate<Integer> isGreaterThan100 = n -> n > 100;

    static Predicate<Integer> isLessThan10 = n -> n < 10;
    static Predicate<String> hasLengthGreaterThanThree = n -> n.length() > 3;

    static Predicate<Integer> isBetweenThan10And100 = isGreaterThan100.or(isLessThan10);

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 100, 200, 300));
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Edward");


        List<Integer> filter = numbers.stream()
                .filter(isLessThan10)
                .collect(Collectors.toList());

        List<Integer> negate = numbers.stream()
                .filter(isBetweenThan10And100.negate())
                .collect(Collectors.toList());

        List<String> filterName = names.stream()
                .filter(hasLengthGreaterThanThree)
                .collect(Collectors.toList());

        numbers.removeIf(isGreaterThan100);

        //result numbers:
        log.info("list numbers filter {}", filter);
        log.info("list numbers negate {}", negate);
        log.info("list numbers removeIf {}", numbers);
        log.info("list filterName > 3 {}", filterName);
    }
}
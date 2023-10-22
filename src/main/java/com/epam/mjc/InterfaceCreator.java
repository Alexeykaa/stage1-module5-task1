package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return l -> l.stream().allMatch(s -> Character.isUpperCase(s.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int value = list.get(i);
                if (value % 2 == 0) {
                    list.add(value);
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream().filter(s -> Character.isUpperCase(s.charAt(0)) && s.endsWith(".")
                && s.split("([ ,.])+").length > 3).collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return l -> l.stream().collect(Collectors.toMap(s -> s, String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (l1, l2) -> Stream.concat(l1.stream(), l2.stream()).collect(Collectors.toList());
    }
}
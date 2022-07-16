package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
    run();
    }

    public static void run() {
        List<Cat> cats= new ArrayList<>();
        cats.add(new Cat(Name.POPPY.toString(),Cat.rndAge(),Cat.rndLevel(),Cat.rndLevel(),Cat.rndLevel()));
        cats.add(new Cat(Name.PEACH.toString(),Cat.rndAge(),Cat.rndLevel(),Cat.rndLevel(),Cat.rndLevel()));
        cats.add(new Cat(Name.JASPER.toString(),Cat.rndAge(),Cat.rndLevel(),Cat.rndLevel(),Cat.rndLevel()));

        cats.forEach(System.out::println);
        System.out.println("---------------------sort by Level-----------");
        var sortByLevel= cats.stream()
                .sorted(comparingInt(Cat::getAverageLevel).reversed())
                .collect(toList());
        sortByLevel.forEach(System.out::println);

    }
}
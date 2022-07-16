package com.company;

import com.sun.source.tree.CompoundAssignmentTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class Main {
    static int  newIndex = 0;
    public static void main(String[] args) {
    run();
    }

    public static void run() {
        List<Cat> cats= new ArrayList<>();

        Cat cat = new Cat();

        cat.makeCat(cats);
        cats.forEach(System.out::println);

        System.out.println("---------------------sort by Level-----------");
        var sortByLevel= cats.stream()
                .sorted(comparingInt(Cat::getAverageLevel).reversed());
        sortByLevel.forEach(System.out::println);

        System.out.println("---------------------add cat----------");
        cat.addCats(cats);
        var sortByLevel1= cats.stream()
                .sorted(comparingInt(Cat::getAverageLevel).reversed())
                .collect(toList());
        for (Cat c:sortByLevel1){
         newIndex++;
         c.setIndex(newIndex);
        }
        sortByLevel1.forEach(System.out::println);

    }

}
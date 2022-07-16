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

        Cat cat = new Cat();

        cat.makeCat(cats);
        System.out.println("---------------------sort by Level-----------");

        var sortByLevel= cats.stream()
                .sorted(comparingInt(Cat::getAverageLevel).reversed())
               // .map(e->e.getIndex()+9)
                .collect(toList());
//        for (int i =0; i<sortByLevel.size();i++ ) {
//            int index1=9;
//            index1=index1+1;
//            cat.setIndex(index1);
//        }

      sortByLevel.forEach(System.out::println);
        System.out.println("---------------------add cat----------");

        cat.addCats(cats);
        var sortByLevel1= cats.stream()
                .sorted(comparingInt(Cat::getAverageLevel).reversed())
                .collect(toList());


        sortByLevel1.forEach(System.out::println);





    }

}
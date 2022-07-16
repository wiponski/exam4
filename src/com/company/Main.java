package com.company;

import com.sun.source.tree.CompoundAssignmentTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class Main {
     static  int  newIndex = 0;
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
        addCats(cats);
        var sortByLevel1= cats.stream()
                .sorted(comparingInt(Cat::getAverageLevel).reversed())
                .collect(toList());
        for (Cat c:sortByLevel1){
         newIndex++;
         c.setIndex(newIndex);
        }
        sortByLevel1.forEach(System.out::println);
        System.out.println("--------------------Выбор действий---------");

       getAction(sortByLevel1);
        newIndex=0;
        for (Cat c:sortByLevel1){
            newIndex++;
            c.setIndex(newIndex);
        }
        sortByLevel1.forEach(System.out::println);







    }



    public static void  getAction(List<Cat> cats){
        System.out.println("\n Выберите действие: \n"+
                "1. Кормить кота \n"+
                "2. Играть с котом \n"+
                "3. Лечить кота \n"+
                "4. Завести нового питомца;\n" +
                "5. Выход \n");
        Integer choose = new Scanner(System.in).nextInt();
        switch (choose){
            case 1:
                feedCat(cats);
                return;
            case 2:
                playCat(cats);
                return;
            case 3:
                treatCat(cats);
                return;
            case 4:
                addCats(cats);
                return;
            case 5:
                break;
            default:
                System.out.println("not correct choose....");
                return;
        }

    }

    public static List<Cat> addCats (List<Cat> cats){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name=sc.nextLine();
        System.out.print("Введите возраст: ");
        int age=sc.nextInt();
        cats.add( new Cat( name, age,Cat.rndLevel(),Cat.rndLevel(),Cat.rndLevel()));
        return cats;
    }


    public static void   feedCat(List<Cat> cats){
        System.out.println("Кормить кота ");
        int index=chooseCat()-1;
        System.out.println("Вы выбрали: "+cats.get(index).getName()+", его возраст: "+cats.get(index).getAge());
        if( cats.get(index).getAge()>0 && cats.get(index).getAge()<6){
            cats.get(index).setSatietyLevel(cats.get(index).getSatietyLevel()+7);
        }else if (cats.get(index).getAge()>6 && cats.get(index).getAge()<10) {
            cats.get(index).setSatietyLevel(cats.get(index).getSatietyLevel()+5);
        }else {
            cats.get(index).setSatietyLevel(cats.get(index).getSatietyLevel()+4);
        }
    }

    public static void  playCat(List<Cat> cats){
        System.out.println("Играть с котом ");
        int index=chooseCat()-1;
        System.out.println("Вы выбрали: "+cats.get(index).getName()+", его возраст: "+cats.get(index).getAge());
        if( cats.get(index).getAge()>0 && cats.get(index).getAge()<6){
            cats.get(index).setHealthLevel(cats.get(index).getHealthLevel()+7);
            cats.get(index).setMoodLevel(cats.get(index).getMoodLevel()+7);
            cats.get(index).setSatietyLevel(cats.get(index).getSatietyLevel()-3);
        }else if (cats.get(index).getAge()>6 && cats.get(index).getAge()<10) {
            cats.get(index).setHealthLevel(cats.get(index).getHealthLevel()+5);
            cats.get(index).setMoodLevel(cats.get(index).getMoodLevel()+5);
            cats.get(index).setSatietyLevel(cats.get(index).getSatietyLevel()-5);
        }else {
            cats.get(index).setHealthLevel(cats.get(index).getHealthLevel()+4);
            cats.get(index).setMoodLevel(cats.get(index).getMoodLevel()+4);
            cats.get(index).setSatietyLevel(cats.get(index).getSatietyLevel()-6);
        }
    }
    public static void  treatCat(List<Cat> cats){
        System.out.println("Лечить кота ");
        int index=chooseCat()-1;
        System.out.println("Вы выбрали: "+cats.get(index).getName()+", его возраст: "+cats.get(index).getAge());
        if( cats.get(index).getAge()>0 && cats.get(index).getAge()<6){
            cats.get(index).setHealthLevel(cats.get(index).getHealthLevel()+7);
            cats.get(index).setMoodLevel(cats.get(index).getMoodLevel()-3);
            cats.get(index).setSatietyLevel(cats.get(index).getSatietyLevel()-3);
        }else if (cats.get(index).getAge()>6 && cats.get(index).getAge()<10) {
            cats.get(index).setHealthLevel(cats.get(index).getHealthLevel()+5);
            cats.get(index).setMoodLevel(cats.get(index).getMoodLevel()-5);
            cats.get(index).setSatietyLevel(cats.get(index).getSatietyLevel()-5);
        }else {
            cats.get(index).setHealthLevel(cats.get(index).getHealthLevel()+4);
            cats.get(index).setMoodLevel(cats.get(index).getMoodLevel()-6);
            cats.get(index).setSatietyLevel(cats.get(index).getSatietyLevel()-6);
        }
    }

    public static Integer  chooseCat(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите номер кота: ");
        int number=sc.nextInt();
        return number;
    }

}
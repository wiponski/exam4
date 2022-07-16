package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class Cat {
    private String name;
    private Integer age;
    private Integer satietyLevel;
    private Integer moodLevel;
    private Integer healthLevel;
    private int index;
    private static Random random= new Random();
    //private static  List<String> names = List.of(Name.values().toString());
    private static  List<String> names = List.of("Peach", "Poppy", "Jasper");
    public Cat() {

    }


    public Cat(String name, Integer age, Integer satietyLevel, Integer moodLevel, Integer healthLevel) {
        this.name = names.get(random.nextInt(names.size()));
        this.name = name;
        this.age = age;
        this.satietyLevel = satietyLevel;
        this.moodLevel = moodLevel;
        this.healthLevel = healthLevel;
    }
    public Cat(Integer index, String name, Integer age, Integer satietyLevel, Integer moodLevel, Integer healthLevel) {
        this.index=index;
        this.name = name;
        this.age = age;
        this.satietyLevel = satietyLevel;
        this.moodLevel = moodLevel;
        this.healthLevel = healthLevel;
    }



    public static List<Cat> makeCat(List<Cat> cats){
        int index =0;
        for(int i = 0 ; i<5;i++){
            index = index+1;
            cats.add(new Cat(index, names.get(random.nextInt(names.size())), Cat.rndAge(),Cat.rndLevel(),Cat.rndLevel(),Cat.rndLevel()));
        } return cats;
    }

    public static Integer rndLevel(){
        int rnd=1;
       rnd =random.nextInt(100);
       return rnd;
    }
    public static Integer rndAge(){
        int rnd=1;
         rnd =random.nextInt(17);
        return rnd;
    }


    public Integer getAverageLevel(){
        int m= (satietyLevel+moodLevel+healthLevel)/3;
        return m;
    }

   public static List<Cat> addCats (List<Cat> cats){
       Scanner sc = new Scanner(System.in);
       System.out.print("������� ���: ");
       String name=sc.nextLine();
       System.out.print("������� �������: ");
       int age=sc.nextInt();
       cats.add( new Cat( name, age,Cat.rndLevel(),Cat.rndLevel(),Cat.rndLevel()));
      return cats;
    }

    public void  getAction(List<Cat> cats){
        System.out.println("\n �������� ��������: \n"+
                "1. ������� ���� \n"+
                "2. ������ � ����� \n"+
                "3. ������ ���� \n"+
                "4. ������� ������ �������;" +
                "5. ����� \n");
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
    public void   feedCat(List<Cat> cats){
        System.out.println("������� ���� ");
        index=chooseCat()-1;
        System.out.println("�� �������: "+cats.get(index).name+", ��� �������: "+cats.get(index).age);

    }
    public void  playCat(List<Cat> cats){
        System.out.println("������ � ����� ");
        index=chooseCat()-1;
        System.out.println("�� �������: "+cats.get(index).name+", ��� �������: "+cats.get(index).age);
    }
    public void  treatCat(List<Cat> cats){
        System.out.println("������ ���� ");
        index=chooseCat()-1;
        System.out.println("�� �������: "+cats.get(index).name+", ��� �������: "+cats.get(index).age);
    }

    public Integer  chooseCat(){
        Scanner sc = new Scanner(System.in);
        System.out.print("������� ����� ����: ");
        int number=sc.nextInt();
       return number;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSatietyLevel() {
        return satietyLevel;
    }

    public void setSatietyLevel(Integer satietyLevel) {
        this.satietyLevel = satietyLevel;
    }

    public Integer getMoodLevel() {
        return moodLevel;
    }

    public void setMoodLevel(Integer moodLevel) {
        this.moodLevel = moodLevel;
    }

    public Integer getHealthLevel() {
        return healthLevel;
    }

    public void setHealthLevel(Integer healthLevel) {
        this.healthLevel = healthLevel;
    }

    @Override
    public String toString() {

//        System.out.println("\n-----------------------------------------------\n"+
//        "# |\t���\t|\t�������\t|\t��������\t|\t����������\t|\t�������\t|\n");
       return  String.format("%s |\t%s\t|\t%s\t|\t%s\t|\t%s\t|\t%s\t|\t%s\t|",getIndex(),name,age,satietyLevel,moodLevel,healthLevel,getAverageLevel() );
    }

    public Integer getIndex() {
        return index;
    }

    public  void setIndex(Integer index) {
        this.index = index;
    }
}

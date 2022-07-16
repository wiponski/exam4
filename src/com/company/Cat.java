package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cat {
    private String name;
    private Integer age;
    private Integer satietyLevel;
    private Integer moodLevel;
    private Integer healthLevel;
    private static Random random= new Random();

    public Cat(String name, Integer age, Integer satietyLevel, Integer moodLevel, Integer healthLevel) {
        //this.name = Name.POPPY.name();
        this.name = name;
        this.age = age;
        this.satietyLevel = satietyLevel;
        this.moodLevel = moodLevel;
        this.healthLevel = healthLevel;
    }

//    public static List<Cat> makeCat(){
//      List<Cat> cats = new ArrayList<>();
//     cats.add(Name.POPPY,13,14,14,14);
//     return cats;
//    }

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
//        "# |\tИмя\t|\tВозраст\t|\tЗдоровье\t|\tНастроение\t|\tСытость\t|\n");
       return  String.format("# |\t%s\t|\t%s\t|\t%s\t|\t%s\t|\t%s\t|\t%s\t|",name,age,satietyLevel,moodLevel,healthLevel,getAverageLevel() );
    }
//    @Override
//    public String toString() {
//        return "Cat{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", satietyLevel=" + satietyLevel +
//                ", moodLevel=" + moodLevel +
//                ", healthLevel=" + healthLevel +
//                '}';
//    }
}

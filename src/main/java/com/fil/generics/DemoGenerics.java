package com.fil.generics;

import java.util.ArrayList;
import java.util.List;

public class DemoGenerics {
    public static void main(String[] args) {
//
//        Box<String> boxString = new Box<>("abc");
//        System.out.println(boxString);
//        System.out.println(boxString.getT());
//
//        Box<Integer> boxInteger = new Box<>(434);
//
//        Animal a = new Animal();
//        a = new Dog();
//         d = new Animal()

        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog());

        List<? extends Animal> as =new ArrayList<>();
        for (Animal a1 : as){

        }

        List<? super Dog> superDog = new ArrayList<>();
        superDog.add(new Dog());
//        superDog.add(new Animal());


    }
}

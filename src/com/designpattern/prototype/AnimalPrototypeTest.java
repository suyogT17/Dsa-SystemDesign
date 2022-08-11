package com.designpattern.prototype;

public class AnimalPrototypeTest {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();
        Sheep sheep = new Sheep();
        Sheep clonedSheep = (Sheep) animalFactory.getClone(sheep);
        
        System.out.println(System.identityHashCode(sheep));
        System.out.println(System.identityHashCode(clonedSheep));
    }
}

interface Animal extends Cloneable {
    Animal makeCopy();
}

class Sheep implements Animal {
    public Sheep() {
        System.out.println("Sheep is made");
    }

    public Animal makeCopy() {
        System.out.println("Creating sheep");
        Sheep sheepObject = null;

        try {
            sheepObject = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return sheepObject;
    }
}

class AnimalFactory {
    Animal getClone(Animal animal) {
        return animal.makeCopy();
    }
}


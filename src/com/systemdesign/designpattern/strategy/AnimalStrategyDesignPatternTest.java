package com.systemdesign.designpattern.strategy;

public class AnimalStrategyDesignPatternTest {
    public static void main(String[] args) {
        Animal dog = new Animal("Dog", new NoFlyingStrategy());
        Animal bird = new Animal("Bird", new FlyingStrategy());

        dog.fly();
        bird.fly();

        System.out.println("Reversing Flying strategy");
        dog.setIfLyingStrategy(new FlyingStrategy());
        bird.setIfLyingStrategy(new NoFlyingStrategy());

        dog.fly();
        bird.fly();
    }
}

class Animal {
    String name;
    IFLyingStrategy ifLyingStrategy;

    public Animal(String name, IFLyingStrategy ifLyingStrategy){
        this.name = name;
        this.ifLyingStrategy = ifLyingStrategy;
    }

    public void setIfLyingStrategy(IFLyingStrategy ifLyingStrategy) {
        this.ifLyingStrategy = ifLyingStrategy;
    }

    void fly(){
        System.out.println(name+": " +ifLyingStrategy.fly());
    }
}

interface IFLyingStrategy {
    String fly();
}

class FlyingStrategy implements IFLyingStrategy {
    public String fly() {
        return "I can fly";
    }
}

class NoFlyingStrategy implements IFLyingStrategy {
    public String fly() {
        return "I can't fly";
    }
}

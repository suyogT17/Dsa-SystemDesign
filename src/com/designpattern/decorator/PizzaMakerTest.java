package com.designpattern.decorator;

public class PizzaMakerTest {
    public static void main(String[] args) {
        Mozzarella mozzarella = new Mozzarella(new PlainPizza());
        System.out.println(mozzarella.getDescription());
        System.out.println(mozzarella.getCost());

        TomatoSauce tomatoSauce = new TomatoSauce(new Mozzarella(new PlainPizza()));
        System.out.println(tomatoSauce.getDescription());
        System.out.println(tomatoSauce.getCost());
    }
}

interface Pizza {
    String getDescription();
    double getCost();
}

class PlainPizza implements Pizza{
    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double getCost() {
        return 50.00;
    }
}

abstract class ToppingDecorator implements Pizza  {
    Pizza tempPizza;

    public ToppingDecorator(Pizza newPizza){
        this.tempPizza = newPizza;
        System.out.println("Plain Pizza Added");
    }

    public String getDescription(){
        return tempPizza.getDescription();
    }

    public double getCost(){
        return tempPizza.getCost();
    }
}

class TomatoSauce extends ToppingDecorator{
    public TomatoSauce(Pizza newPizza) {
        super(newPizza);
        System.out.println("Adding TomatoSauce");
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", TomatoSauce";
    }

    @Override
    public double getCost() {
        return super.getCost() + 10.00;
    }
}

class Mozzarella extends ToppingDecorator {
    public Mozzarella(Pizza newPizza) {
        super(newPizza);
        System.out.println("Adding Mozzarella");
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Mozzarella";
    }

    @Override
    public double getCost() {
        return super.getCost() + 20.00;
    }
}
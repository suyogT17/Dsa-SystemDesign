package com.designpattern.factory.method;

import java.util.Scanner;

public class EnemyShipTester {
    public static void main(String[] args) {
        EnemyShipCreator enemyShipCreator = new EnemyShipCreator();
        Scanner scanner = new Scanner(System.in);
        String option = null;
        System.out.println("Select Enemy Ship (U/B/R): ");
        if (scanner.hasNextLine()) {
            option = scanner.nextLine();
        }
        EnemyShip enemyShip = enemyShipCreator.createEnemyShip(option);
        if (enemyShip != null) doStuff(enemyShip);
        else System.out.println("invalid choice. Please Select from U, B, R");
    }

    private static void doStuff(EnemyShip enemyShip) {
        enemyShip.followHero();
        enemyShip.displayEnemy();
        enemyShip.shoot();
    }
}

class EnemyShipCreator {
    EnemyShip createEnemyShip(String option) {
        EnemyShip enemyShip = null;
        if (option.equals("U")) enemyShip = new UFOEnemyShip();
        else if (option.equals("B")) enemyShip = new BigUFOEnemyShip();
        else if (option.equals("R")) enemyShip = new RocketEnemyShip();
        return enemyShip;
    }
}

abstract class EnemyShip {
    private String name;
    private double amtDamage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmtDamage() {
        return amtDamage;
    }

    public void setAmtDamage(double amtDamage) {
        this.amtDamage = amtDamage;
    }

    public void followHero(){
        System.out.println(getName()+" is following Hero");
    }

    public void displayEnemy(){
        System.out.println(getName()+" is on screen");
    }

    public void shoot(){
        System.out.println(getName()+" is shooting does damage "+getAmtDamage());
    }
}

class BigUFOEnemyShip extends EnemyShip {
    public BigUFOEnemyShip() {
        setName("Big UFO EnemyShip");
        setAmtDamage(50.0);
    }
}

class RocketEnemyShip extends EnemyShip {
    public RocketEnemyShip() {
        setName("Rocket EnemyShip");
        setAmtDamage(40.0);
    }
}

class UFOEnemyShip extends EnemyShip {
    public UFOEnemyShip() {
        setName("UFO EnemyShip");
        setAmtDamage(20.0);
    }
}
package com.systemdesign.designpattern.adapter;

public class EnemyAdpaterTest {
    public static void main(String[] args) {
        EnemyTank enemyTank = new EnemyTank();
        EnemyRobot enemyRobot = new EnemyRobot();
        EnemyAttackerAdapter enemyAttackerAdapter = new EnemyAttackerAdapter(enemyRobot);

        System.out.println("Enemy Tank ");
        enemyTank.assignName("Tank");
        enemyTank.attack();

        System.out.println("Enemy Robot ");
        enemyRobot.interact("Jethalal");
        enemyRobot.act();

        System.out.println("Enemy Adapter");
        enemyAttackerAdapter.assignName("Bapuji");
        enemyAttackerAdapter.attack();
    }
}

interface EnemyAttacker {
    void attack();
    void assignName(String name);
}

class EnemyTank implements EnemyAttacker {

    public void attack() {
        System.out.println("Enemy Tank is attacking");
    }

    public void assignName(String name) {
        System.out.println("Enemy Tank Name: " + name);
    }
}

class EnemyAttackerAdapter implements EnemyAttacker {

    EnemyRobot enemyRobot;

    public EnemyAttackerAdapter(EnemyRobot enemyRobot) {
        this.enemyRobot = enemyRobot;
    }

    public void attack() {
        enemyRobot.act();
    }

    public void assignName(String name) {
        enemyRobot.interact(name);
    }
}

class EnemyRobot {
    public void act() {
        System.out.println("Enemy Robot is attacking");
    }

    public void interact(String name) {
        System.out.println("Interacting with " + name);
    }
}


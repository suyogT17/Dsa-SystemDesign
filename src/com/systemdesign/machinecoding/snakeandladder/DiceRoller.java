package com.systemdesign.machinecoding.snakeandladder;


public class DiceRoller {
    private int numberOfDice;

    public DiceRoller(int numberOfDice){
        this.numberOfDice = numberOfDice;
    }

    public int roll(){
        return (int)Math.floor(Math.random()*((numberOfDice*6-numberOfDice)+1)+numberOfDice);
    }
}

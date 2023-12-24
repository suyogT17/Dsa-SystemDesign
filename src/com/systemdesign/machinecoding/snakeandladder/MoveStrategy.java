package com.systemdesign.machinecoding.snakeandladder;

public interface MoveStrategy {
    void move(Player player,Board board, DiceRoller diceRoller);

}

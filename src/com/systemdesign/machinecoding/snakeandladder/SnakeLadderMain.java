package com.systemdesign.machinecoding.snakeandladder;

public class SnakeLadderMain {
    public static void main(String[] args) throws Exception {
        Board board = new Board();
        board.addSpecialEntity(new Snake(63, 18));
        board.addSpecialEntity(new Snake(32, 10));
        board.addSpecialEntity(new Snake(88, 24));
        board.addSpecialEntity(new Snake(97, 78));

        board.addSpecialEntity(new Ladder(1, 38));
        board.addSpecialEntity(new Ladder(21, 42));
        board.addSpecialEntity(new Ladder(28, 76));
        board.addSpecialEntity(new Ladder(80, 99));

        DiceRoller diceRoller = new DiceRoller(3);
        Game game = new Game(board, new DefaultMoveStrategy(), diceRoller);

        game.addPlayer(new Player("suyog", 0));
        game.addPlayer(new Player("pinky", 0));
        game.addPlayer(new Player("mummy", 0));

        game.start();
    }
}

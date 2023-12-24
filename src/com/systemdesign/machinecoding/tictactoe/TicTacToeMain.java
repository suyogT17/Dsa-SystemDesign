package com.systemdesign.machinecoding.tictactoe;

public class TicTacToeMain {

    public static void main(String[] args) {
        Player p1 = new Player(1, "suyog", Symbol.CROSS);
        Player p2 = new Player(2, "pinky", Symbol.ZERO);
        Game game = new Game(3, p1, p2);
        game.start();
    }
}

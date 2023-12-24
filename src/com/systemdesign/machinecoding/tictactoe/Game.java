package com.systemdesign.machinecoding.tictactoe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Game {

    Board board;
    Player p1, p2;
    Queue<Player> turn;
    GameState gameState;
    Scanner scanner;
    public Game(int n, Player p1, Player p2){
        board = new Board(n);
        this.p1 = p1;
        this.p2 = p2;
        this.turn = new LinkedList<>();
        scanner = new Scanner(System.in);
        initialize();
    }

    private void initialize(){
        turn.add(p1);
        turn.add(p2);
        gameState = GameState.NOT_STARTED;
    }

    public void start(){
        gameState = GameState.STARTED;
        board.display();
        while(true) {
            Player curr = turn.poll();
            System.out.println(curr.playerName+" Please enter cell: ");
            int cell = -1;
            while(true) {
                cell = scanner.nextInt()-1;
                if (cell >= 0 && board.isValidMove(cell)) {
                    break;
                }
                else {
                    System.out.println("Invalid Input cell");
                    board.display();
                }
            }
            boolean status = board.makeMove(cell, curr.playerSymbol);
            if(status) {
                System.out.println(curr.playerName+" won the game");
                gameState = GameState.FINISHED;
                return;
            }
            turn.offer(curr);
        }
    }

    private Symbol getSymbol(String ip){
        if(ip.equals("0")) return Symbol.ZERO;
        else if(ip.equals("X")) return Symbol.CROSS;
        else return Symbol.BLANK;
    }
}

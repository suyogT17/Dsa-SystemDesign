package com.systemdesign.machinecoding.snakeandladder;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

@Data
public class Game {

    private Board board;
    private Queue<Player> players;
    private DiceRoller diceRoller;
    private GameStatus gameStatus;
    private MoveStrategy moveStrategy;

    private Scanner scanner = new Scanner(System.in);

    public Game(Board board, MoveStrategy moveStrategy, DiceRoller diceRoller){
        this.board = board;
        this.diceRoller = diceRoller;
        this.players = new LinkedList<>();
        this.moveStrategy = moveStrategy;
        gameStatus = GameStatus.NOT_STARTED;
    }

    public void start(){
        gameStatus = GameStatus.RUNNING;
        while(true){
            Player currPlayer = players.poll();
            System.out.println(currPlayer.getPlayerName()+" Turn. Press 0 to roll the dice");
            int move = scanner.nextInt();
            if (move == 0) makeMove(currPlayer);
            if(currPlayer.getPlayerPosition() == board.getNumOfCells()) {
                System.out.println(currPlayer.getPlayerName()+" wins the game");
                gameStatus = GameStatus.FINISHED;
                break;
            }
            players.offer(currPlayer);
        }
    }

    private void makeMove(Player player){
        moveStrategy.move(player, board, diceRoller);
    }

    public boolean addPlayer(Player player) throws Exception {
        if(gameStatus != GameStatus.NOT_STARTED) throw new Exception("Game is started. so can't add new player");
        else return this.players.offer(player);
    }

}

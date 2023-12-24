package com.systemdesign.machinecoding.tictactoe;

import java.util.Arrays;

public class Board {
    Symbol[][] board;
    int maxMoves;
    int n;
    public Board(int n){
        board = new Symbol[n][n];
        maxMoves = n*n;
        this.n = n;
        initialize();
    }

    private void initialize(){
        for(int i=0;i<board.length;i++){
            Arrays.fill(board[i], Symbol.BLANK);
        }
    }

    public boolean isValidMove(int cell){
        if(cell >= maxMoves) return false;
        int row = cell/n;
        int col = cell%n;
        return board[row][col] == Symbol.BLANK;
    }

    public boolean makeMove(int cell, Symbol symbol){
        int row = cell/n;
        int col = cell%n;
        board[row][col] = symbol;
        display();
        return getWinner(row, col, symbol);
    }

    public void display(){
        for(int i=0;i<n;i++){
            String line = "";
            for(int j=0;j<n;j++){
                if(j != n-1) line+=board[i][j].value()+" |";
                else line+= board[i][j].value();
            }
            System.out.println(line);
            if(i != n-1){
                System.out.println("--+--+--");
            }
        }
    }

    public boolean getWinner(int row, int col, Symbol symbol){
        if(row != col && rowWon(row, symbol) || colWon(col, symbol)) return true;
        if(row == col && rowWon(row, symbol) || colWon(col, symbol) || diagonalWon(row, col, symbol)) return true;
        if(row+col ==n  && rowWon(row, symbol) || colWon(col, symbol) || reverseDiagonalWon(row, col, symbol)) return true;
        else return false;
    }

    private boolean rowWon(int row, Symbol symbol){
        for(int i=0;i<n;i++){
            if(board[row][i] != symbol) return false;
        }
        return true;
    }

    private boolean colWon(int col, Symbol symbol){
        for(int i=0;i<n;i++){
            if(board[i][col] != symbol) return false;
        }
        return true;
    }

    private boolean diagonalWon(int row, int col, Symbol symbol){
        for(int i=0;i<n;i++){
            if(board[i][i] != symbol) return false;
        }
        return true;
    }

    private boolean reverseDiagonalWon(int row, int col, Symbol symbol){
        for(int i=0,j=n-1;i<n && j>=0;i++,j--){
            if(board[i][j] != symbol) return false;
        }
        return true;
    }

}

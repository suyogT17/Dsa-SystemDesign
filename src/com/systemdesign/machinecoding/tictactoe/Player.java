package com.systemdesign.machinecoding.tictactoe;

public class Player {
    int playerId;
    String playerName;
    Symbol playerSymbol;

    public Player(int playerId, String playerName, Symbol playerSymbol) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerSymbol = playerSymbol;
    }
}

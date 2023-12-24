package com.systemdesign.machinecoding.snakeandladder;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {
    private String playerName;

    @Setter
    private int playerPosition;

    public Player(String playerName, int playerPosition){
        this.playerName = playerName;
        this.playerPosition = playerPosition;
    }
}

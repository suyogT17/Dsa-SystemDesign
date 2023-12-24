package com.systemdesign.machinecoding.snakeandladder;

public class DefaultMoveStrategy implements MoveStrategy{
    @Override
    public void move(Player player, Board board, DiceRoller diceRoller) {
        int num = diceRoller.roll();
        int newPos = player.getPlayerPosition()+num;
        if(board.hasSpecialEntity(newPos)) {
            SpecialEntity specialEntity = board.getSpecialEntity(newPos);
            System.out.println(player.getPlayerName()+" has accessed "+specialEntity.getSpecialEntityType().name()+" from: "+specialEntity.getStart()+" and reached: "+specialEntity.getEnd());
            player.setPlayerPosition(specialEntity.getEnd());
            newPos = player.getPlayerPosition();
        }
        else if(newPos > board.getNumOfCells()){
            System.out.println("Invalid Move "+num+" by "+player.getPlayerName());
        }
        else{
            System.out.println(player.getPlayerName()+" rolled a "+num+" and moved from "+player.getPlayerPosition()+" to "+newPos);
            player.setPlayerPosition(newPos);
        }
    }
}

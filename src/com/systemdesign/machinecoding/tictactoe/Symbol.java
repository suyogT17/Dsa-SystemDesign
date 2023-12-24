package com.systemdesign.machinecoding.tictactoe;

public enum Symbol {
    BLANK(" "), CROSS("X"), ZERO("0");

    String sym;

    public String value(){
        return this.sym;
    }

    private Symbol(String sym){
        this.sym = sym;
    }
}

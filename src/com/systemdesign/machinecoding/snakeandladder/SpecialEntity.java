package com.systemdesign.machinecoding.snakeandladder;

import lombok.Getter;

@Getter
public abstract class SpecialEntity {
    private int start;
    private int end;
    private SpecialEntityType specialEntityType;

    public SpecialEntity(SpecialEntityType specialEntityType, int start, int end){
        this.specialEntityType  = specialEntityType;
        this.start = start;
        this.end = end;
    }
}

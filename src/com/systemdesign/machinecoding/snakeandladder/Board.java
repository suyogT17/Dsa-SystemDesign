package com.systemdesign.machinecoding.snakeandladder;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Board {

    @Getter
    private final int numOfCells = 100;

    private Map<Integer, SpecialEntity> specialEntitiesMap = new HashMap<>();

    public boolean hasSpecialEntity(int cellNumber) {
        return specialEntitiesMap.containsKey(cellNumber);
    }

    public SpecialEntity getSpecialEntity(int cellNumber) {
        return specialEntitiesMap.get(cellNumber);
    }

    public boolean addSpecialEntity(SpecialEntity specialEntity) {
        specialEntitiesMap.put(specialEntity.getStart(), specialEntity);
        return true;
    }
}

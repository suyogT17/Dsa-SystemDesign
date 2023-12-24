package com.systemdesign.machinecoding.conferenceroom.model;

import com.systemdesign.machinecoding.conferenceroom.exception.FloorAlreadyExistException;
import com.systemdesign.machinecoding.conferenceroom.exception.FloorNotExistException;

import java.awt.datatransfer.FlavorListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Building {
    private String buildingName;
    private Map<Integer, Floor> floors;

    public Building(String buildingName) {
        this.buildingName = buildingName;
        this.floors = new HashMap<>();
    }

    public void addFloor(int floorId) throws FloorAlreadyExistException {
        if(floors.containsKey(floorId)){
            throw new FloorAlreadyExistException("Floor with id "+ floorId+" already present in the building "+buildingName);
        }
        else floors.put(floorId, new Floor(floorId));
    }

    public void removeFloor(int floorId) throws FloorNotExistException{
        if(!floors.containsKey(floorId)){
            throw new FloorNotExistException("Floor with id "+ floorId+" not present in the building "+buildingName);
        }
        else floors.put(floorId, new Floor(floorId));
    }
}

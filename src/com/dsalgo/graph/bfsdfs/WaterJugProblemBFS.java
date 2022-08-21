package com.dsalgo.graph.bfsdfs;

import java.util.*;

/**
 * Problem Link: https://leetcode.com/problems/water-and-jug-problem/submissions/
 */
class WaterJugProblemBFS {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity == targetCapacity) return true;
        if (jug1Capacity + jug2Capacity < targetCapacity) return false;
        // cant measure odd capacity with even jugs
        if (jug1Capacity % 2 == 0 && jug2Capacity % 2 == 0 && targetCapacity % 2 != 0) return false;
        Set<String> visited = new HashSet();
        Queue<State> queue = new LinkedList();
        queue.add(new State(0, 0));
        visited.add(0 + "," + 0);
        while (!queue.isEmpty()) {
            State curr = queue.poll();
            if (curr.x + curr.y == targetCapacity) return true;
            visited.add(curr.x + "," + curr.y);
            int newX = 0, newY = 0;
            // add x to y
            newX = curr.x - Math.min(curr.x, jug2Capacity - curr.y);
            newY = curr.y + Math.min(curr.x, jug2Capacity - curr.y);
            if (!visited.contains(newX + "," + newY)) queue.add(new State(newX, newY));
            // add y to x
            newX = curr.x + Math.min(curr.y, jug1Capacity - curr.x);
            newY = curr.y - Math.min(curr.y, jug1Capacity - curr.x);
            if (!visited.contains(newX + "," + newY)) queue.add(new State(newX, newY));
            // empty x
            newX = 0;
            newY = curr.y;
            if (!visited.contains(newX + "," + newY)) queue.add(new State(newX, newY));
            // empty y
            newX = curr.x;
            newY = 0;
            if (!visited.contains(newX + "," + newY)) queue.add(new State(newX, newY));
            // fill x
            newX = jug2Capacity;
            newY = curr.y;
            if (!visited.contains(newX + "," + newY)) queue.add(new State(newX, newY));
            // fill y
            newX = curr.x;
            newY = jug1Capacity;
            if (!visited.contains(newX + "," + newY)) queue.add(new State(newX, newY));
        }
        return false;
    }
}

class State {
    int x, y;

    public State(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
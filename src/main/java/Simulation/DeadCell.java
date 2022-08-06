package Simulation;


import Util.Pair;

import java.util.ArrayList;

/**
 * This cell is dead and does nothing
 */
public class DeadCell extends Cell{
    public DeadCell(Pair coords) {
        setStrength(0);
        setX(coords.getX());
        setY(coords.getY());
        setId(0);
    }
    @Override
    public void interactNeighbors(ArrayList<Cell> neighbors){

    }
}

package Simulation;

import Util.Pair;

import java.util.ArrayList;

import static Util.Calculator.coordFromIndex;
import static Util.Calculator.indexFromCoord;

/**
 * A tissue cell. It wants to grow, but not as much as cancer. Has a chance to turn a dead
 * cell into a live one every time step
 */

public class TissueCell extends Cell{
    public TissueCell(Pair coords)
    {
        setStrength(0);
        setX(coords.getX());
        setY(coords.getY());
        setId(1);
    }
    @Override
    public void interactNeighbors(ArrayList<Cell> neighbors){

        //changes, find way to use interact neighbors without having to pass x and y coordinates through

        /*steps:
        1. Poll neighborhood
        2. replace cell*/

                int xcoord = this.getXcoords();
                int ycoord = this.getYcoords();

                ArrayList<Cell> neighborhood = new ArrayList<>();
                ArrayList<Integer> DeadCellIndices = new ArrayList<>();

                //finds indices of neighboring cells and adds them to an ArrayList
                ArrayList<Integer> neighbor_indices = CheckNeighbors(xcoord, ycoord);

                //adds neighbor cells to an ArrayList
                for(int i : neighbor_indices) {
                    if(i >= 0) {
                        neighborhood.add(neighbors.get(i));
                    }
                }

                // checks for DeadCells in neighborhood and adds their index to an ArrayList
                for(Cell check : neighborhood){
                    if(check.getId() == 0){
                        DeadCellIndices.add(indexFromCoord(check.getXcoords(),check.getYcoords()));
                    }
                }

                // if there are DeadCells, 70% chance that something happens, then random DeadCell is chosen to be replaced
                if(DeadCellIndices.size() != 0){
                    double random = Math.random() * 100;
                    if(random >= 30){
                        double randomDead = Math.random() * DeadCellIndices.size();
                        int toReplace = DeadCellIndices.get((int) randomDead);
                        neighbors.set(toReplace, new TissueCell(coordFromIndex(toReplace)));
                    }
                }




    }
}

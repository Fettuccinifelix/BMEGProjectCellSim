package Simulation;

import Util.Pair;

import java.util.ArrayList;

import static Util.Calculator.indexFromCoord;

/**
 * The immune cell! It kills cancer, and has a chance to attack multiple cancer cells per turn!
 */

public class ImmuneCell extends Cell{
    public ImmuneCell(Pair coords)
    {
        setStrength(3);
        setX(coords.getX());
        setY(coords.getY());
        setId(4);
    }
    public void interactNeighbors(ArrayList<Cell> neighbors){
        int xcoord = this.getXcoords();
        int ycoord = this.getYcoords();

        ArrayList<Cell> neighborhood = new ArrayList<>();
        ArrayList<Integer> CancerCellIndices = new ArrayList<>();

        //finds indices of neighboring cells and adds them to an ArrayList
        ArrayList<Integer> neighbor_indices = CheckNeighbors(xcoord, ycoord);

        //adds neighbor cells to an ArrayList

        for(int i : neighbor_indices) {
            if(i >= 0) {
                neighborhood.add(neighbors.get(i));
            }
        }

        for (Cell check : neighborhood) {
            if (check.getId() == 3) {
                CancerCellIndices.add(indexFromCoord(check.getXcoords(), check.getYcoords()));
            }
        }


            if(CancerCellIndices.size() != 0){
                double randomCancer = Math.random() * CancerCellIndices.size();
                int toReplace = CancerCellIndices.get((int) randomCancer);
                neighbors.get(toReplace).setId(0);

            }

        }
    }
package Simulation;


import Util.Pair;

import java.util.ArrayList;

import static Util.Calculator.indexFromCoord;

/**
 *This is a cancer cell. It is the most complex cell as it can attack tissue or immune cells, or grow into a dead cell.
 * For attacking tissue, it is a 1 hit replace it with a dead cell.
 * Immune cells are cooler. Each hit from a cancer cell lowers its strength by 1. When an immune cell reaches 0 strength
 * it dies!
 *
 * It has a priority of action. If it can grow, it will grow. If it can kill a tissue cell, it will do that. Why?
 * Easiest way to grow is to kill a week tissue cell. If no other option, will attack immune cells. Path of
 * least resistance to growing basically.
 *
 * Growing means turning a dead cell into a CancerCell.
 */

public class CancerCell extends Cell{
    public CancerCell(Pair coords){
        setStrength(1);
        setX(coords.getX());
        setY(coords.getY());
        setId(3);
    }
    @Override
    public void interactNeighbors(ArrayList<Cell> neighbors) {
        int xcoord = this.getXcoords();
        int ycoord = this.getYcoords();

        ArrayList<Cell> neighborhood = new ArrayList<>();
        ArrayList<Integer> DeadCellIndices = new ArrayList<>();
        ArrayList<Integer> ImmuneCellIndices = new ArrayList<>();
        ArrayList<Integer> TissueCellIndices = new ArrayList<>();

        //finds indices of neighboring cells and adds them to an ArrayList
        ArrayList<Integer> neighbor_indices = CheckNeighbors(xcoord, ycoord);

        //adds neighbor cells to an ArrayList

        for(int i : neighbor_indices) {
            if(i >= 0) {
                neighborhood.add(neighbors.get(i));
            }
        }

        // checks for ImmuneCells, TissueCells, and DeadCells in neighborhood and adds their neighbors index to an ArrayList

        for (Cell check : neighborhood) {
            if (check.getId() == 0) {
                DeadCellIndices.add(indexFromCoord(check.getXcoords(), check.getYcoords()));
            }
            else if (check.getId() == 1){
                TissueCellIndices.add(indexFromCoord(check.getXcoords(), check.getYcoords()));
            }
            else if (check.getId() == 4){
                ImmuneCellIndices.add(indexFromCoord(check.getXcoords(), check.getYcoords()));
            }
        }

        //
        if(DeadCellIndices.size() != 0){
            double randomDead = Math.random() * DeadCellIndices.size();
            int toReplace1 = DeadCellIndices.get((int) randomDead);
            neighbors.get(toReplace1).setId(3);

        }

        else if(TissueCellIndices.size() > ImmuneCellIndices.size() && TissueCellIndices.size() >= 1){
            double randomTissue = Math.random() * TissueCellIndices.size();
            int toReplace2 = TissueCellIndices.get((int) randomTissue);
            neighbors.get(toReplace2).setId(0);
        }

        else if(ImmuneCellIndices.size() != 0){
            double randomImmune = Math.random() * ImmuneCellIndices.size();
            int toReplace3 = ImmuneCellIndices.get((int) randomImmune);
            if(neighbors.get(toReplace3).getStrength() == 0){
                neighbors.get(toReplace3).setId(0);
            }
            else{
                int currentStr = neighbors.get(toReplace3).getStrength();
                neighbors.get(toReplace3).setStrength(currentStr - 1);
            }
        }


    }
}

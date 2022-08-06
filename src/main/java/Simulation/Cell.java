package Simulation;

import java.util.ArrayList;

import static Util.Calculator.indexFromCoord;


/**
 * The default, boring cell.
 */

public abstract class Cell {
    private int strength, x, y, id;

    public Cell(int strength, int x, int y, int id) {
        setStrength(strength);
        setX(x);
        setY(y);
        setId(id);

    }

    public Cell() {
        strength = 0;
        x = 0;
        y = 0;
        id = 0;
    }

    public void interactNeighbors(ArrayList<Cell> neighbors) {

    }


    //setters
    public void setStrength(int strength) {
        if (strength <= 0) {
            this.strength = 0;
        } else {
            this.strength = strength;
        }

    }

    public void setX(int x) {
        if (x <= 0) {
            this.x = 0;
        } else {
            this.x = x;
        }

    }

    public void setY(int y) {
        if (y <= 0) {
            this.y = 0;
        } else {
            this.y = y;
        }

    }

    public void setId(int id) {
        if (id <= 0) {
            this.id = 0;
        } else {
            this.id = id;
        }

    }

    //getters
    public int getStrength() {
        return this.strength;
    }

    public int getXcoords() {
        return this.x;
    }

    public int getYcoords() {
        return this.y;
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Integer> CheckNeighbors(int xcoord, int ycoord) {

        ArrayList<Integer> indices = new ArrayList<>();
        int xcoord1 = xcoord + 1;
        int xcoord_1 = xcoord - 1;
        int ycoord1 = ycoord + 1;
        int ycoord_1 = xcoord - 1;


                //uses coordinates of neighbors, checks if coordinates are valid before finding index and adding it to an ArrayList

                if (xcoord_1 < 100 && xcoord_1 >= 0 && ycoord1 < 100 && ycoord1 >= 0) {
                    indices.add(indexFromCoord(xcoord_1, ycoord1));
                }
                if (xcoord < 100 && xcoord >= 0 && ycoord1 < 100 && ycoord1 >= 0) {
                    indices.add(indexFromCoord(xcoord, ycoord1));
                }
                if (xcoord1 < 100 && xcoord1 >= 0 && ycoord1 < 100 && ycoord1 >= 0) {
                    indices.add(indexFromCoord(xcoord1, ycoord1));
                }
                if (xcoord_1 < 100 && xcoord_1 >= 0 && ycoord < 100 && ycoord >= 0) {
                    indices.add(indexFromCoord(xcoord_1, ycoord));
                }
                if (xcoord1 < 100 && xcoord1 >= 0 && ycoord < 100 && ycoord >= 0) {
                    indices.add(indexFromCoord(xcoord1, ycoord));
                }
                if (xcoord_1 < 100 && xcoord_1 >= 0 && ycoord_1 < 100 && ycoord_1 >= 0) {
                    indices.add(indexFromCoord(xcoord_1, ycoord_1));
                }
                if (xcoord < 100 && xcoord >= 0 && ycoord_1 < 100 && ycoord_1 >= 0) {
                    indices.add(indexFromCoord(xcoord, ycoord_1));
                }
                if (xcoord1 < 100 && xcoord1 >= 0 && ycoord_1 < 100 && ycoord_1 >= 0) {
                    indices.add(indexFromCoord(xcoord1, ycoord_1));
                }

                return indices;

            }


}




package org;

public class Cell {

    // Constants for cell types for better readability
    public static final int START = 0;
    public static final int FINISH = 1;
    public static final int WALL = 2;
    public static final int EMPTY = 3;
    public static final int CHECKED = 4;
    public static final int FINAL_PATH = 5;

    private int cellType; // Type of the cell
    private final int x;  // X-coordinate of the cell
    private final int y;  // Y-coordinate of the cell
    private int lastX;    // X-coordinate of the last cell in the path
    private int lastY;    // Y-coordinate of the last cell in the path
    private int hops;     // Number of steps taken to reach this cell

    /**
     * Constructor for the Cell class.
     *
     * @param type Type of the cell (use constants START, FINISH, etc.).
     * @param x    X-coordinate of the cell.
     * @param y    Y-coordinate of the cell.
     */
    public Cell(int type, int x, int y) {
        this.cellType = type;
        this.x = x;
        this.y = y;
        this.hops = -1; // Default value for hops, indicating uninitialized
    }

    // Getter methods
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLastX() {
        return lastX;
    }

    public int getLastY() {
        return lastY;
    }

    public int getType() {
        return cellType;
    }

    public int getHops() {
        return hops;
    }

    // Setter methods
    public void setType(int type) {
        this.cellType = type;
    }

    public void setLastCell(int x, int y) {
        this.lastX = x;
        this.lastY = y;
    }

    public void setHops(int hops) {
        this.hops = hops;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "type=" + cellType +
                ", x=" + x +
                ", y=" + y +
                ", lastX=" + lastX +
                ", lastY=" + lastY +
                ", hops=" + hops +
                '}';
    }
}

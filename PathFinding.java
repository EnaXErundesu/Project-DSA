package org;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PathFinding {
    // FRAME
    JFrame frame;
    // GENERAL VARIABLES
    private int cells = 20;
    private int delay = 30;
    private double dense = .5;
    private double density = (cells * cells) * .5;
    private int startx = -1;
    private int starty = -1;
    private int finishx = -1;
    private int finishy = -1;
    private int tool = 0;
    private int checks = 0;
    private int length = 0;
    private int curAlg = 0;
    private final int WIDTH = 850;
    private final int HEIGHT = 650;
    private final int MSIZE = 600;
    private int CSIZE = MSIZE / cells;
    // UTIL ARRAYS
    private final String[] algorithms = {"Dijkstra", "A*", "Depth-First", "Breadth-First", "Bellman-Ford"};
    private final String[] tools = {"Start", "Finish", "Wall", "Eraser"};
    // BOOLEANS
    private boolean solving = false;
    // UTIL
    Cell[][] map;
    Algorithm Alg = new Algorithm();
    Random r = new Random();
    // SLIDERS
    JSlider size = new JSlider(1, 5, 2);
    JSlider speed = new JSlider(0, 500, delay);
    JSlider obstacles = new JSlider(1, 100, 50);
    // LABELS
    JLabel cellsL = new JLabel(cells + "x" + cells);
    JLabel msL = new JLabel(delay + "ms");
    JLabel densityL = new JLabel(obstacles.getValue() + "%");
    JLabel checkL = new JLabel("Checks: " + checks);
    JLabel lengthL = new JLabel("Path Length: " + length);
    // BUTTONS
    JButton searchB = new JButton("Start Search");
    JButton resetB = new JButton("Reset");
    JButton genMapB = new JButton("Generate Map");
    JButton clearMapB = new JButton("Clear Map");
    // DROP DOWN
    JComboBox<String> algorithmsBx = new JComboBox<>(algorithms);
    JComboBox<String> toolBx = new JComboBox<>(tools);
    // PANELS
    JPanel toolP = new JPanel();
    // CANVAS
    Map canvas;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PathFinding::new);
    }

    public PathFinding() {
        clearMap();
        initialize();
    }

    public void clearMap() {
        finishx = -1;
        finishy = -1;
        startx = -1;
        starty = -1;
        map = new Cell[cells][cells];
        for (int x = 0; x < cells; x++) {
            for (int y = 0; y < cells; y++) {
                map[x][y] = new Cell(3, x, y);
            }
        }
        reset();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setTitle("Path Finding");
        frame.setResizable(false);
        frame.setLayout(null);

        toolP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Controls"));
        toolP.setBounds(10, 10, 200, 600);
        toolP.setLayout(null);

        searchB.setBounds(40, 30, 120, 25);
        resetB.setBounds(40, 70, 120, 25);
        genMapB.setBounds(40, 110, 120, 25);
        clearMapB.setBounds(40, 150, 120, 25);

        toolP.add(searchB);
        toolP.add(resetB);
        toolP.add(genMapB);
        toolP.add(clearMapB);

        frame.add(toolP);

        canvas = new Map();
        canvas.setBounds(220, 10, MSIZE, MSIZE);
        frame.add(canvas);

        // Add listeners
        searchB.addActionListener(e -> solving = true);
        resetB.addActionListener(e -> {
            reset();
            update();
        });
        genMapB.addActionListener(e -> {
            generateMap();
            update();
        });
        clearMapB.addActionListener(e -> {
            clearMap();
            update();
        });

        frame.setVisible(true);
    }

    private void reset() {
        solving = false;
        length = 0;
        checks = 0;
    }

    private void update() {
        density = (cells * cells) * dense;
        canvas.repaint();
        cellsL.setText(cells + "x" + cells);
        msL.setText(delay + "ms");
        densityL.setText(obstacles.getValue() + "%");
        checkL.setText("Checks: " + checks);
        lengthL.setText("Path Length: " + length);
    }

    public void generateMap() {
        clearMap();
        for (int i = 0; i < density; i++) {
            Cell current;
            do {
                int x = r.nextInt(cells);
                int y = r.nextInt(cells);
                current = map[x][y];
            } while (current.getType() == 2);
            current.setType(2);
        }
    }

    class Map extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int x = 0; x < cells; x++) {
                for (int y = 0; y < cells; y++) {
                    switch (map[x][y].getType()) {
                        case 0 -> g.setColor(Color.GREEN);
                        case 1 -> g.setColor(Color.RED);
                        case 2 -> g.setColor(Color.BLACK);
                        case 3 -> g.setColor(Color.WHITE);
                        default -> g.setColor(Color.YELLOW);
                    }
                    g.fillRect(x * CSIZE, y * CSIZE, CSIZE, CSIZE);
                    g.setColor(Color.BLACK);
                    g.drawRect(x * CSIZE, y * CSIZE, CSIZE, CSIZE);
                }
            }
        }
    }

    class Cell {
        private int type;
        private final int x, y;

        public Cell(int type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }

    class Algorithm {
        // TODO: Add algorithm implementations
    }
}

package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    int rows, cols;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        init(frame.configPanel.getRows(), frame.configPanel.getCols());
    }

    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        //dc merge sa instantiez clasa asta abstracta????//!!!!!!!
        g.setColor(Color.PINK);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        paintGrid(g);
        paintSticks(g);
        paintStones(g);
    }

    private void paintGrid(Graphics2D g) {
        g.setColor(Color.BLACK);
        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            g.drawLine(x1, y1, x2, y2);
        }
        //vertical lines
        for (int col = 0; col < cols; col++) {
            int x1 = padX + cellWidth * col;
            int y1 = padY;
            int x2 = padX + cellWidth * col;
            int y2 = y1 + boardHeight;
            g.drawLine(x1, y1, x2, y2);
        }
        //intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                g.setColor(Color.YELLOW);
                g.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }
    private void paintSticks(Graphics2D g){
        Random rand = new Random();
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(3));

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;

                if (row < rows - 2 && col < cols - 2) {
                    if (rand.nextBoolean()) {
                        if (rand.nextBoolean()) {
                            int startY = y + cellHeight ;
                            int startX = x;
                            int endX = x + cellWidth;
                            g.drawLine(startX, startY, endX, startY);
                        } else {
                            int startX = x + cellWidth ;
                            int startY = y;
                            int endY = y + cellHeight;
                            g.drawLine(startX, startY, startX, endY);
                        }
                    }
                }
            }
        }
        //g.setStroke(new BasicStroke(1));   //pensula ce face
    }

    public boolean isPlayerRedTurn() {
        return true;
    }
    public boolean isPlayerBlueTurn() {
        return false;
    }
    private void paintStones(Graphics2D g){
        if (isPlayerRedTurn()) {
            g.setColor(Color.red);
        }
        else{
                g.setColor(Color.blue);
            }
        g.fillOval((int) (boardHeight-stoneSize/2), (int) (boardHeight-stoneSize/2),
                (int) stoneSize,(int) stoneSize);
        }
    }




//noduri -> ma duc la vecini->adaug muchie-> tot asa
//lista de noduri  -> 0.....9
//10...19 -> row col
//adaug nr in lista



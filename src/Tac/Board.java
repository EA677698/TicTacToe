package Tac;

import java.awt.*;

public class Board {


    //0 = Empty
    //1 = X
    //2 = O
    private int[][] board;
    private Rectangle[][] rectangles = new Rectangle[3][3];

    public Board(){
        board = new int[3][3];
        rectangles[0][0] = new Rectangle(120,120,120,120);
        rectangles[0][1] = new Rectangle(240,120,120,120);
        rectangles[0][2] = new Rectangle(360,120,120,120);
        rectangles[1][0] = new Rectangle(120,240,120,120);
        rectangles[1][1] = new Rectangle(240,240,120,120);
        rectangles[1][2] = new Rectangle(360,240,120,120);
        rectangles[2][0] = new Rectangle(120,360,120,120);
        rectangles[2][1] = new Rectangle(240,360,120,120);
        rectangles[2][2] = new Rectangle(360,360,120,120);
    }

    public Rectangle[][] getRectangles(){
        return rectangles;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
}

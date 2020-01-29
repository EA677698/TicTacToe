package Tic;

import Toe.Mechanics;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {

    public static String currentString = "";

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //g.drawRect(Window.mouseHitbox.x,Window.mouseHitbox.y,Window.mouseHitbox.width,Window.mouseHitbox.height);
        for(int i = 0; i<Main.board.getBoard().length; i++){
            for(int e = 0; e<Main.board.getBoard().length; e++){
                if(Main.board.getBoard()[i][e]==1){
                    //This is for the X
                    g.drawLine(Main.board.getRectangles()[i][e].x,Main.board.getRectangles()[i][e].y,Main.board.getRectangles()[i][e].x+120,Main.board.getRectangles()[i][e].y+120);
                    g.drawLine(Main.board.getRectangles()[i][e].x+120,Main.board.getRectangles()[i][e].y,Main.board.getRectangles()[i][e].x,Main.board.getRectangles()[i][e].y+120);
                } else if(Main.board.getBoard()[i][e]==2){
                    //This is for the O
                    g.drawOval(Main.board.getRectangles()[i][e].x,Main.board.getRectangles()[i][e].y,Main.board.getRectangles()[i][e].width,Main.board.getRectangles()[i][e].height);
                }
            }
        }
        for(Rectangle[] rectangle: Main.board.getRectangles()){
            for(Rectangle rectangle1: rectangle){
                g.drawRect(rectangle1.x,rectangle1.y,rectangle1.width,rectangle1.height);
            }
        }
        g.setFont(new Font("Arial",Font.BOLD,20));
        g.drawString(currentString,250,550);
        if(!Mechanics.endGame){
            if(Mechanics.playerTurn){
                Mechanics.playerTurn();
            } else {
                Mechanics.computerTurn();
            }
        } else {
            return;
        }
        repaint();
    }
}

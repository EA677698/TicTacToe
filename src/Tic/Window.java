package Tic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Window extends JFrame implements MouseListener, MouseMotionListener {

    public static boolean click;
    public static Rectangle mouseHitbox = new Rectangle(0,0,30,30);

    public Window(){}

    @Override
    public void mouseClicked(MouseEvent e) {
        click = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        click = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseHitbox.setLocation(e.getX()-20,e.getY()-50);
    }
}

package Tic;

import Tac.Board;
import Toe.Mechanics;

import javax.swing.*;

public class Main {

    public static Window window;
    public static Board board;
    public static Screen screen;

    public static void main(String[] args) {
        window = new Window();
        board = new Board();
        screen = new Screen();
        window.setTitle("Tic Tac Toe");
        window.setSize(650,650);
        window.addMouseListener(window);
        window.addMouseMotionListener(window);
        window.add(screen);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        Mechanics.randomStart();

    }
}

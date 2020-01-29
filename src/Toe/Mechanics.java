package Toe;

import Tic.Main;
import Tic.Screen;
import Tic.Window;

import java.util.Arrays;

public class Mechanics {

    public static int player,computer;
    public static boolean playerTurn = false;
    public static boolean endGame = false;

    public static void randomStart(){
        if((Math.random()*10)<5){
            playerTurn = true;
            player = 1;
            computer = 2;
            playerTurn();
        } else {
            computer = 1;
            player = 2;
            computerTurn();
        }
    }

    public static void printBoard(){
        System.out.println(Arrays.toString(Main.board.getBoard()[0]));
        System.out.println(Arrays.toString(Main.board.getBoard()[1]));
        System.out.println(Arrays.toString(Main.board.getBoard()[2]));

    }



    public static void playerTurn(){
        Screen.currentString = "It's Your Turn!";
        if(!endGame){
            if(Window.click){
                for(int i = 0; i<Main.board.getRectangles().length; i++){
                    for(int e = 0; e<Main.board.getRectangles().length; e++){
                        if(playerTurn&&Main.board.getRectangles()[i][e].intersects(Window.mouseHitbox)){
                            if(Main.board.getBoard()[i][e]==0){
                                Main.board.getBoard()[i][e] = player;
                                playerTurn = false;
                                if(winCondition(player)){
                                    Screen.currentString = "Player Wins!";
                                }
                            }
                            Window.click = false;
                        }
                    }
                }
            }
        }
    }

    public static void computerTurn(){
        Screen.currentString = "It's The Computer's Turn!";
        System.out.println(" ");
        if(!endGame){
            if(!playerTurn){
                int one = (int)(Math.random()*3);
                int two = (int)(Math.random()*3);
                if(Main.board.getBoard()[one][two]==0){
                    Main.board.getBoard()[one][two] = computer;
                    playerTurn = true;
                    if(winCondition(computer)){
                        Screen.currentString = "Computer Wins!";
                    }
                    return;
                } else{
                    computerTurn();
                }
            }
        }
    }

    public static boolean winCondition(int players){
        int totalX = 0;
        int totalY = 0;
        int totalDiag1 = 0;
        int totalDiag2 = 0;
            for(int i = 0; i<Main.board.getBoard().length; i++){
                for(int e = 0; e<Main.board.getBoard()[0].length; e++){
                    if(Main.board.getBoard()[i][e]==players){
                        totalX++;
                    }
                    if(Main.board.getBoard()[e][i]==players){
                        totalY++;
                    }
                }
                if(totalX==3||totalY==3){
                    endGame = true;
                    return true;
                }
                totalX = 0;
                totalY = 0;
            }
        int e = 0;
        for(int i = 0; i<3; i++){
            if(Main.board.getBoard()[i][e]==players){
                totalDiag1++;
                e++;
            }
        }
        if(totalDiag1==3){
            endGame = true;
            return true;
        }
        e = 2;
        for(int i = 0; i<3; i++){
            if(Main.board.getBoard()[i][e]==players){
                totalDiag2++;
                e--;
            }
        }
        if(totalDiag2==3){
            endGame = true;
            return true;
        }
        isBoardFull();

        return false;
    }

    public static boolean isBoardFull(){
        int total = 0;
        for(int i = 0; i<Main.board.getBoard().length; i++){
            for(int e = 0; e<Main.board.getBoard().length; e++){
                if(Main.board.getBoard()[i][e]!=0){
                    total++;
                }
            }
        }
        if(total>=9){
            endGame = true;
            Screen.currentString = "Draw";
            return true;
        }
        return false;
    }

}

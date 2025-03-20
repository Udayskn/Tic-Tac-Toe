import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Board playBoard = new Board() ;
        Scanner scan = new Scanner(System.in);
        Random choice = new Random() ;
        System.out.println("Welcome to the game:");
        for (int i=0;i<9;i=i+3){ //row wise
            System.out.println("| " + (i) + " " +
                               "| " + (i+1) + " " +
                               "| " + (i+2) + " " +
                               "|") ;
        }
        System.out.println("______________________") ;
        System.out.println("Choose to play against(0-player/1-computer): ");
        int is_comp = scan.nextInt() ;
        if (is_comp == 0) {
            while(!playBoard.gameEnd()){
                boolean move = false ;
                while(!move){
                    System.out.println("Choose the position to place your symbol X (player 1)");
                    int pos = scan.nextInt() ;
                    move = playBoard.makeMove(1, pos);
                    if (!move ){
                        System.out.println("The place had already occupied");
                    }
                }
                playBoard.displayBoard();
                if(playBoard.gameDraw() || playBoard.gameEnd()) break ;
                move = false ;
                while(!move){
                    System.out.println("Choose the position to place your symbol O (player 2)");
                    int pos = scan.nextInt() ;
                    move = playBoard.makeMove(2, pos);
                    if (!move ){
                        System.out.println("The place had already occupied");
                    }
                }
                playBoard.displayBoard();
            }
            playBoard.gameResult();
        }
        else {
            while(!playBoard.gameEnd()){
                boolean move = false ;
                while(!move){
                    System.out.println("Choose the position to place your symbol X");
                    int pos = scan.nextInt() ;
                    move = playBoard.makeMove(1, pos);
                    if (!move ){
                        System.out.println("The place had already occupied");
                    }
                }
                playBoard.displayBoard();
                if(playBoard.gameDraw() || playBoard.gameEnd()) break ;
                move = false ;
                while(!move){
                    int pos = choice.nextInt(9);
                    move = playBoard.makeMove(2, pos);
                    if ( move ){
                        System.out.println("The Computer chose : " + pos );
                    }
                }
                playBoard.displayBoard();
            }
            playBoard.gameResult(true);
        }

    }
}

import java.util.HashMap ;
public class Board {
    private HashMap<Integer,Character> board = new HashMap<>() ;
    private HashMap<Integer,Character> symbol = new HashMap<>() ;
    private HashMap<Character, Integer> p = new HashMap<>() ;
    public Board() {
        for (int i=0;i<9;i++){
            board.put(i,' ') ;
        }
        symbol.put(1,'X');
        symbol.put(2,'O');
        p.put('X', 1);
        p.put('O', 2);
    }
    public int winner  ; //1 or 2
    public boolean makeMove(int player,int pos) {
        if (board.get(pos) != ' '){
            return false;
        }
        board.put(pos,symbol.get(player) ) ;
        return true;
    }
    public boolean gameDraw(){
        for (int i=0;i<9;i++){
            if ( board.get(i) == ' ' ) return false ;
        }
        return true;
    }
    public boolean gameEnd(){
        for (int i=0;i<9;i=i+3){ // row check
            if(board.get(i) == ' ') continue;
            if(board.get(i) == board.get(i+1) && board.get(i+1) == board.get(i+2)) {
                this.winner = p.get(board.get(i)) ;
                return true;
            }

        }
        for (int i=0;i<3;i=i+1){ // column check
            if(board.get(i) == ' ') continue;
            if(board.get(i) == board.get(i+3) && board.get(i+3) == board.get(i+6)) {
                this.winner = p.get(board.get(i));
                return true;
            }

        }
        if (board.get(4) != ' '){ // diagonal check
            if(board.get(4) == board.get(1) && board.get(4) == board.get(8) ){
                this.winner = p.get(board.get(4));
                return true;
            }
            if(board.get(4) == board.get(2) && board.get(4) == board.get(6) ){
                this.winner =p.get(board.get(4)) ;
                return true;
            }
        }
        return false ;
    }
    public void displayBoard(){
        System.out.println("Current Game Situation:\n");
        for (int i=0;i<9;i=i+3){ //row wise
            System.out.println("| " + board.get(i) + " " +
                               "| " + board.get(i+1) + " " +
                               "| " + board.get(i+2) + " " +
                               "|") ;
        }
        System.out.println("______________________") ;
    }
    public void gameResult(){
        if (gameEnd()) {
            System.out.println("Congratulations");
            System.out.println("Player "+ winner + " has won the game");
        }
        else {
            System.out.println("The Game ended as a draw");
        }
    }
    public void gameResult2(){
        if (gameEnd() && winner == 1) {
            System.out.println("Congratulations!!!");
            System.out.println("You "+ " have won the game");
        }
        else if (gameEnd() && winner == 2){
            System.out.println("Oops!!!");
            System.out.println("You "+ " have lost the game");
        }
        else {
            System.out.println("The Game ended as a draw");
        }
    }
}

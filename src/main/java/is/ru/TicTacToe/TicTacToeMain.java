package is.ru.TicTacToe;

import java.util.Scanner;
import is.ru.TicTacToe.TicTacToe;
import is.ru.TicTacToe.TicTacToe.STATE;


public class TicTacToeMain {
public static TicTacToe game;

  public static void main(String[] args){
                game = new TicTacToe();
		playGame(game);
    }

    // Game is ran, goes a round as long as there is a free space and no winner yet. 
 public static void playGame(TicTacToe game){
		System.out.println("Let the games begin!");
                while(game.isAnyFreeSpotLeft() && !game.isWinner(STATE.CIRCLE) && !game.isWinner(STATE.CROSS)){
                        
			moveplayer("cross", game);
                        game.isThreeInRow(STATE.CROSS);
                        if(!game.isWinner(STATE.CROSS)){
                                moveplayer("circle", game);
                               game.isThreeInRow(STATE.CIRCLE);
                        }
                        else{
                                System.out.println("The player with the CROSS is the winner!");
                        }
                }
                if(game.isWinner(STATE.CIRCLE)){
                        System.out.println("The player with the CIRCLE is the winner!");
                }
 }

 private static void moveplayer(String l, TicTacToe game){
                Scanner in = new Scanner(System.in);
                        int x = -1;
                        int y = -1;
			if(l == "cross"){
				System.out.println("The player with the CROSS can make a move:");
			}
			else{
				System.out.println("The player with the CIRCLE can make a move:");
			}
                        while(x < 0 || x > 2 || y < 0 || y > 2 || !game.isBlank(x,y)){
                                x = in.nextInt();
                                y = in.nextInt();
				if(x < 0 || x > 2 || y < 0 || y > 2){
					System.out.println("You are off the board buddy, pick again!");
				}
				
                                else if(!game.isBlank(x,y)){
                                        System.out.println("This one is taken, please try again!");
                                }
                        }
                        if(l == "cross"){
                                game.setCross(x,y);
                        }
                        else{
                                game.setCircle(x,y);
                        }
        }
}


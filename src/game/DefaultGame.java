package game;

import queue.Player;
import queue.PlayersQueue;

import java.util.Queue;
import java.util.Scanner;

public class DefaultGame extends Game{
  private Player gameWinner;
  public DefaultGame(){
    super();
  }
  @Override
  public void play() {
    GameRound round = new GameRound();
    while (!isGameOver()) {
      round.playRound();
      System.out.println("Play another round? (y/n)");
      Scanner input = new Scanner(System.in);
      String playMore = input.next();
      if (!playMore.equals("y")){
        break;
      }
    }
    displayWinner();
  }
  
  private Boolean isGameOver(){
    Queue<Player> playerQueue = PlayersQueue.getInstance().getQueue();
    int maxScore = 0;
    for (Player player : playerQueue){
      if(player.getScore() >= maxScore){
        maxScore = player.getScore();
        gameWinner = player;
      }
    }
    return gameWinner.getScore() >= 500;
  }
  
  private void displayWinner(){
    System.out.println(gameWinner.getName().toUpperCase() + " HAS WON WITH A SCORE OF " + gameWinner.getScore() + "!!!!!");
  }
}

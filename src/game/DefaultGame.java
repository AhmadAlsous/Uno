package game;

import exceptions.InvalidInputException;
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
      if(isGameOver() || playMore().equals("n")){
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
  
  private String playMore(){
    Boolean validInput = false;
    while (!validInput){
      try {
        System.out.println("Play another round? (y/n)");
        Scanner input = new Scanner(System.in);
        String playMore = input.next();
        if (!(playMore.equalsIgnoreCase("y") || playMore.equalsIgnoreCase("n"))){
          throw new InvalidInputException("You must enter y or n.");
        }
        validInput = true;
        return playMore.toLowerCase();
      } catch (InvalidInputException e) {
        System.out.println(e.getMessage());
      }
    }
    return "";
  }
  
  private void displayWinner(){
    System.out.println();
    System.out.println("🎉🎉🎉🎉🎉");
    System.out.println(gameWinner.getName().toUpperCase() + " HAS WON WITH A SCORE OF " + gameWinner.getScore() + "!!!!!");
  }
}

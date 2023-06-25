package game;

import exceptions.InvalidInputException;
import queue.Player;
import queue.PlayersQueue;

import java.util.Scanner;

public class DefaultGame extends Game{
  public DefaultGame(){
    Options defaultOptions=new Options();
    setOptions(defaultOptions);
    setPlayersQueue(PlayersQueue.getInstance().getQueue());
  }
  @Override
  public void play() {
    while (!isGameOver()) {
      setGameRound(new GameRound(getPlayersQueue(), getOptions()));
      getGameRound().playRound();
      if(isGameOver() || playMore().equals("n")){
        break;
      }
    }
    displayWinner();
  }
  
  private Boolean isGameOver(){
    int maxScore = 0;
    for (Player player : getPlayersQueue()){
      if(player.getScore() >= maxScore){
        maxScore = player.getScore();
        setGameWinner(player);
      }
    }
    return getGameWinner().getScore() >= 500;
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
    System.out.println(getGameWinner().getName().toUpperCase() + " HAS WON WITH A SCORE OF " + getGameWinner().getScore() + "!!!!!");
  }
}

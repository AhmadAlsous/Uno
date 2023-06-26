package game;

import defaultGame.DefaultRound;
import queue.Player;

import java.util.Queue;

public abstract class Game {
  protected Options options;
  protected Queue<Player> playersQueue;
  protected Player gameWinner;
  protected GameRound gameRound;
  
  public void play(){
    while (!isGameOver()) {
      gameRound = new DefaultRound(playersQueue, options);
      gameRound.playRound();
      if(isGameOver() || playMore().equals("n")){
        break;
      }
    }
    displayWinner();
  }
  
  protected abstract boolean isGameOver();
  protected abstract String playMore();
  protected abstract void displayWinner();
  
}

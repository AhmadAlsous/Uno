package game;

import queue.Player;

import java.util.Queue;

public abstract class Game {
  private Options options;
  private Queue<Player> playersQueue;
  private Player gameWinner;
  private GameRound gameRound;
  
  public Options getOptions() {
    return options;
  }
  
  public void setOptions(Options o){
    options=o;
  }
  
  public Queue<Player> getPlayersQueue() {
    return playersQueue;
  }
  
  public void setPlayersQueue(Queue<Player> playersQueue) {
    this.playersQueue = playersQueue;
  }
  
  public Player getGameWinner() {
    return gameWinner;
  }
  
  public void setGameWinner(Player gameWinner) {
    this.gameWinner = gameWinner;
  }
  
  public GameRound getGameRound() {
    return gameRound;
  }
  
  public void setGameRound(GameRound gameRound) {
    this.gameRound = gameRound;
  }
  
  public abstract void play();
}

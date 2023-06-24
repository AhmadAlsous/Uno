package game;

import queue.Player;
import queue.PlayersQueue;

import java.util.Queue;

public class PreGame {
  public void initializeGame(){
    Queue<Player> queue=PlayersQueue.getInstance().getQueue();
    int numOfPlayers= queue.size();
    Options options=new Options();
    int numOfCardsPerPlayer=options.getNumOfCardsPerPlayer();
    for(int i=0;i<numOfPlayers;i++){
      Player player= queue.remove();
      player.drawCard(numOfCardsPerPlayer);
      queue.add(player);
    }
  }
  
}

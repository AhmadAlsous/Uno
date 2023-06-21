package game;

import abstractCard.Card;
import queue.Player;
import queue.PlayersQueue;

import java.util.List;
import java.util.Queue;

import static UI.Display.printPlayerCards;

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
    printAllCards(queue);
    printPlayerCards(queue.peek());
  }
  
  private void printAllCards(Queue<Player> queue){
    int numOfPlayers= queue.size();
    for(int i=0;i<numOfPlayers;i++) {
      Player player = queue.remove();
      List<Card> l = player.getCardList();
      System.out.println(player.getName());
      for (Card c : l) {
        c.print();
      }
      System.out.println("-----------------------------------");
      queue.add(player);
    }
  }
  
}

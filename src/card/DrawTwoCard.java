package card;

import abstractCard.ActionCard;
import abstractCard.Color;
import queue.Player;
import queue.PlayersQueue;

import java.util.Queue;

import static game.GameRound.nextPlayer;

public class DrawTwoCard extends ActionCard {
  public DrawTwoCard(Color color) {
    super(color);
  }
  
  @Override
  public String getCardName() {
    return "DrawTwo";
  }
  
  @Override
  public void performAction(){
    Queue<Player> playerQueue = PlayersQueue.getInstance().getQueue();
    nextPlayer();
    playerQueue.peek().drawCard(2);
    System.out.println(playerQueue.peek().getName()+" has drawn two cards!");
    nextPlayer();
  }
}

package card;

import abstractCard.WildCard;
import queue.Player;
import queue.PlayersQueue;

import java.util.Queue;

import static game.GameRound.nextPlayer;

public class WildDrawFourCard extends WildCard {
  @Override
  public String getCardName() {
    return "Draw Four";
  }
  
  @Override
  public void performAction() {
    chooseColor();
    Queue<Player> playerQueue = PlayersQueue.getInstance().getQueue();
    nextPlayer(playerQueue);
    playerQueue.peek().drawCard(4);
    System.out.println(playerQueue.peek().getName()+" has drawn four cards!");
    nextPlayer(playerQueue);
  }
}

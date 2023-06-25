package card;

import abstractCard.WildCard;
import queue.Player;
import queue.PlayersQueue;

import java.util.Queue;

import static game.GameRound.nextPlayer;

public class WildColorCard extends WildCard {
  @Override
  public String getCardName() {
    return "Wild";
  }
  
  @Override
  public void performAction() {
    chooseColor();
    Queue<Player> playerQueue = PlayersQueue.getInstance().getQueue();
    nextPlayer();
  }
}

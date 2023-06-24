package card;

import abstractCard.ActionCard;
import abstractCard.Color;
import queue.Player;
import queue.PlayersQueue;

import java.util.Queue;

import static game.GameRound.nextPlayer;

public class SkipCard extends ActionCard {
  public SkipCard(Color color) {
    super(color);
  }
  @Override
  public String getCardName() {
    return "Skip";
  }
  
  @Override
  public void performAction() {
    Queue<Player> playerQueue = PlayersQueue.getInstance().getQueue();
    nextPlayer(playerQueue);
    System.out.println(playerQueue.peek().getName()+" has been skipped!");
    nextPlayer(playerQueue);
  }
  
}

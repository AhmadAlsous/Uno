package card;

import abstractCard.WildCard;

import static game.GameRound.nextPlayer;

public class WildColorCard extends WildCard {
  @Override
  public String getCardName() {
    return "Wild";
  }
  
  @Override
  public void performAction() {
    chooseColor();
    nextPlayer();
  }
}

package card;

import abstractCard.WildCard;

public class WildDrawFourCard extends WildCard {
  public void print(){
    System.out.println("WildDrawFour");
  }
  
  @Override
  public String getCardName() {
    return "Draw Four";
  }
}

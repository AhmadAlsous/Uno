package card;

import abstractCard.WildCard;

public class WildColorCard extends WildCard {
  public void print(){
    System.out.println("Wild");
  }
  
  @Override
  public String getCardName() {
    return "Wild ";
  }
}

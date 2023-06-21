package card;

import abstractCard.ActionCard;
import abstractCard.Color;

public class SkipCard extends ActionCard {
  public SkipCard(Color color) {
    super(color);
  }
  
  public void print(){
    System.out.println("Skip "+getColor());
  }
  
  @Override
  public String getCardName() {
    return "Skip ";
  }
}

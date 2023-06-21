package card;

import abstractCard.ActionCard;
import abstractCard.Color;

public class ReverseCard extends ActionCard {
  public ReverseCard(Color color) {
    super(color);
  }
  
  public void print(){
    System.out.println("Reverse "+getColor());
  }
  
  @Override
  public String getCardName() {
    return "Reverse";
  }
}

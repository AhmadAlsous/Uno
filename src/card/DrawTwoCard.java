package card;

import abstractCard.ActionCard;
import abstractCard.Color;

public class DrawTwoCard extends ActionCard {
  public DrawTwoCard(Color color) {
    super(color);
  }
  
  public void print(){
    System.out.println("DrawTwo "+getColor());
  }
  
  @Override
  public String getCardName() {
    return "DrawTwo";
  }
}

package card;

import abstractCard.ActionCard;
import abstractCard.Card;
import abstractCard.Color;
import abstractCard.WildCard;

public class NumberedCard implements Card {
  private final int number;
  private final Color color;
  
  public NumberedCard(int number, Color color) {
    this.number = number;
    this.color = color;
  }
  public int getNumber() {
    return number;
  }
  
  public Color getColor() {
    return color;
  }
  
  @Override
  public String getCardName() {
    return "Numbered";
  }
  
  @Override
  public Boolean isValidCard(Card topCard) {
    if(topCard instanceof ActionCard card2){
      return getColor() == card2.getColor();
    }
    if(topCard instanceof WildCard card2){
      return getColor() == card2.getChosenColor();
    }
    NumberedCard card2 = (NumberedCard) topCard;
    return (getNumber() == card2.getNumber() || getColor() == card2.getColor());
  }
  
  @Override
  public int getCardScore() {
    return number;
  }
  
  @Override
  public String toString() {
    return color.toString().toLowerCase() + " " + getNumber() + " card.";
  }
}

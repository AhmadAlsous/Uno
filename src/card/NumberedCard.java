package card;

import abstractCard.ActionCard;
import abstractCard.Card;
import abstractCard.Color;
import abstractCard.WildCard;

public class NumberedCard implements Card {
  private int number;
  private Color color;
  
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
    if(topCard instanceof ActionCard){
      ActionCard card2 = (ActionCard) topCard;
      return getColor() == card2.getColor();
    }
    if(topCard instanceof WildCard){
      WildCard card2 = (WildCard) topCard;
      return getColor() == card2.getChosenColor();
    }
    NumberedCard card2 = (NumberedCard) topCard;
    return (getNumber() == card2.getNumber() || getColor() == card2.getColor());
  }
}

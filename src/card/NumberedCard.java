package card;

import abstractCard.Card;
import abstractCard.Color;

public class NumberedCard implements Card {
  private int number;
  private Color color;
  
  public NumberedCard(int number, Color color) {
    this.number = number;
    this.color = color;
  }
  public void print(){
    System.out.println(number+" "+color);
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
}

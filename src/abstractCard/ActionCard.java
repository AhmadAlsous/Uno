package abstractCard;

import card.NumberedCard;

public abstract class ActionCard implements Card{
  private Color color;
  
  protected ActionCard(Color color){
    this.color=color;
  }
  
  public Color getColor() {
    return color;
  }
  
  public abstract String getCardName();
  
  @Override
  public Boolean isValidCard(Card topCard) {
    if(topCard instanceof NumberedCard){
      NumberedCard card2 = (NumberedCard) topCard;
      return (getColor() == card2.getColor());
    }
    if(topCard instanceof ActionCard){
      ActionCard card2 = (ActionCard) topCard;
      return (getColor() == card2.getColor() || getCardName().equals(card2.getCardName()));
    }
    if(topCard instanceof WildCard){
      WildCard card2 = (WildCard) topCard;
      return getColor() == card2.getChosenColor();
    }
    return false;
  }
  
  public abstract void performAction();
}

package piles;

import abstractCard.Card;

import java.util.Stack;

public class DiscardPile {
  private static DiscardPile discardPileInstance;
  private Stack<Card> cardStack;
  private DiscardPile(){
    cardStack=new Stack<>();
    initializeDiscardPile();
  }
  
  public static DiscardPile getInstance() {
    if(discardPileInstance==null){
      return new DiscardPile();
    }
    return discardPileInstance;
  }
  
  public Card getTopCard(){
    return cardStack.peek();
  }
  
  private void initializeDiscardPile(){
    Card c = DrawPile.getInstance().drawCard();
    cardStack.push(c);
  }
}

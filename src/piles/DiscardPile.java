package piles;

import abstractCard.Card;
import card.NumberedCard;

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
      discardPileInstance = new DiscardPile();
    }
    return discardPileInstance;
  }
  
  public Card getTopCard(){
    return cardStack.peek();
  }
  
  private void initializeDiscardPile(){
    Card c = DrawPile.getInstance().drawCard();
    cardStack.push(c);
    if(!(c instanceof NumberedCard)){
      initializeDiscardPile();
    }
  }
  
  public void addCard(Card card){
    cardStack.push(card);
  }
}

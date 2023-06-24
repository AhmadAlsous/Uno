package piles;

import abstractCard.Card;
import card.CardFactory;
import abstractCard.Color;

import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class DrawPile {
  private static DrawPile drawPileInstance;
  private Stack<Card> cardStack;
  private DrawPile(){
    cardStack=new Stack<>();
    Deck deck=Deck.getInstance();
    initializeDrawPile(deck.getDeck());
    Collections.shuffle(cardStack);
  }
  
  public static DrawPile getInstance() {
    if(drawPileInstance==null){
      drawPileInstance = new DrawPile();
    }
    return drawPileInstance;
  }
  
  public Card drawCard(){
    return cardStack.pop();
  }
  
  private void initializeDrawPile(HashMap<String,Integer> deck){
    for (String key : deck.keySet()) {
      handleCardType(key,deck);
    }
  }
  
  private void handleCardType(String cardType, HashMap<String,Integer> deck){
    switch (cardType){
      case "Numbered":
        handleNumberedCards(deck.get("Zero"), deck.get("Numbered"));
        break;
      case "Skip":
      case "Reverse":
      case "DrawTwo":
        handleActionCards(cardType,deck.get(cardType));
        break;
      case "Wild":
      case "WildDrawFour":
        handleWildCards(cardType, deck.get(cardType));
        break;
      case "Zero":
        break;
      default:
        throw new IllegalArgumentException("Invalid card type: " + cardType);
    }
    
  }
  
  private void handleNumberedCards(int numZeroCards, int numOtherCards){
    Color[] colors= Color.values();
    for(int i=0;i<=9;i++){
      int count=i==0?numZeroCards:numOtherCards;
      for(int j=0;j<count;j++){
        for(Color color:colors){
          cardStack.push(CardFactory.createCard(i, color));
        }
      }
    }
  }
  
  private void handleActionCards(String cardType, int numCards){
    Color[] colors= Color.values();
    for(int i=0;i< numCards;i++){
      for(Color color:colors) {
        cardStack.push(CardFactory.createCard(cardType, color));
      }
    }
  }
  
  private void handleWildCards(String cardType, int numCards){
    int numColors= Color.values().length;
    for(int i=0;i< numCards;i++){
      for(int j=0;j<numColors;j++) {
        cardStack.push(CardFactory.createCard(cardType));
      }
    }
  }
  
}

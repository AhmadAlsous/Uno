package queue;

import abstractCard.Card;
import piles.DrawPile;

import java.util.ArrayList;
import java.util.List;

public class Player {
  private String name;
  private List<Card> cardList;
  
  public Player(String name){
    this.name=name;
    this.cardList=new ArrayList<>();
  }
  
  public void drawCard(){
    Card card = DrawPile.getInstance().drawCard();
    cardList.add(card);
  }
  
  public void drawCard(int num){
    for (int i=0;i<num;i++){
      drawCard();
    }
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public List<Card> getCardList() {
    return cardList;
  }
  
  public void setCardList(List<Card> cardList) {
    this.cardList = cardList;
  }
}

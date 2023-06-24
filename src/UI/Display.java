package UI;

import abstractCard.ActionCard;
import abstractCard.Card;
import abstractCard.Color;
import abstractCard.WildCard;
import card.NumberedCard;
import queue.Player;

import java.util.ArrayList;
import java.util.List;

import static utility.Utility.*;

public class Display {
  private Display(){
    throw new AssertionError("This class should not be instantiated.");
  }
  
  public static void printTopDiscardedCard(Card card){
    System.out.println("Discard Pile");
    StringBuilder c = new StringBuilder();
    Player player = new Player("simulate a card");
    List<Card> l = new ArrayList<>();
    l.add(card);
    player.setCardList(l);
    c.append(drawEmptyParts(player));
    c.append(drawNamePart(player));
    c.append(drawEmptyParts(player));
    System.out.println(c);
  }
  public static void printPlayerCards(Player player){
    System.out.println(player.getName()+"'s turn");
    StringBuilder c = new StringBuilder();
    c.append(drawEmptyParts(player));
    c.append(drawNamePart(player));
    c.append(drawEmptyParts(player));
    c.append(drawNumbers(player));
    System.out.println(c);
  }
  
  public static void printColorCards(){
    StringBuilder c = new StringBuilder();
    Player player = new Player("simulate a card");
    List<Card> l = new ArrayList<>();
    for(Color color: Color.values()){
      NumberedCard card = new NumberedCard(0,color);
      l.add(card);
    }
    player.setCardList(l);
    c.append(drawEmptyParts(player));
    c.append(drawEmptyParts(player));
    c.append(drawNumbers(player));
    System.out.println(c);
  }
  
  private static String drawEmptyParts(Player player){
    List<Card> cardList = player.getCardList();
    StringBuilder c = new StringBuilder();
    for(int i=0;i<2;i++){
      for (Card card : cardList) {
        String name = card.getCardName();
        String color;
        if(name!="Numbered") {
          if (card instanceof WildCard) {
            WildCard wildCard = (WildCard) card;
            color = wildCard.getChosenColor() == null ? WHITE : getColor(wildCard.getChosenColor());
          } else {
            color = getColor(((ActionCard) card).getColor());
          }
        } else {
          color = getColor(((NumberedCard) card).getColor());
        }
        String fill = color+space(cardWidth)+STOP+space(spaceBetweenCards);
        c.append(fill);
      }
      c.append("\n");
    }
    return c.toString();
  }
  
  private static String drawNamePart(Player player) {
    List<Card> cardList = player.getCardList();
    StringBuilder c = new StringBuilder();
    for (Card card : cardList) {
      String name = card.getCardName();
      String color;
      if(name!="Numbered"){
        if(card instanceof WildCard){
          WildCard wildCard = (WildCard) card;
          color = wildCard.getChosenColor()==null?WHITE:getColor(wildCard.getChosenColor());
        } else{
          color = getColor(((ActionCard) card).getColor());
        }
      }else{
        name=Integer.toString(((NumberedCard) card).getNumber());
        color = getColor(((NumberedCard) card).getColor());
      }
      int spaceCount = (cardWidth - name.length()) / 2;
      String fill = color + space(spaceCount) +BLACK_FONT+ name + space(cardWidth-(name.length()+spaceCount)) + STOP + space(spaceBetweenCards);
      c.append(fill);
    }
    c.append("\n");
    return c.toString();
  }
  
  private static String drawNumbers(Player player){
    List<Card> cardList = player.getCardList();
    StringBuilder c = new StringBuilder();
    c.append(space((cardWidth-1)/2));
    for(int i=1;i<=cardList.size();i++){
      c.append(i +space(cardWidth+1));
    }
    c.append("\n");
    return c.toString();
  }
  
}

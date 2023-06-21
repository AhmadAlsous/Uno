package UI;

import abstractCard.ActionCard;
import abstractCard.Card;
import abstractCard.WildCard;
import card.NumberedCard;
import queue.Player;

import java.util.List;

import static utility.Utility.*;

public class Display {
  private Display(){
    throw new AssertionError("This class should not be instantiated.");
  }
  public static void printPlayerCards(Player player){
    System.out.println(player.getName());
    StringBuilder c = new StringBuilder();
    c.append(drawEmptyParts(player));
    c.append(drawNamePart(player));
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
        if(name!="Numbered"){
          color = card instanceof WildCard ? WHITE : getColor(((ActionCard) card).getColor());
        }else{
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
        color = card instanceof WildCard ? WHITE : getColor(((ActionCard) card).getColor());
      }else{
        name=Integer.toString(((NumberedCard) card).getNumber());
        color = getColor(((NumberedCard) card).getColor());
      }
      int spaceCount = (cardWidth - name.length()) / 2;
      String fill = color + space(spaceCount) +BLACK_FONT+ name + space(spaceCount) + STOP + space(spaceBetweenCards);
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

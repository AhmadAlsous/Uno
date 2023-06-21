package card;

import abstractCard.Card;
import abstractCard.Color;

public class CardFactory {
  public static Card createCard(int number, Color color){
    return new NumberedCard(number,color);
  }
  public static Card createCard(String cardType, Color color){
    return switch (cardType) {
      case "Skip" -> new SkipCard(color);
      case "Reverse" -> new ReverseCard(color);
      case "DrawTwo" -> new DrawTwoCard(color);
      default -> throw new IllegalArgumentException("Invalid card type: " + cardType);
    };
  }
  public static Card createCard(String cardType){
    return switch (cardType) {
      case "Wild" -> new WildColorCard();
      case "WildDrawFour" -> new WildDrawFourCard();
      default -> throw new IllegalArgumentException("Invalid card type: " + cardType);
    };
  }
}

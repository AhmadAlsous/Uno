package abstractCard;

import card.NumberedCard;

public interface Card {
  String getCardName();
  
  Boolean isValidCard(Card card);
  
}

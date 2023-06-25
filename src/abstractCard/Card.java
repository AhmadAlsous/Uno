package abstractCard;

public interface Card {
  String getCardName();
  Boolean isValidCard(Card card);
  int getCardScore();
}

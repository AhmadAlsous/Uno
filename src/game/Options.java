package game;

import piles.DeckInfo;

public class Options {
  private DeckInfo deckOptions;
  private int numOfCardsPerPlayer;
  
  public Options(){
    DeckInfo defaultDeckOptions = new DeckInfo();
    setDeckOptions(defaultDeckOptions);
    setNumOfCardsPerPlayer(1);
  }
  
  public DeckInfo getDeckOptions() {
    return deckOptions;
  }
  
  public void setDeckOptions(DeckInfo deckOptions) {
    this.deckOptions = deckOptions;
  }
  
  public int getNumOfCardsPerPlayer() {
    return numOfCardsPerPlayer;
  }
  
  public void setNumOfCardsPerPlayer(int numOfCardsPerPlayer) {
    this.numOfCardsPerPlayer = numOfCardsPerPlayer;
  }
}

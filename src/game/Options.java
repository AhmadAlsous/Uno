package game;

import piles.DeckInfo;

public class Options {
  private DeckInfo deckOptions;
  private int numOfCardsPerPlayer;
  private boolean sayUno;
  
  public Options(){
    DeckInfo defaultDeckOptions = new DeckInfo();
    setDeckOptions(defaultDeckOptions);
    setNumOfCardsPerPlayer(4);
    setSayUno(false);
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
  
  public boolean sayUno() {
    return sayUno;
  }
  
  public void setSayUno(boolean sayUno) {
    this.sayUno = sayUno;
  }
}

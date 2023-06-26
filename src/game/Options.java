package game;

import piles.DeckInfo;

public class Options {
  private DeckInfo deckOptions;
  private int numOfCardsPerPlayer;
  private boolean sayUno;
  private int scoreToWin;
  private boolean drawOnlyOneCardIfCantPlay;
  
  public Options(){
    DeckInfo defaultDeckOptions = new DeckInfo();
    setDeckOptions(defaultDeckOptions);
    setNumOfCardsPerPlayer(4);
    setSayUno(true);
    setScoreToWin(500);
    setDrawOnlyOneCardIfCantPlay(true);
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
  
  public boolean hasToSayUno() {
    return sayUno;
  }
  
  public void setSayUno(boolean sayUno) {
    this.sayUno = sayUno;
  }
  
  public int getScoreToWin() {
    return scoreToWin;
  }
  
  public void setScoreToWin(int scoreToWin) {
    this.scoreToWin = scoreToWin;
  }
  
  public boolean getDrawOnlyOneCardIfCantPlay() {
    return drawOnlyOneCardIfCantPlay;
  }
  
  public void setDrawOnlyOneCardIfCantPlay(boolean drawOnlyOneCardIfCantPlay) {
    this.drawOnlyOneCardIfCantPlay = drawOnlyOneCardIfCantPlay;
  }
}

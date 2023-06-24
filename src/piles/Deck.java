package piles;

import game.Options;

import java.lang.reflect.Method;
import java.util.HashMap;

public class Deck {
  private static Deck deckInstance;
  private HashMap<String,Integer> deck;
  
  private Deck(){
    deck=new HashMap<>();
    DeckInfo defaultDeckOptions=new Options().getDeckOptions();
    initializeDeck(defaultDeckOptions);
  }
  
  public static Deck getInstance() {
    if(deckInstance==null)
      deckInstance = new Deck();
    return deckInstance;
  }
  
  public void setDeck(DeckInfo deckOptions) {
    initializeDeck(deckOptions);
  }
  
  private void initializeDeck(DeckInfo deckOptions){
    deck.clear();
    Class<?> deckOptionsClass=deckOptions.getClass();
    Method[] methods=deckOptionsClass.getDeclaredMethods();
    for(Method method:methods){
      if (method.getName().startsWith("get")){
        try {
          int result = (Integer) method.invoke(deckOptions);
          deck.put(method.getName().substring(3),result);
        }catch (Exception e){
          e.printStackTrace();
        }
      }
    }
  }
  
  public HashMap<String, Integer> getDeck() {
    return deck;
  }
}

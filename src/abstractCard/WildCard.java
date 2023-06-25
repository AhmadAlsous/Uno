package abstractCard;

import java.util.Scanner;

import static UI.Display.printColorCards;

public abstract class WildCard implements Card{
  private Color chosenColor;
  public abstract String getCardName();
  
  @Override
  public Boolean isValidCard(Card topCard) {
    return true;
  }
  
  @Override
  public int getCardScore() {
    return 50;
  }
  
  public void chooseColor(){
    System.out.println("Choose a color: ");
    printColorCards();
    while(true) {
      Scanner input = new Scanner(System.in);
      int chosenColor = input.nextInt();
      if(chosenColor > 0 && chosenColor < 5) {
        this.chosenColor = Color.values()[chosenColor - 1];
        break;
      }
      System.out.println("Choose a valid color: ");
    }
  }
  
  public Color getChosenColor(){
    return chosenColor;
  }
  
  @Override
  public String toString() {
    return getCardName() + " card.";
  }
  
  public abstract void performAction();
}

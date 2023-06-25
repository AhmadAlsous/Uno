package abstractCard;

import exceptions.InvalidInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

import static utility.Display.printColorCards;

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
    Boolean validInput = false;
    while(!validInput) {
      try {
        Scanner input = new Scanner(System.in);
        int chosenColor = input.nextInt();
        if (chosenColor <= 0 || chosenColor > Color.values().length) {
          throw new InvalidInputException("You chose an invalid card number.");
        }
        this.chosenColor = Color.values()[chosenColor - 1];
        validInput = true;
      } catch (InvalidInputException e) {
        System.out.println(e.getMessage() + " Choose a valid color: ");
      } catch (InputMismatchException e){
        System.out.println("You need to enter a number. Choose a valid color: ");
      }
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

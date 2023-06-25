package game;

import abstractCard.ActionCard;
import abstractCard.Card;
import abstractCard.WildCard;
import card.NumberedCard;
import exceptions.IllegalMoveException;
import exceptions.InvalidInputException;
import piles.DiscardPile;
import piles.DrawPile;
import queue.Player;
import queue.PlayersQueue;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static utility.Display.printPlayerCards;
import static utility.Display.printTopDiscardedCard;

public class GameRound {
  private DrawPile drawPile;
  private DiscardPile discardPile;
  private Queue<Player> playerQueue;
  private Options options;
  private Card chosenCard;
  private Player roundWinner;
  
  public GameRound(Queue<Player> queue, Options o){
    playerQueue = queue;
    options = o;
    drawPile = DrawPile.getInstance();
    discardPile = DiscardPile.getInstance();
  }
  public void playRound(){
    initializeRound();
    while (!isRoundOver()) {
      Player currentPlayer = playerQueue.peek();
      printPlayerCards(currentPlayer);
      playTurn(currentPlayer);
      System.out.println("-------------------------------------------------");
      try {
        TimeUnit.MILLISECONDS.sleep(650);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    endRound();
  }
  
  public void initializeRound(){
    int numOfPlayers = playerQueue.size();
    int numOfCardsPerPlayer = options.getNumOfCardsPerPlayer();
    for(int i=0;i<numOfPlayers;i++){
      Player player= playerQueue.remove();
      player.drawCard(numOfCardsPerPlayer);
      playerQueue.add(player);
    }
  }
  
  private Boolean isRoundOver(){
    for (Player player : playerQueue){
      if(player.getCardList().size() == 0){
        roundWinner = player;
        return true;
      }
    }
    return false;
  }
  
  private void playTurn(Player player){
    Card topDiscardedCard = discardPile.getTopCard();
    printTopDiscardedCard(topDiscardedCard);
    if(!hasPlayableCard(player)){
      System.out.println("You don't have a card to play, " + player.getName() + "! Drawing a card.");
      Card drawnCard = player.drawCard();
      System.out.println("You drew a " + drawnCard.toString());
      if (canBePlayed(drawnCard)){
        System.out.println("You can play this card.");
        playCard(player, player.getCardList().size()-1);
      } else {
        nextPlayer();
      }
    } else {
      int cardNumber = chooseCard(player);
      playCard(player, cardNumber);
    }
  }
  
  private void endRound(){
    System.out.println("Congrats " + roundWinner.getName() + "!!! You won this round 🎉");
    calculateScore();
    displayScores();
    for(Player player : playerQueue){
      player.clearCardList();
    }
    drawPile.initializeDrawPile();
    discardPile.initializeDiscardPile();
  }
  
  private void calculateScore(){
    for (Player player : playerQueue){
      for (Card card : player.getCardList()){
        roundWinner.incrementScore(card.getCardScore());
      }
    }
  }
  
  private void displayScores(){
    for (Player player : playerQueue) {
      System.out.println(player.getName() + "'s score: " + player.getScore());
    }
  }
  
  private int chooseCard(Player player){
    Boolean validMove = false;
    while(!validMove) {
      try {
        int cardNumber;
        System.out.println("Choose a card, " + player.getName());
        String sayUno = sayUno(player);
        if(player.getCardList().size() == 2 && sayUno.equalsIgnoreCase("Uno")) {
          System.out.println("Good job! You remembered to say Uno.");
          Scanner input = new Scanner(System.in);
          cardNumber = input.nextInt();
        }
        else {
          cardNumber = Integer.parseInt(sayUno);
        }
        if (cardNumber <= 0 || cardNumber > player.getCardList().size()){
          throw new InvalidInputException("You chose an invalid card number.");
        }
        cardNumber--;
        chosenCard = player.getCardList().get(cardNumber);
        if(!canBePlayed(chosenCard)) {
          throw new IllegalMoveException("You can't play this card.");
        }
        validMove = true;
        return cardNumber;
      } catch (InvalidInputException e) {
        System.out.println(e.getMessage() + " Choose a valid card number:");
      } catch (InputMismatchException e){
        System.out.println("You need to enter a number. Enter a valid number:");
      } catch (IllegalMoveException e){
        System.out.println(e.getMessage() + " Choose a valid card:");
      }
    }
    return 0;
  }
  
  private String sayUno(Player player){
    Scanner input = new Scanner(System.in);
    String uno = input.next();
    if (player.getCardList().size() == 2 && !uno.equalsIgnoreCase("Uno")){
      System.out.println("You forgot to say Uno! You have to draw two cards.");
      player.drawCard(2);
    }
    return uno;
  }
  
  private Boolean hasPlayableCard(Player player){
    List<Card> cardList = player.getCardList();
    for(Card card : cardList){
      if (canBePlayed(card)){
        return true;
      }
    }
  return false;
  }
  
  private Boolean canBePlayed(Card playerCard){
    Card topCard = discardPile.getTopCard();
    return playerCard.isValidCard(topCard);
  }
  
  private void playCard(Player player, int cardNumber){
    Card card = player.getCardList().get(cardNumber);
    player.playCard(cardNumber);
    if (card instanceof NumberedCard) {
        nextPlayer();
    } else if (card instanceof ActionCard actionCard){
      actionCard.performAction();
    } else if (card instanceof WildCard wildCard) {
      wildCard.performAction();
    }
  }
  
  public static void nextPlayer(){
    Queue<Player> playerQueue = PlayersQueue.getInstance().getQueue();
    Player currentPlayer = playerQueue.remove();
    playerQueue.add(currentPlayer);
  }
  
}

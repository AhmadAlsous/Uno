package game;

import abstractCard.ActionCard;
import abstractCard.Card;
import abstractCard.WildCard;
import card.NumberedCard;
import piles.DiscardPile;
import queue.Player;
import queue.PlayersQueue;

import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static UI.Display.printPlayerCards;
import static UI.Display.printTopDiscardedCard;

public class GameRound {
  private Card chosenCard;
  public void startGame(){
    PreGame preGame = new PreGame();
    preGame.initializeGame();
    while (true) {
      Queue<Player> playerQueue = PlayersQueue.getInstance().getQueue();
      Player currentPlayer = playerQueue.peek();
      printPlayerCards(currentPlayer);
      playTurn(currentPlayer);
      System.out.println("-------------------------------------");
      try {
        TimeUnit.MILLISECONDS.sleep(750);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  
  private void playTurn(Player player){
    Card topDiscardedCard = DiscardPile.getInstance().getTopCard();
    printTopDiscardedCard(topDiscardedCard);
    if(!hasPlayableCard(player, topDiscardedCard)){
      System.out.println("You don't have a card to play, "+player.getName()+"! Drawing a card.");
      Card drawnCard = player.drawCard();
      if (canBePlayed(drawnCard,topDiscardedCard)){
        playCard(player,drawnCard,player.getCardList().size()-1);
        System.out.println("You can play this card.");
      }
      Queue<Player> playerQueue = PlayersQueue.getInstance().getQueue();
      nextPlayer(playerQueue);
    } else {
      int cardNumber = chooseCard(player,topDiscardedCard);
      playCard(player,chosenCard,cardNumber);
    }
  }
  
  private int chooseCard(Player player, Card topCard){
    while(true) {
      System.out.println("Choose a card, " + player.getName());
      Scanner input = new Scanner(System.in);
      int cardNumber = input.nextInt();
      cardNumber--;
      chosenCard = player.getCardList().get(cardNumber);
      if (canBePlayed(chosenCard, topCard)) {
        return cardNumber;
      }
      System.out.println("You can't play this card.");
    }
  }
  
  private Boolean hasPlayableCard(Player player, Card topCard){
    List<Card> cardList = player.getCardList();
    for(Card card:cardList){
      if (canBePlayed(card, topCard)){
        return true;
      }
    }
  return false;
  }
  
  private Boolean canBePlayed(Card playerCard, Card topCard){
    return playerCard.isValidCard(topCard);
  }
  
  private void playCard(Player player, Card card, int cardNumber){
    player.playCard(cardNumber);
    if (card instanceof NumberedCard) {
        Queue<Player> playerQueue = PlayersQueue.getInstance().getQueue();
        nextPlayer(playerQueue);
    } else if (card instanceof ActionCard){
      ActionCard actionCard = (ActionCard) card;
      actionCard.performAction();
    } else if (card instanceof WildCard) {
      WildCard wildCard = (WildCard) card;
      wildCard.performAction();
    }
  }
  
  public static void nextPlayer(Queue<Player> playerQueue){
    Player currentPlayer = playerQueue.remove();
    playerQueue.add(currentPlayer);
  }
  
}

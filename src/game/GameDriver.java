package game;

import piles.Deck;
import piles.DrawPile;
import queue.PlayersQueue;

public class GameDriver {
  public static void main(String[] args){
    Game game=new UnoGame();
    game.play();
//    PreGame g=new PreGame();
//    g.initializeGame();
    GameRound r = new GameRound();
    r.startGame();
  }
}


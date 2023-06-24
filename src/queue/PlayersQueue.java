package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PlayersQueue {
  private static PlayersQueue queueInstance;
  private Queue<Player> queue;
  private PlayersQueue(){
    queue=new LinkedList<>();
    initializeQueue();
  }
  public static PlayersQueue getInstance(){
    if(queueInstance==null)
      queueInstance = new PlayersQueue();
    return queueInstance;
  }
  
  private void initializeQueue(){
    System.out.println("Welcome to UNO!");
    try {
      System.out.println("Enter your names separated by spaces:");
      Scanner input=new Scanner(System.in);
      String players=input.nextLine();
      String[] playersArray = players.split(" ");
      if(playersArray.length<2){
        throw new IllegalArgumentException();
      }
      for (String player : playersArray) {
        Player p = new Player(player);
        queue.add(p);
      }
    }catch(IllegalArgumentException e){
      System.out.println("You need at least 2 players to play UNO. Try again.");
      initializeQueue();
    }
  }
  
  public Queue getQueue(){
    return queue;
  }
}

import java.util.Scanner;
import model.*;
import util.Position;

public class Game {

  private Player player;
  private XMan[] npcs;

  public void printGameBoard() {
    StringBuilder gb = new StringBuilder();
    for (int y = Position.minY; y <= Position.maxY; y++) {
      for (int x = Position.minX; x <= Position.maxX; x++) {
        boolean empty = true;
        if (x == player.getPosition().getX() &&
            y == player.getPosition().getY()) {
          gb.append("M");
          empty = false;
        } 
        
        for (XMan npc : npcs) {
          if (x == npc.getPosition().getX() &&
              y == npc.getPosition().getY()) {
            gb.append("W");
            empty = false;
          } 
        }
        if (empty) {
          gb.append(".");
        }
        gb.append('\t');
      }
      gb.append("\n");
    }
    System.out.println(gb.toString());
  }

  public void setup() {
    Position.minX = -5;
    Position.minY = -5;
    Position.maxX = 5;
    Position.maxY = 5;

    // setup npcs
    npcs = new XMan[] { new Wolverine(),  new Wolverine()};
    for (XMan npc : npcs) {
      npc.setPosition(Position.randomPosition());
    }
    
    Player magneto = new Player();
    magneto.setHp(12);
    magneto.setStrength(7);
    Position p = new Position(0, 0);
    magneto.setPosition(p);
    setPlayer(magneto);
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public void start() {

    String command = "";
    String commandString = "";
    Scanner input = new Scanner(System.in);
    do {
      printGameBoard();
      System.out.print(">> ");
      commandString = input.nextLine();
      String[] tokens = commandString.split(" ");
      if (tokens.length > 0) {
        command = tokens[0];
      }
      switch (command.toUpperCase()) {
        // move command
        // move n
        case "MOVE":
          if (tokens.length >= 2)
            switch (tokens[1].toUpperCase()) {
              case "N":
                player.moveN();
                break;
              case "S":
                player.moveS();
                break;
              case "E":
                player.moveE();
                break;
              case "W":
                player.moveW();
                break;
            }
          break;
        case "ATTACK":
          if (tokens.length >= 3){
            Position whereAttack = new Position(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
            player.attack(npcs, whereAttack);
          }
           break;
      }
      //updateNPCS();
      // for (String t: tokens) {
      // System.out.println(t);
      // }

    } while (!command.equals("quit"));

  }
  private void updateNPCS() {
    for (XMan npc : npcs) {
      npc.setPosition(Position.randomPosition());
    }
  }
}
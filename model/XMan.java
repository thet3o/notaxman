package model;
import util.Position;
import util.Utils;

public class XMan {
  private int hp;
  private String name;
  private int strength;
  private int speed = 1;
  private Position position;
  private double range = 2.0;

  // consturttore vuoto (di default)
  public XMan() {
    //System.out.println("XMan constructor");
    setHp(100);
  }
  public XMan(String newName) {
    name = newName;
  }
  public void setSpeed(int newSpeed) {
    speed = newSpeed;
  }
  public int getSpeed() {
    return speed;
  }
  public void setPosition(Position newPosition) {
    position = newPosition;
  }
  public Position getPosition() {
    return position;
  }
  
  // setter
  public void setStrength(int s) {
    strength = s;
  }
  // getter
  public int getStrength() {
    return strength;
  }
  // setter
  public void setHp(int h) {
    hp = h;
    if (hp <= 10 && hp > 0) {
      System.out.println(name + ": Ahhrg, dying...");
    }else if(hp <= 0){
      System.out.println(name + " dead");
    }else if (h <= 0) {
      System.out.println("Player DEAD");
      System.exit(0);
    }
    System.out.println(hp);
  }

  // getter
  public int getHp() {
    return hp;
  }  
  // setter
  public void setName(String n) {
    name = n;
  }
  // getter
  public String getName() {
    return name;
  }

  public void setRange(double range) {
      this.range = range;
  }
  
  public double getRange() {
      return range;
  }

  void attackEnemy(XMan other) {
    other.setHp(other.getHp() - getStrength());
  }

  //NPCs
  public void counterattack(XMan player){
    if(Utils.range(getPosition(), player.getPosition()) <= getRange()){
      if(position.getX() == player.getPosition().getX() && position.getY() == player.getPosition().getY()){
        System.out.println("Player FOUND");
        attackEnemy(player);
        return;
      }else{
        System.out.println("404 Player not found!");
      }
    }else{
      System.out.println("Out of range!");
    }
  }
  
  void catchPhrase() {
    System.out.println("I'm an X-man and my name is " + name);
  }
  void catchPhrase(boolean winning) {
    if (winning) {
      System.out.println(name + ": Evviva!");
    } else {
      System.out.println(name + ": Accidenti!");
    }
  }
  @Override
  public String toString() {
    String status = "XMan: " + name + "\n";
    status += "HP: " + hp + "\n";
    status += "Strength: " + strength + "\n";
    status += "Position: " + position + "\n";
    return status;
  }
  public void moveN() {
    position.setY(position.getY() - speed);
    System.out.println(position.getX() + " " + position.getY());
  }
  public void moveS() {
    position.setY(position.getY() + speed);
  }
  public void moveE() {
    position.setX(position.getX() + speed);
    System.out.println(position.getX() + " " + position.getY());
  }
  public void moveW() {
    position.setX(position.getX() - speed);
  }
  
}
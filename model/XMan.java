package model;
import util.Position;

public class XMan {
  private int hp;
  private String name;
  private int strength;
  private int speed = 1;
  private Position position;

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
    if (hp <= 10) {
      System.out.println(name + ": Ahhrg, dying...");
    }
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
  
  void attack(XMan other) {
    //other.hp -= strength;
    // other.hp = other.hp - strength;
    other.setHp(other.getHp() - getStrength());
  }

  // Attacco XMan ravvicinato
  public void attack(XMan[] enemies){
    for(int i = 0; i < enemies.length; i++){
      Position enemyPosition = enemies[i].getPosition(); 
      if(position.getX() == enemyPosition.getX() && position.getY() == enemyPosition.getY()){
        System.out.println(enemies[i].getHp());
        attack(enemies[i]);
        System.out.println(enemies[i].getHp());
      }
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
  }
  public void moveS() {
    position.setY(position.getY() + speed);
  }
  public void moveE() {
    position.setX(position.getX() + speed);
  }
  public void moveW() {
    position.setX(position.getX() - speed);
  }
  
}
package model;

public class Wolverine extends XMan {

  private int rage;

  public void setRage(int newRage) {
    rage = newRage;
  }

  public int getRage() {
    return rage;
  }

  public void heal() {
    if (getHp() < 10) {
      setHp(getHp() + 5);
    }
  }
  @Override
  void attack(XMan other) {
    // other.hp -= strength;
    // other.hp = other.hp - strength;
    other.setHp(other.getHp() - getStrength() - getRage());
  }
}
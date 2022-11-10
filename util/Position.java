package util;
import java.util.Random;


public class Position {
  private int x;
  private int y;
  public static int minX;
  public static int minY;
  public static int maxX;
  public static int maxY;
  private static Random ramdomizer = new Random();

  public void setX(int newX) {
    if (newX < minX) {
      System.out.println("West border hit");
      newX = minX;
    }
    else if (newX > maxX) {
      System.out.println("East border hit");
      newX = maxX;
    }
    x = newX;
  }
    public void setY(int newY) {
    if (newY < minY) {
      System.out.println("South border hit");
      newY = minY;
    }
    else if (newY > maxY) {
      System.out.println("North border hit");
      newY = maxY;
    }
    y = newY;
  }
  public int getX() {
    return x;
  }
  public int getY() {
    return y;
  }
  public Position() {
    //System.out.println("Position()");
    x = y = 0;
  }
  public Position(int init_x) {
    //System.out.println("Position(x)");
    x = init_x;
    y = 0;
  }
  public Position(int init_x,int init_y) {
    //System.out.println("Position(x,y)");
    x = init_x;
    y = init_y;
  }
  @Override
  public String toString() {
    return "(" + x + "," + y + ")";
  }
  // factory pattern
  public static Position randomPosition() {
    int rx = ramdomizer.nextInt(maxX - minX + 1) + minX;
    int ry = ramdomizer.nextInt(maxY - minY + 1) + minY;
    return new Position(rx,ry);
  }
}
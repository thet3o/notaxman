package util;

public class Utils { 

    public static double range(Position entity1, Position entity2){
        return Math.sqrt((Math.pow((entity2.getX()-entity1.getX()), 2))+(Math.pow((entity2.getY()-entity1.getY()), 2)));
    }
    
}

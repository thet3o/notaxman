package model;

import util.*;

public class Player extends XMan{

    public Player(){
        super("Player");
    }

    public void attack(XMan[] entities,Position whereAttack){
        System.out.println(Utils.range(getPosition(), whereAttack));
        if(Utils.range(getPosition(), whereAttack) <= getRange()){
          for(int i = 0; i < entities.length; i++){
            if(whereAttack.getX() == entities[i].getPosition().getX() && whereAttack.getY() == entities[i].getPosition().getY()){
                System.out.println("ENEMY FOUND");
                if(entities[i].getHp() > 0){
                    entities[i].setHp(entities[i].getHp() - getStrength());
                }else{
                    System.out.println("Already dead!");
                }
                return;
            }
          }
          System.out.println("404 Enemy not found!");
        }else{
            System.out.println("Out of range!");
        }
      }
    
}

package model;

import java.util.List;

import util.*;

public class Player extends XMan{

    public Player(){
        super("Player");
    }

    public void attack(List<XMan> entities,Position whereAttack){
        System.out.println(Utils.range(getPosition(), whereAttack));
        if(Utils.range(getPosition(), whereAttack) <= getRange()){
          for(int i = 0; i < entities.size(); i++){
            if(whereAttack.getX() == entities.get(i).getPosition().getX() && whereAttack.getY() == entities.get(i).getPosition().getY()){
                System.out.println("ENEMY FOUND");
                if(entities.get(i).getHp() > 0){
                    entities.get(i).setHp(entities.get(i).getHp() - getStrength());
                    if(entities.get(i).getHp() <= 0){ entities.remove(i);} // Rimuovi nemico dalla mappa
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

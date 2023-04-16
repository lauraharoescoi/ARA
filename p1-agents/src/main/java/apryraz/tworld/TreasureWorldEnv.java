

package apryraz.tworld;

import java.util.ArrayList;





public class TreasureWorldEnv {
/**
  X,Y position of Treasure and world dimension

**/
  int TreasureX, TreasureY, WorldDim;


/**
*  Class constructor
*
* @param dim dimension of the world
* @param tx  X position of Treasure
* @param ty  Y position of Treasure
* @param piratesFile File with list of pirates locations
**/
  public TreasureWorldEnv( int dim, int tx, int ty  ) {

    TreasureX = tx;
    TreasureY = ty;
    WorldDim = dim;
  }




/**
* Process a message received by the TFinder agent,
* by returning an appropriate answer
* This version only process answers to moveto and detectsat messages
*
* @param   msg message sent by the Agent
*
* @return  a msg with the answer to return to the agent
**/
   public AMessage acceptMessage( AMessage msg ) {
       AMessage ans = new AMessage(Action.VOID, "", "", "" );
       msg.showMessage();

       int x = Integer.parseInt( msg.getComp(0) );
       int y = Integer.parseInt( msg.getComp(1) );

       if ( msg.getType().equals(Action.MOVETO) ) {
           if (withinLimits(x,y)) {
               ans = new AMessage(Action.MOVEDTO,msg.getComp(0),msg.getComp(1),  ""  );
           } else {
               ans = new AMessage(Action.NOTMOVETO, msg.getComp(0), msg.getComp(1), "");
           }
       } else if ( msg.getType().equals(Action.DETECTSAT) ) {
           if (x == TreasureX && y == TreasureY || x + 1 == TreasureX && y == TreasureY || x == TreasureX && y + 1 == TreasureY || x - 1 == TreasureX && y == TreasureY || x == TreasureX && y - 1 == TreasureY) {
               ans = new AMessage(Action.DETECTED, msg.getComp(0),msg.getComp(1), "1");
           } else if (x + 1 == TreasureX && y + 1 == TreasureY || x + 1 == TreasureX && y - 1 == TreasureY || x - 1 == TreasureX && y - 1 == TreasureY || x - 1 == TreasureX && y + 1 == TreasureY) {
               ans = new AMessage(Action.DETECTED, msg.getComp(0),msg.getComp(1), "2");
           } else {
               ans = new AMessage(Action.DETECTED, msg.getComp(0),msg.getComp(1), "3");
           }
       }
       return ans;

   }

 
 /**
  * Check if position x,y is within the limits of the
  * WorldDim x WorldDim   world
  *
  * @param x  x coordinate of agent position
  * @param y  y coordinate of agent position
  *
  * @return true if (x,y) is within the limits of the world
  **/
   public boolean withinLimits( int x, int y ) {

    return ( x >= 1 && x <= WorldDim && y >= 1 && y <= WorldDim);
  }
 
}

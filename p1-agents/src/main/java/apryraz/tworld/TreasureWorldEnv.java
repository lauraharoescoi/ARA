

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
       if ( msg.getType().equals(Action.MOVETO) ) {
           int nx = Integer.parseInt( msg.getComp(0) );
           int ny = Integer.parseInt( msg.getComp(1) );
           
           if (withinLimits(nx,ny))
           {                          
             ans = new AMessage(Action.MOVEDTO,msg.getComp(0),msg.getComp(1),  ""  );
           }
           else
             ans = new AMessage(Action.NOTMOVETO,msg.getComp(0),msg.getComp(1), "" );

       } else {
             // YOU MUST ANSWER ALSO TO THE OTHER MESSAGE TYPE:
             //   ( "detectsat", "x" , "y", "" )             
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

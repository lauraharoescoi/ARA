package apryraz.tworld;

/**
*  Class for representing messages exchanged between agents and the
*  World interface object
**/
public class AMessage {
  /*
  *  Array of String objects, that represent the different fields of each message
  *  So far, we assume a fixed pattern, with always three fields in any message:
  *  field0:  message type: moveto, movedto, notmovedto, detects at, yes/no ...
  *  field1:  first parameter of message
  *  field2:  second parameter of message
  */
    Action msgtype;
    String[] msg ;

/**
*  Class constructor
*
*  @param msgtype  message type
*  @param par1:  first parameter of message
*  @param par2:  second parameter of message
   @param par3:  third parameter of message
**/
 public  AMessage( Action msgtype, String par1, String par2, String par3 ) {
   msg = new String[3];
   this.msgtype = msgtype;

   msg[0] = par1;
   msg[1] = par2;
   msg[2] = par3;
 }

 /**
 *  Show message on screen
 **/
 public void showMessage() {
     System.out.println( "MESSAGE: "+this.msgtype.name()+ " "+ msg[0] + " "+ msg[1]+ " "+msg[2] );
 }

 /**
 *  get some part of the message
 *
 * @param c index of the component to return
 *
 * @return the String corresponding to the component requested
 **/
 public String getComp(int c) {
   return msg[c];
 }

 public Action getType() {
     return this.msgtype;
 }

}

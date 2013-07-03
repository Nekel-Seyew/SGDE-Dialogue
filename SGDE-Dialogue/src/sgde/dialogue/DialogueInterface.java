/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgde.dialogue;

import java.util.ArrayList;

/**
 *
 * @author kdsweenx
 */
public class DialogueInterface {
    DialogueMap DM;
    DialogueOption DO;
    boolean done;
    
    public DialogueInterface(String diagFile){
        try{
            DM=new DialogueMap(diagFile);
            DO=DM.getNext(null, null);
            done=false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String getCurrentResponse(){
        return DO.text;
    }
    
    public ArrayList<String> getCurrentOptions(){
        return new ArrayList<String>(DO.nodez.keySet());
    }
    
    public void PlayerChoice(String dgChoice){
        try{
            DO=DM.getNext(dgChoice, DO);
        }catch(DoneWithDialogueException dwde){
            //Oh, we are done....
            //Well, this is embarassing.....
            done=true;
        }
    }
    
    public boolean isDone(){
        return done;
    }
}


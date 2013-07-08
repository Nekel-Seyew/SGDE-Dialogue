/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgde.dialogue;

import java.util.ArrayList;

/**
 * This class represents a possible instance of communication between a player and an NPC.
 * Every time a player initiates communication with an NPC, this class is supposed 
 * to mediate the instance, based upon a script provided by the programmer.
 * @author Kyle Sweeney
 */
public class DialogueInterface {
    /**
     * The Map which stores all of the response collections.
     */
    DialogueMap DM;
    /**
     * The current response collection.
     */
    DialogueOption DO;
    /**
     * Whether or not the interaction has run its course.
     */
    boolean done;
    /**
     * A constructor which takes in the file that holds the script for the dialogue interaction.
     * @param diagFile the scripted dialogue.
     */
    public DialogueInterface(String diagFile){
        try{
            DM=new DialogueMap(diagFile);
            DO=DM.getNext(null, null);
            done=false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * Returns the current prompt/reponse the NPC has given to the player.
     * @return the prompt from the NPC.
     */
    public String getCurrentResponse(){
        return DO.text;
    }
    /**
     * For every NPC prompt, there is a collection of possible reponses the player can give: this gives them.
     * @return an array of possible reponses to the NPC.
     */
    public ArrayList<String> getCurrentOptions(){
        return new ArrayList<String>(DO.nodez.keySet());
    }
    /**
     * This advances the progression of the dialogue. After retrieving which option
     * the player whishes to use, pass in that string to this function.
     * @param dgChoice the exact text given by the "getCurrentOptions" method.
     */
    public void PlayerChoice(String dgChoice){
        try{
            DO=DM.getNext(dgChoice, DO);
        }catch(DoneWithDialogueException dwde){
            //Oh, we are done....
            //Well, this is embarassing.....
            done=true;
        }
    }
    /**
     * This should be polled constantly to see if the dialogue has run its course.
     * @return whether or not we have reached the scripted end.
     */
    public boolean isDone(){
        return done;
    }
}


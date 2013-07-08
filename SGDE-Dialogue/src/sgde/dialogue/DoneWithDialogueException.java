/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgde.dialogue;

/**
 * An Internal class which the user and client code should never see; 
 * it tells the framework when the dialogue has come to a completion.
 * @author kdsweenx
 */
public class DoneWithDialogueException extends Exception{
    public DoneWithDialogueException(String text){
        super("Dialogue Has reached Conclusion...... also: "+text);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgde.dialogue;

/**
 *
 * @author kdsweenx
 */
public class DoneWithDialogueException extends Exception{
    public DoneWithDialogueException(String text){
        super("Dialogue Has reached Conclusion...... also: "+text);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgde.dialogue;

/**
 *
 * @author kdsweenx
 */
class IncorrectFormatException extends Exception {
    public IncorrectFormatException(String line, int section){
        super("Error in section: "+section+" on line:\n\t \""+line+"\"\n");
    }
}

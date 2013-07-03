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
    public IncorrectFormatException(String line){
        super("Error on line: \""+line+"\"");
    }
}

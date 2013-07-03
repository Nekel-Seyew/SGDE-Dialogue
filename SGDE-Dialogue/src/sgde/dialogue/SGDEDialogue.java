/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgde.dialogue;

import java.io.FileNotFoundException;

/**
 *
 * @author kdsweenx
 */
public class SGDEDialogue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IncorrectFormatException {
        DialogueMap dm=new DialogueMap("example.diag");
        
        System.out.println(dm.map);
        
    }
}

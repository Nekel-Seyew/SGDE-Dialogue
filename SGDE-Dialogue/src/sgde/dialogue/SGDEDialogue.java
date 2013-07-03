/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgde.dialogue;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kdsweenx
 */
public class SGDEDialogue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IncorrectFormatException {
        //DialogueMap dm=new DialogueMap("example.diag");
        
        //System.out.println(dm.map);
        
        DialogueInterface DI=new DialogueInterface("example.diag");
        Scanner reader = new Scanner(System.in);
        while(!DI.isDone()){
            System.out.println(DI.getCurrentResponse());
            ArrayList<String> options=DI.getCurrentOptions();
            for(int i=0; i<options.size(); ++i){
                System.out.println("->"+options.get(i)+": "+i);
            }
            System.out.print(">>");
            DI.PlayerChoice(options.get(reader.nextInt()));
        }
        
    }
}

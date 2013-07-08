/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgde.dialogue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Map of responses and prompts of the scripted dialogue. Primarily an internal class.
 * @author kdsweenx
 */
public class DialogueMap {
    public static int END=Integer.MAX_VALUE;
    
    ArrayList<DialogueOption> map;
    
    /**
     * Primary constructor for the map of possible choices (plus prompt).
     * @param text the script for the entire conversation.
     * @throws FileNotFoundException is thrown if the passed in file wasn't found.
     * @throws IncorrectFormatException is thrown if the given script is not properly formatted.
     */
    public DialogueMap(String text) throws FileNotFoundException, IncorrectFormatException{
        makeMap(text);
    }//yep, all good now.
    
    /**
     * Parses the diag file. Note: While technically public, it should never be called outside of this class. 
     * Public only for possible extension of diag files.
     * @param text
     * @throws FileNotFoundException
     * @throws IncorrectFormatException 
     */
    public void makeMap(String text)throws FileNotFoundException, IncorrectFormatException{
        Scanner reader=new Scanner(new File(text));
        map=new ArrayList<DialogueOption>();
        DialogueOption DO=null;
        while(reader.hasNext()){
            String line=reader.nextLine();
            try {
                if (line.startsWith("$")) {
                    DO = new DialogueOption(grabNum(line));
                } else if (line.contains("@")) {
                    DO.addText(getMText(line));
                } else if (line.contains("#")) {
                    DO.addPC(getGoTo(line), getPCString(line));
                } else if (line.contains("}") && line.length() < 3) {
                    map.add(DO.place, DO);
                }

            } catch (StringIndexOutOfBoundsException e) {
                throw new IncorrectFormatException(line, DO.place);
            }
        }//Done Parsing
    }
    /**
     * Returns the instance of the next collection of responses.
     * @param next the string which the player selected.
     * @param DO the current instance being held of options.
     * @return the next instance of options, (with prompt)
     * @throws DoneWithDialogueException An internal exception to tell the framework the 
     * dialogue has run it's course.
     */
    public DialogueOption getNext(String next, DialogueOption DO) throws DoneWithDialogueException{
        if(next==null || DO==null){
            return map.get(0);
        }
        int get=DO.getNextChoice(next);
        if(get==Integer.MAX_VALUE){
            throw new DoneWithDialogueException("");
        }
        return map.get(DO.getNextChoice(next));
    }
    
    private int grabNum(String n){
        int s=n.indexOf("$");
        if(n.contains("START")){
            return 0;
        }
        return Integer.parseInt(n.substring(s+1,n.indexOf("=")));
    }
    
    private String getMText(String ln){
        return ln.substring(ln.indexOf("=")+1,ln.indexOf(";"));
    }
    
    private int getGoTo(String ln){
        int i=ln.indexOf(">")+1;
        String line=ln.substring(i,ln.lastIndexOf(";"));
        if(line.contains("END")){
            return END;
        }
        return Integer.parseInt(line);
    }
    
    private String getPCString(String ln){
        return ln.substring(ln.indexOf("{")+1,ln.indexOf(";"));
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgde.dialogue;

import java.util.HashMap;

/**
 * This class represents an individual collection of possible responses to a prompt. 
 * This also includes the original prompt which produced these responses. This class
 * is generally only for use by the framework. For proper usage of this project,
 * please use the <class>DialogueInterface</class> class.
 * @author kdsweenx
 */
public class DialogueOption {
    String text;
    int place;
    HashMap<String, Speech> nodez;
    
    /**
     * The Constructor for making a DialogueOption.
     * @param place where in the map this instances resides
     */
    public DialogueOption(int place){
        this.place=place;
        //nodes=new ArrayList<Speech>();
        nodez=new HashMap<String, Speech>();
    }
    
    /**
     * Adds the NPC prompt text to the instance.
     * @param txt the prompt/response of the NPC which triggers these options.
     */
    public void addText(String txt){
        this.text=new String(txt);
    }
    /**
     * Adds a player response to the prompt, and which node/collections of options to go to next.
     * @param go the index of where to go to next.
     * @param txt the text of the response.
     * 
     */
    public void addPC(int go, String txt){
        //nodes.add(new dg(go,txt));
        nodez.put(txt, new dg(go,txt));
    }
    /**
     * Returns the index of the next place go to.
     * @param key the player text.
     * @return the index of the next location.
     */
    public int getNextChoice(String key){
        return nodez.get(key).goTo();
    }
    
    @Override
    public String toString(){
        String s="Place: "+this.place;
        s+=" Nodes:"+nodez.toString();
        return s;
    }
    
 private class dg implements Speech{
     String text;
     int goTo;
     
     public dg(int goTo, String txt){
         this.text=new String(txt);
         this.goTo=goTo;
     }
     
     @Override
     public int goTo(){
         return goTo;
     }
     
     @Override
     public String getText(){
         return text;
     }
     
     @Override
     public String toString(){
         String s="{PC: Text:["+text+"], goto: "+goTo+"}";
         return s;
     }
     
 } 
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgde.dialogue;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kdsweenx
 */
public class DialogueOption {
    String text;
    int place;
    HashMap<String, Speech> nodez;
    
    public DialogueOption(int place){
        this.place=place;
        //nodes=new ArrayList<Speech>();
        nodez=new HashMap<String, Speech>();
    }
    
    public void addText(String txt){
        this.text=new String(txt);
    }
    
    public void addPC(int go, String txt){
        //nodes.add(new dg(go,txt));
        nodez.put(txt, new dg(go,txt));
    }
    
    public int getNextChoice(String key){
        return nodez.get(key).goTo();
    }
    
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
     
     public int goTo(){
         return goTo;
     }
     
     public String getText(){
         return text;
     }
     
     public String toString(){
         String s="{PC: Text:["+text+"], goto: "+goTo+"}";
         return s;
     }
     
 } 
    
}

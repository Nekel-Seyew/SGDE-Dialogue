/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgde.dialogue;

import java.util.ArrayList;

/**
 *
 * @author kdsweenx
 */
public class DialogueOption {
    String text;
    int place;
    ArrayList<Speech> nodes;
    
    public DialogueOption(int place){
        this.place=place;
        nodes=new ArrayList<Speech>();
    }
    
    public void addText(String txt){
        this.text=new String(txt);
    }
    
    public void addPC(int go, String txt){
        nodes.add(new dg(go,txt));
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
     
 } 
    
}

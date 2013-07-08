/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgde.dialogue;

/**
 * An Internal interface for representing a single option in the collection of options
 * after receiving a prompt.
 * @author Kyle Sweeney
 */
public interface Speech {
    /**
     * However an implementing class actually stores the data, 
     * the response the player will give the NPC must be given after calling this method.
     * @return the response of the player.
     */
    public String getText();
    /**
     * Due to the nature of scripting responses and storing them, a response can go anywhere.
     * This method must give client code where in the map/array of response collections to go next.
     * @return the index of the array/map where the proper NPC response and subsequent player responses reside.
     */
    public int goTo();
}

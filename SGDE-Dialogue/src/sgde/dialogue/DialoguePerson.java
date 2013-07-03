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
public interface DialoguePerson {
    public void create(String filePath) throws FileNotFoundException;
    public void start();
}

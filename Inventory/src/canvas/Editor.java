/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canvas;

import static extra.Globals.canvasFrame;
import javax.swing.JComboBox;

/**
 *
 * @author Jake
 */
public class Editor {
    JComboBox colors = new JComboBox();
    public Editor(){
        setEditorOptions();
    }

    private void setEditorOptions() {
        colors.setBounds(canvasFrame.getWidth() - 100, canvasFrame.getHeight() - 500, 50, 25);
    }
    public JComboBox getColors(){
        return colors;
    }
}

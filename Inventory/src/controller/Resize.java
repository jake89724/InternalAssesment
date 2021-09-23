
package controller;

import java.awt.Rectangle;
import visual.Canvas;
import static visual.Canvas.indexOfSelected;

/**
 *
 * @author j.head
 */
public class Resize {
    public Resize(){
        
    }
    
    public void reSizeLeft(Rectangle mousePos){
       // Canvas.squares.get(indexOfSelected);
       
        System.out.println("here");
        Canvas.squares.get(indexOfSelected).setSize((int)mousePos.getX() - Canvas.points[0].x + (int)Canvas.squares.get(indexOfSelected).getWidth(),
               (int)Canvas.squares.get(indexOfSelected).getHeight());
        
        //set location of point to the mosue 
        // Canvas.squares.get(indexOfSelected).setLocation
        
    }
}

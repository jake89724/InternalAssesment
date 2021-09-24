
package controller;

import java.awt.Cursor;
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
    //make better this class garbage
    public void reSizeLeft(Rectangle mousePos){
       // Canvas.squares.get(indexOfSelected);   
         Canvas.squares.get(
                 indexOfSelected).setSize((int)mousePos.getX() - Canvas.points[0].x
                         + (int)Canvas.squares.get(indexOfSelected).getWidth(),
               (int)Canvas.squares.get(indexOfSelected).getHeight());  
         
        
        //set location of point to the mosue 
//         Canvas.squares.get(indexOfSelected).setLocation((int)mousePos.getX()
//                 - Canvas.points[0].x + (int)mousePos.getX(),
//        (int) Canvas.squares.get(indexOfSelected).getY());
        
    }
}

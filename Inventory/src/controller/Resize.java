
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
        //point.x - mouse.x + width = width of square
         Canvas.squares.get(
                  indexOfSelected).setSize(Canvas.points[0].x
                 - (int)mousePos.getX()
                 + (int)Canvas.squares.get(indexOfSelected).getWidth(),
                 (int)Canvas.squares.get(indexOfSelected).getHeight()
         );  
       //set location of point to the mosue 
         Canvas.squares.get(indexOfSelected).setLocation(
                (int)mousePos.getX() + 10,
                (int) Canvas.squares.get(indexOfSelected).getY()
         );
    }
    public void reSizeRight(Rectangle mousePos){
        //point.x - mouse.x + width = width of square
         Canvas.squares.get(
                  indexOfSelected).setSize(
                 (int)mousePos.getX() - Canvas.points[1].x
                 + (int)Canvas.squares.get(indexOfSelected).getWidth(),
                 (int)Canvas.squares.get(indexOfSelected).getHeight()
         );  
       //set location of point to the mosue 
       Rectangle temp = new Rectangle(Canvas.squares.get(indexOfSelected));
         Canvas.squares.get(indexOfSelected).setLocation(
                (int)mousePos.getX() - (int)temp.getWidth(),
                (int) Canvas.squares.get(indexOfSelected).getY()
         );
    }
    
    public void resizeUp(Rectangle mousePos){
      //point.x - mouse.x + width = width of square
         Canvas.squares.get(
                  indexOfSelected).setSize(
                          (int)Canvas.squares.get(indexOfSelected).getWidth(),
                          
                 Canvas.points[2].y  - (int)mousePos.getY()
                 + (int)Canvas.squares.get(indexOfSelected).getHeight()
         );
         
       //set location of point to the mosue 
       Rectangle temp = new Rectangle(Canvas.squares.get(indexOfSelected));
         Canvas.squares.get(indexOfSelected).setLocation(
                 (int) Canvas.squares.get(indexOfSelected).getX(),
                (int)mousePos.getY() + 5
         );
    }
    public void resizeDown(Rectangle mousePos){
      //point.x - mouse.x + width = width of square
         Canvas.squares.get(
                  indexOfSelected).setSize(
                 (int)Canvas.squares.get(indexOfSelected).getWidth(),
                 (int)mousePos.getY() - Canvas.points[3].y 
                 + (int)Canvas.squares.get(indexOfSelected).getHeight()
         );
       //set location of point to the mosue 
       Rectangle temp = new Rectangle(Canvas.squares.get(indexOfSelected));
         Canvas.squares.get(indexOfSelected).setLocation(
                 (int) Canvas.squares.get(indexOfSelected).getX(),
                (int)mousePos.getY() - (int)temp.getHeight()
         );
    }
}

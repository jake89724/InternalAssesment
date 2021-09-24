/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import visual.Canvas;

/**
 *
 * @author j.head
 */
public class MouseController implements MouseMotionListener, MouseListener {

    int number = 1;

    public MouseController() {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //create a rectangle at mouse position 
        //check using the .intesect method
        Resize resize = new Resize();
        Rectangle mousePos = new Rectangle(e.getX(), e.getY(), 1, 1);
        try{
            Rectangle [] pointPos = new Rectangle[4];
            for (int i = 0; i < Canvas.points.length; i++) {
            
            pointPos[i] = new Rectangle(
                    Canvas.points[i].x, 
                    Canvas.points[i].y, 
                    10, 10
            );
            
            if(mousePos.intersects(pointPos[i])){
                if(i == 0){
                    resize.reSizeLeft(mousePos);
                }
                //Canvas.squares.get(Canvas.indexOfSelected).setSize(, i);
            }
        }
        }catch(NullPointerException j){
            
        }
       
        
        
      
        for (int i = 0; i < Canvas.squares.size(); i++) {
            
            if (mousePos.intersects(Canvas.squares.get(i))) {
                Rectangle temp  = new Rectangle(Canvas.squares.get(i));
                Canvas.squares.get(i).setLocation((int)mousePos.x - (int)temp.getWidth()/2, (int) mousePos.y - (int)temp.getHeight()/2);
            }

        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) { 
        Rectangle mousePos = new Rectangle(e.getX(), e.getY(), 1, 1);
        boolean touching = false;
        for (int i = 0; i < Canvas.squares.size(); i++) {
            number++;
            if (mousePos.intersects(Canvas.squares.get(i))) {
                System.out.println("on block");
                Canvas.indexOfSelected = i;
                touching = true;
            }
            
        }
        if(!touching){
            Canvas.indexOfSelected = - 1;
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("release");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }


}

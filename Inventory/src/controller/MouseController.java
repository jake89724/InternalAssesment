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
public class MouseController implements MouseMotionListener {

    int number = 1;

    public MouseController() {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //create a rectangle at mouse position 
        //check using the .intesect method
        Rectangle mousePos = new Rectangle(e.getX(), e.getY(), 1, 1);

       // System.out.println(e.getX() + " : " + e.getY());
        for (int i = 0; i < Canvas.squares.size(); i++) {
//            Rectangle temp = new Rectangle(Canvas.squares.get(i));
//            if(e.getX() < temp.getX() + temp.getWidth()  && e.getX() > temp.getX()){
//                
//            }
            if (mousePos.intersects(Canvas.squares.get(i))) {
                Canvas.squares.get(i).setLocation((int)mousePos.x - 25, (int) mousePos.y - 25);
            }

        }
       // System.out.println("hi " + number);
        number++;

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}

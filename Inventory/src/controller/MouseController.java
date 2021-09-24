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

    Rectangle dragSquare;
    boolean draggingSquare = false;
    boolean draggingPoint = false;

    public MouseController() {
        //might move logic to movement class in visual
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //create a rectangle at mouse position 
        //check using the .intesect method
        Resize resize = new Resize();
        Rectangle mousePos = new Rectangle(e.getX(), e.getY(), 1, 1);
        int indexOfPoint = 0;
        if (!draggingPoint) {
            try {
                Rectangle[] pointPos = new Rectangle[4];
                for (int i = 0; i < Canvas.points.length; i++) {

                    pointPos[i] = new Rectangle(
                            Canvas.points[i].x,
                            Canvas.points[i].y,
                            10, 10
                    );

                    if (mousePos.intersects(pointPos[i])) {
                        if (i == 0) {
                            draggingPoint = true;
                            draggingSquare = false;
                            indexOfPoint = i;
                        }
                        //Canvas.squares.get(Canvas.indexOfSelected).setSize(, i);
                    }
                }
            } catch (NullPointerException j) {

            }
        }

        if (draggingPoint) {
            if (indexOfPoint == 0) {
                resize.reSizeLeft(mousePos);
            }

        }

        /*
         draging logic makes object stay locked to mouse regardless of speed 
        it also makes it so the squares cannot get stuck together
         */
        int indexOfSquare = 0;
        if (!draggingSquare) {
            for (int i = 0; i < Canvas.squares.size(); i++) {

                if (mousePos.intersects(Canvas.squares.get(i))) {
                    dragSquare = new Rectangle(Canvas.squares.get(i));
                    draggingSquare = true;
                    indexOfSquare = i;
                }

            }
        }

        if (draggingSquare) {
            Rectangle temp = new Rectangle(dragSquare);
            Canvas.squares.get(indexOfSquare).setLocation((int) mousePos.x - (int) temp.getWidth() / 2, (int) mousePos.y - (int) temp.getHeight() / 2);
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
            if (mousePos.intersects(Canvas.squares.get(i))) {
                Canvas.indexOfSelected = i;
                touching = true;
            }

        }
        if (!touching) {
            Canvas.indexOfSelected = - 1;
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("release");
        draggingSquare = false;
        draggingPoint = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}

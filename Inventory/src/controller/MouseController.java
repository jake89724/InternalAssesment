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
    int indexOfSquare = 0;
    int indexOfPoint = 0;

    public MouseController() {
        //might move logic to movement class in visual
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //create a rectangle at mouse position 
        //check using the .intesect method
        Resize resize = new Resize();
        Rectangle mousePos = new Rectangle(e.getX(), e.getY(), 1, 1);

        if (!draggingSquare) {
            if (!draggingPoint) {
                try {
                    Rectangle[] pointPos = new Rectangle[4];
                    for (int i = 0; i < Canvas.points.length; i++) {
                        pointPos[i] = new Rectangle(
                                Canvas.points[i].x,
                                Canvas.points[i].y,
                                10, 10
                        );
                    }
                    for (int i = 0; i < Canvas.points.length; i++) {
                        if (mousePos.intersects(pointPos[i])) {
                            if (i == 0) {
                                draggingPoint = true;
                                draggingSquare = false;
                                indexOfPoint = i;
                                System.out.println("at 0");
                            } else if (i == 1) {
                                System.out.println("at 1");
                                draggingPoint = true;
                                draggingSquare = false;
                                indexOfPoint = i;
                            } else if (i == 2) {
                                System.out.println("at 2");
                                draggingPoint = true;
                                draggingSquare = false;
                                indexOfPoint = i;
                            } else if (i == 3) {
                                System.out.println("at 3");
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
        }
        if (draggingPoint) {
            if (indexOfPoint == 0) {
                resize.reSizeLeft(mousePos);
            } else if (indexOfPoint == 1) {
                resize.reSizeRight(mousePos);
                System.out.println("resize ");
            } else if (indexOfPoint == 2) {
                resize.resizeUp(mousePos);
                System.out.println("resize ");
            } else if (indexOfPoint == 3) {
                resize.resizeDown(mousePos);
                System.out.println("resize ");
            }

        }

        /*
         draging logic makes object stay locked to mouse regardless of speed 
        it also makes it so the squares cannot get stuck together
         */
        if (!draggingPoint) {
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
                if (mousePos.x < Canvas.frame.getWidth() - 200 - Canvas.squares.get(indexOfSquare).getHeight() / 2
                        && mousePos.y < Canvas.frame.getHeight() - 200 - Canvas.squares.get(indexOfSquare).getHeight() / 2) {
                    Canvas.squares.get(indexOfSquare).setLocation(
                            (int) mousePos.x - (int) temp.getWidth() / 2,
                            (int) mousePos.y - (int) temp.getHeight() / 2
                    );
                } else {
                    if (mousePos.x > Canvas.frame.getWidth() - 200 - Canvas.squares.get(indexOfSquare).getHeight() / 2) {

                        System.out.println(indexOfSquare + "mouse out");
                        Canvas.squares.get(indexOfSquare).setLocation(
                                Canvas.frame.getWidth() - 200 - (int) Canvas.squares.get(indexOfPoint).getWidth(),
                                (int) mousePos.y - (int) temp.getHeight() / 2
                        );

                    } else {

                        Canvas.squares.get(indexOfSquare).setLocation(
                                (int) mousePos.x - (int) temp.getWidth() / 2,
                                Canvas.frame.getHeight() - 200 - (int) Canvas.squares.get(indexOfPoint).getHeight()
                        );

                    }
                }

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

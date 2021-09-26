/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JPanel;

/**
 *
 * @author j.head
 */
public class Square extends Shape{
    Rectangle rectangle;
    JPanel panel;
    Graphics g;
    int length;
    int width;
    int x;
    int y;
    public Square(Rectangle rectangle){
        this.rectangle = rectangle;
        x = (int)rectangle.getX();
        y = (int)rectangle.getY();
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return x;
    }
    public int getWidth(){
        return (int)rectangle.getWidth();
    }
    public int getHeight(){
        return (int)rectangle.getHeight();
    }
    public Rectangle getRect(){
        return rectangle;
    }
}

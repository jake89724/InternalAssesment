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
public class Square {
    Rectangle rectangle;
    JPanel panel;
    Graphics g;
    int length;
    int width;
    int x;
    int y;
    public Square(){
        rectangle = new Rectangle(50, 50, 100, 100);
    }
    
    public Rectangle getRect(){
        return rectangle;
    }
    
    public void paintComponent(Graphics g){
        panel.paintComponents(g);
        g.drawRect(50, 50, 100, 100);
    }
}
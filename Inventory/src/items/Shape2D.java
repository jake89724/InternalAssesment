/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import java.awt.Color;

/**
 *
 * @author Jake
 */
public interface Shape2D {
    int getX(); // returns x position
    int getY(); // returns y psoition
    Color getColor(); // returns color
    void setColor(Color color); // sets the color of the shape
    int getWidth(); // returns width of shape
    int getHeight(); // returns height of shape
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import controller.MouseController;
import controller.Point;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author j.head
 */
public class Canvas extends JPanel {

    public static LinkedList<Rectangle> squares = new LinkedList();
    public static Rectangle select = new Rectangle();
    
    boolean check = false;
    JFrame frame = new JFrame("Canvas");
    //the index of the selected object for graphcis to highlight
    public static int indexOfSelected = -1; //-1 is impossible numebr
    //the points ofresixable dots
    public static Point [] points;

    public Canvas() {

     
            MouseController controller = new MouseController();
            this.addMouseMotionListener(controller);
//            SelectObject select = new SelectObject();
            this.addMouseListener(controller);
   

        frame.setSize(500, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(this);
        //frame.setLayout(null);
        //this.setLayout(null);
 
        JButton btnAddButton = new JButton("New Square");
        btnAddButton.setLayout(null);
        this.setLayout(null);
        this.add(btnAddButton);
        btnAddButton.setLayout(null);

        btnAddButton.setBounds(100, frame.getHeight() - 150, 120, 50);

        timer();

        btnAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button pressed");
                check = true;
                repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        //g.drawString("hi", WIDTH, WIDTH);
        g.drawLine(frame.getWidth(), frame.getHeight() - 200, 0, frame.getHeight() - 200);
        //draws all squares and selected squares
        drawShapes(g);
        //checks if button was pressed and adds new square to canvas
        if (check) {
            squares.add(new Rectangle(random(1, 500), random(1, 500), 50, 50));

            System.out.println("here");
            check = false;
        }
       
    }
    
    public void drawShapes(Graphics g){
        for (int i = 0; i < squares.size(); i++) {
            Rectangle temp = new Rectangle(squares.get(i));
            g.fillRect((int) temp.getX(), (int) temp.getY(),
                    (int)squares.get(i).getWidth(), (int)squares.get(i).getHeight());
            //creates the selected object graphics
            if(i == indexOfSelected){
                 Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.cyan);
                g2.setStroke(new BasicStroke(3));
                g2.drawRect((int) temp.getX(), (int)temp.getY(),
                        (int)squares.get(i).getWidth(),
                        (int)squares.get(i).getHeight());
                //create 4 dots that let you resize the square
                resizeShape(g2);
               
                g2.setColor(Color.black);
                g2.setStroke(new BasicStroke(1));
            }
        }
    }

    private static int random(int low, int high) {

        double seed = Math.random();
        double L = (double) low;
        double H = (double) high;
        double number = (H - L + 1) * seed + L;
        return (int) number;
    }

    private void timer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                repaint();
            }

        }, 0, 17);
    }

    private void resizeShape(Graphics2D g) {
        //create 4 points 
        g.setColor(Color.red);
        int index = indexOfSelected;
        Rectangle selected = new Rectangle(squares.get(index));
        Point left = new Point((int)selected.getX() - 10, (int)selected.getY() + (int)selected.getWidth()/2 - 5);
        Point right = new Point((int)selected.getX() + (int)selected.getWidth(), (int)selected.getY() + (int)selected.getWidth()/2 - 5);
        Point up = new Point((int)selected.getX() + (int)selected.getWidth()/2 - 5, (int)selected.getY() - 5);
        Point down = new Point((int)selected.getX() + (int)selected.getWidth()/2 - 5, (int)selected.getY() + (int)selected.getHeight());
        points = new Point[4];
        points[0] = left;
        points[1] = right;
        points[2] = up;
        points[3] = down;
        
        //temp 
//        g.fillOval(left.x, left.y, 10, 10);
//        g.fillOval(right.x, right.y, 10, 10);
//        g.fillOval(up.x, up.y, 10, 10);
//        g.fillOval(down.x, down.y, 10, 10);
    //array stuf not working figure out
        for (int i = 0; i < points.length; i++) {
            g.fillOval(points[i].x, points[i].y, 10, 10);
            
        }
        g.setStroke(new BasicStroke(0.5f));
        g.drawLine(left.x - 20, left.y + 5, right.x + 20, right.y + 5);
        g.drawLine(up.x + 5, up.y - 20, down.x + 5, down.y + 20);
        //attempt to create a diagonal line
        g.drawLine(left.x - 20, down.y + 30, up.y - 30, right.x + 20);
        g.setStroke(new BasicStroke(1));
        g.setColor(Color.black);
        
        //have grid on off toggle??
        //resizable
    }

}

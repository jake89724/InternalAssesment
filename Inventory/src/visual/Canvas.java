/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import controller.MouseController;
import java.awt.Color;
import java.awt.Graphics;
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
    
    boolean check = false;
    JFrame frame = new JFrame("Canvas");
    
    public Canvas(){
        
        
        
        MouseController controller = new MouseController();
        this.addMouseMotionListener(controller);
        
        
        
        
        frame.setSize(500, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(this);
        //frame.setLayout(null);
        //this.setLayout(null);
        
        createButtons();
        JButton btnAddButton = new JButton("New Square");
        btnAddButton.setLayout(null);
        this.setLayout(null);
        this.add(btnAddButton);
        btnAddButton.setLayout(null);
        
        btnAddButton.setBounds(100, frame.getHeight() - 150, 120, 50);
        
        timer();
        
        //btnAddButton.setLocation(frame.getWidth() - 50, frame.getHeight() / 2);
        //if(Click == x & y) square = mouse.posiiton
        
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
        g.drawLine
        (frame.getWidth(), frame.getHeight() - 200, 0, frame.getHeight() - 200);
        for (int i = 0; i < squares.size(); i++) {
                Rectangle temp = new Rectangle(squares.get(i));
                g.fillRect((int)temp.getX(),(int) temp.getY(), 50, 50); 
            }
        if(check){
            squares.add(new Rectangle(random(1, 500), random(1, 500), 100, 100));
            
            System.out.println("here");
            check = false;
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
    private void createButtons() {
    }
}

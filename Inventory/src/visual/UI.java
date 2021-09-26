/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import inventory.Item;
import inventory.Storage;
import items.Square;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author j.head
 */
public class UI extends JPanel{
    boolean check = false;
    public static JFrame frame = new JFrame("Inventory");
    public UI(){
        setFrame(500, 500);
        JButton btnButton = new JButton("Add shape");
        this.add(btnButton);
        JButton btnShowLast = new JButton("Show Shape");
        this.add(btnShowLast);
        btnShowLast.setBounds(100, 10, 125, 25);
  
        
        btnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Canvas canvas = new Canvas();
                frame.setEnabled(false);
            }
        });
        btnShowLast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check = true;
                repaint();
            }

            
        });
    
    
    

              btnButton.setBounds(250, 10, 125, 25);
    }
    
    private <T> void getUserInput(T item) {
        Item<T> number1 = new Item<>(1, item.toString(), item);
        number1.setName("wow");
        System.out.println(number1.getType());
        System.out.println(number1.getName());
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
      //  Square square = new Square();
      if(check){
          for (int i = 0; i < Storage.item1.size(); i++) {
              
              g.fillRect(Storage.item1.get(i).getX(),
                      Storage.item1.get(i).getY(),
                      Storage.item1.get(i).getWidth(),
                      Storage.item1.get(i).getHeight());
          }
          check = false;
      }
    }

    private void setFrame(int length, int width) {
        
        frame.setSize(width, length);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(this);
        
        
    }
}

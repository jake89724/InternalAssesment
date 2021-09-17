/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import inventory.Item;
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
    JFrame frame = new JFrame("Inventory");
    public UI(){
        setFrame(400, 500);
        JButton btnButton = new JButton("Store Item");
        this.add(btnButton);
        btnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getUserInput(
                        JOptionPane.showInputDialog("Enter a value")
                );
            }

            
        });
        
    
    
    

        btnButton.setSize(100, 75);
        btnButton.setLocation(250, 200);
    }
    
    private <T> void getUserInput(T item) {
        Item<T> number1 = new Item<>(1, item.toString());
        number1.setName("wow");
        System.out.println(number1.getType());
        System.out.println(number1.getName());
        
    }

    private void setFrame(int length, int width) {
        
        frame.setSize(width, length);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(this);
    }
}

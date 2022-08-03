package com.abhishek.chatsingh.views;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class UserView extends JFrame {
    int counter;
     public UserView(){
         counter=0;
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setSize(600,400);
//         setLocation(400,100);
         setLocationRelativeTo(null);
         setResizable(false);
         setTitle("Chat Singh");
         JLabel title=new JLabel("Welcome to Chat Singh...");
         title.setFont(new Font("Arial",Font.BOLD,28));
         title.setBounds(100,10,400,80);
        
         JLabel login=new JLabel("");
         login.setText("Login:");
         login.setFont(new Font("Arial",Font.BOLD,20));
         login.setBounds(120,30,135,120);
         
         
         JLabel counterLabel = new JLabel("");
         counterLabel.setFont(new Font("Arial",Font.BOLD,15));
         counterLabel.setBounds(120,85,130,150);
         
         
         JButton button=new JButton("Increment");
         button.setBounds(120,120,105,25);
         button.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent event) {
                 counter++;
                 counterLabel.setText("Count:"+counter);
             }
         
         
         });
         
         
         Container container=this.getContentPane();
         container.setLayout(null);
         container.add(title);
         container.add(login);
         container.add(button);
         container.add(counterLabel);
         setVisible(true);
     }
     public static void main(String[] args){
         UserView userview=new UserView();
     }
}

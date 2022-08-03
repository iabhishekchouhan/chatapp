// package com.abhishek.chatsingh.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.abhishek.chatsingh.dao.UserDAO;
import com.abhishek.chatsingh.dto.UserDTO;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UserScreen extends JFrame{
	private JTextField user_id;
	private JPasswordField passwordField;

	public static void main(String[] args) {
			UserScreen window = new UserScreen();
			
	}
	UserDAO userDAO=new UserDAO();
	
	private void register() throws ClassNotFoundException, SQLException,Exception {
		String userid = user_id.getText();
//		String password=passwordField.getText();
		char[] password=passwordField.getPassword(); 
		UserDTO userDTO = new UserDTO(userid,password);
		int res=userDAO.register(userDTO);
		if(res>0) {
			JOptionPane.showMessageDialog(this, "Registered Successfully...");
//			System.out.println("Registered Successfully...");
		}
		else {
			JOptionPane.showMessageDialog(this, "Not Registered...");
//			System.out.println("Can not registered...");
		}
//		System.out.println("UserID : "+userid+" UserPassword : " + password.toString());
	}
	public void login()  {
		String userid = user_id.getText();
		char[] password=passwordField.getPassword(); 
		UserDTO userDTO = new UserDTO(userid,password);
		try {
			String message="Welcome: "+userid;
			if(userDAO.islogin(userDTO)) {
				//JOptionPane.showMessageDialog(this,message);
				setVisible(false);
				dispose();
				Dashboard dashboard=new Dashboard(message);
				dashboard.setVisible(true);
			}
			else {
				message="Invalid User ID or Password...";
				JOptionPane.showMessageDialog(this,message);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public UserScreen() {
		getContentPane().setFont(new Font("Snap ITC", Font.BOLD, 15));
		setBackground(Color.GRAY);
		setTitle("Chat Singh");
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To Chat Singh...");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblNewLabel.setBounds(105, 50, 257, 51);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter User ID:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_1.setBounds(105, 95, 101, 36);
		getContentPane().add(lblNewLabel_1);
		
		user_id = new JTextField();
		user_id.setBounds(203, 107, 141, 19);
		getContentPane().add(user_id);
		user_id.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		lblNewLabel_2.setBounds(122, 141, 84, 23);
		getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(203, 141, 141, 19);
		getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		btnNewButton.setBounds(151, 196, 98, 21);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					register();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnNewButton_1.setBounds(259, 197, 103, 21);
		getContentPane().add(btnNewButton_1);
		setBounds(100, 100, 467, 431);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	}


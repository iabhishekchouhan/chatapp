package com.abhishek.chatsingh.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;

public class Dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	public Dashboard(String message) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle(message);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(139, 21, 670, 419);
		lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/assets/dashboard1.png")));
		contentPane.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 0, 101, 22);
		contentPane.add(menuBar);
		
//		JMenuBar menuBar = new JMenuBar();
//		setJMenuBar(menuBar);
		JMenu mnMove = new JMenu("Chat Options");
		menuBar.add(mnMove);
		
		JMenu mnNewMenu = new JMenu("Start Chat");
		mnMove.add(mnNewMenu);
	}
}

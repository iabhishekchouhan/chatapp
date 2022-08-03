package com.abhishek.chatsingh.networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.abhishek.chatsingh.utils.ConfigReader;

public class Client {
	Socket socket; 
	public Client() throws UnknownHostException, IOException {
		int PORT=Integer.parseInt(ConfigReader.getValue("PortNo"));
		socket = new Socket(ConfigReader.getValue("Server_IP"),PORT);
		System.out.println("Client Arrived...");
		
		System.out.println("Enter your message :");
		Scanner sc=new Scanner(System.in);
		String message=sc.nextLine();
		OutputStream out = socket.getOutputStream();
//		
//		InputStream in = socket.getInputStream();
//		byte arr[] = in.readAllBytes();
//		String str=new String(arr);
//		System.out.println("Messge received from Server : "+str);
		
		sc.close();
		out.write(message.getBytes());
		out.close();
//		in.close();
				
		socket.close();
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Client client =new Client();
	}
}

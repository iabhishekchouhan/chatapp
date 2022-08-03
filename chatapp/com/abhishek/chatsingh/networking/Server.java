package com.abhishek.chatsingh.networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.abhishek.chatsingh.utils.ConfigReader;

public class Server {
	ServerSocket serversocket;
	public Server() throws IOException {
		int PORT=Integer.parseInt(ConfigReader.getValue("PortNo"));
		serversocket = new ServerSocket(PORT);
		System.out.println("Server Started and waiting for client to join...");
		Socket socket = serversocket.accept();  //handshaking
		System.out.println("Client has joined successfully");
		InputStream in = socket.getInputStream();
		byte arr[] = in.readAllBytes();
		String str=new String(arr);
		System.out.println("Messge received from client : "+str);
		
		System.out.println("Enter your message :");
		Scanner sc=new Scanner(System.in);
		String message=sc.nextLine();
		OutputStream out = socket.getOutputStream();
		sc.close();
		out.write(message.getBytes());
		out.close();
		
		in.close();
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		Server server =new Server();
	}
}

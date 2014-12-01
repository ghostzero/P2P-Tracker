package net.renepreuss.P2P.Tracker;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try{
			ServerSocket welcomeSocket = new ServerSocket(3000);
			while (true) {
			    Socket connectionSocket = welcomeSocket.accept();
			    Thread t = new Thread(new Runnable() {
					
					@Override
					public void run() {
						try{
							BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
						    DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
						    while(true){
						    	String input = inFromClient.readLine();
						    	if(input.getBytes()[0] == 0xB1){
							    	
							    }
						    }
						}catch(Exception e){
							System.out.println("Tracker::Client: " + e);
						}
					}
				});
			    t.start();
			}
		}catch(Exception e){
			System.out.println("Tracker: " + e);
		}
	}
}

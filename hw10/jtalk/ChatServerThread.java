//Jacob Vargo
package jtalk;

import java.net.*;
import java.io.*;
import java.util.*;

public class ChatServerThread extends Thread{
	Socket socket = null;
	TreeMap<String, ChatData> roomMap = null;

	public ChatServerThread (Socket socket, TreeMap<String, ChatData> roomMap){
		super("ChatServerThread");
		this.socket = socket;
		this.roomMap = roomMap;
	}

	public void run(){
		try(
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		   ){
			String inputLine, outputLine, userName;
			if ((userName = in.readLine()) != null){
				//choose chat room
				while (true){
					for (String roomName : roomMap.keySet()){
						out.println(roomName + ":" + roomMap.get(roomName).broadcastMembers());
					}
					out.println("Enter chat room:");
					if ((inputLine = in.readLine()) == null)
						break;

					ChatData room = roomMap.get(inputLine);
					if (room != null){
						room.addClient(userName, out);

						while ((inputLine = in.readLine()) != null){
							room.distributeMessage(userName + ": " + inputLine);
						}
						room.deleteClient(userName);
						break;
					}
					out.println("Invalid chat room name");
				}
			}
		}
		catch (IOException e){
			System.out.println("ChatServerThread: IOException");
		}
		finally{
			try{
				socket.close();
			}
			catch (IOException e){
				System.out.println("ChatServerThread: IOException on socket close");
			}
		}
	}
}

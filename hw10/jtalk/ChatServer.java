//Jacob Vargo
package jtalk;

import java.net.*;
import java.io.*;
import java.util.TreeMap;

public class ChatServer{
	public static void main(String args[]) throws IOException{
		if (args.length < 2){
			System.out.println("Usage: java ChatServer Port-Number Chat-Room-Names ...");
			System.exit(0);
		}
		int portNumber = Integer.parseInt(args[0]);
		boolean listening = true;
		TreeMap<String, ChatData> roomMap = new TreeMap<String, ChatData>();
		for (int i = 1; i < args.length; i++) roomMap.put(args[i], new ChatData(args[i]));

		try(ServerSocket server = new ServerSocket(portNumber)){
			while (listening){
				new ChatServerThread(server.accept(), roomMap).start();
			}
		}
		catch (IOException e){
			System.out.println("Could not listen on port " + portNumber);
			System.exit(0);
		}
	}
}

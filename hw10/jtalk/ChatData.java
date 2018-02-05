//Jacob Vargo
package jtalk;

import java.net.*;
import java.io.*;
import java.util.TreeMap;

public class ChatData{
	String RoomName;
	TreeMap<String, PrintWriter> clients;

	public ChatData(String name){
		this.RoomName = name;
		this.clients = new TreeMap<String, PrintWriter>();
	}
	public synchronized void distributeMessage(String input){
		//print msg to each client
		for (PrintWriter out : clients.values())
			out.println(input);
	}
	public synchronized void addClient(String name, PrintWriter out){
		//add client to list
		clients.put(name, out);
		distributeMessage(name + " has joined");
	}
	public synchronized void deleteClient(String name){
		clients.remove(name);
		distributeMessage(name + " has left");
	}
	public synchronized String broadcastMembers(){
		String ret = new String();
		for (String name : clients.keySet()){
			ret += " " + name;
		}
		return ret;
	}
}

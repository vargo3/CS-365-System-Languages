//Jacob Vargo
package jtalk;

import java.net.*;
import java.io.*;

public class TalkClient{
	String myName, hostName;
	int portNumber;

	public TalkClient(String args[]){
		hostName = args[0];
		portNumber = Integer.parseInt(args[1]);
		myName = args[2];

		try(
			Socket socket = new Socket(hostName, portNumber);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		){
			String input;
			//thread will handle reading in and printing it to screen
			(new TalkClientThread(in)).start();
			out.println(myName);
			while((input = stdIn.readLine()) != null){
				out.println(input);
			}
		}
		catch (UnknownHostException e){
			System.out.println("Cannot find host " + hostName);
			System.exit(0);
		}
		catch (IOException e){
			System.out.println("Couldn't get I/O for the connection to " + hostName);
			System.exit(0);
		}
		finally{
			System.out.println("TalkClient dies");
		}
	}
	public static void main(String args[]){
		if (args.length != 3){
			System.out.println("Usage: java jtalk.TalkClient hostname portname chatname");
			System.exit(0);
		}
		new TalkClient(args);
	}
}

//Jacob Vargo
package jtalk;

import java.net.*;
import java.io.*;

public class TalkClientThread extends Thread{
	BufferedReader in;
	public TalkClientThread(BufferedReader in){
		this.in = in;
	}

	public void run(){
		String line;
		try{
			while ((line = in.readLine()) != null){
				System.out.println(line);
			}
		}
		catch (IOException e){
			System.out.println("TalkThread IOEception");
			System.exit(0);
		}
		finally{
			System.out.println("TalkClientThread has died");
		}
	}
}

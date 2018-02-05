//Jacob Vargo

import queue.*;
import java.util.Scanner;

public class QueueDriver{
	public static void main(String args[]){
		Queue<String> myQueue;
		Scanner scan = new Scanner(System.in);;
		String action;

		myQueue = new Queue<String>(scan.nextInt());

		//read in rest of file to myQueue
		while(scan.hasNext()){
			action = scan.next();
			if (action.equals("enqueue")){
				action = scan.next();
				try{
					myQueue.enqueue(action);
				}
				catch (OverflowException e){
					System.out.println("queue full: cannot enqueue " + action);
				}
			}
			else if (action.equals("dequeue")){
				try{
					action = myQueue.dequeue();
					System.out.println(action);
				}
				catch (EmptyException e){
					System.out.println("queue empty: cannot dequeue");
				}
			}
		}
		scan.close();
	}
}

//Jacob Vargo
package queue;

import java.util.*;

public class Queue<T>{
	ArrayList<T> vec;
	int maxsize;
	public Queue(int maxCapacity){
		maxsize = maxCapacity;
		vec = new ArrayList<T>(maxCapacity);
	}
	public void enqueue(T value) throws OverflowException{
		if (vec.size() < maxsize) vec.add(value);
		else throw new OverflowException();
	}
	public T dequeue() throws EmptyException{
		if (isEmpty()){
			throw new EmptyException();
		}
		return vec.remove(0);
	}
	public boolean isEmpty(){
		return vec.isEmpty();
	}
}

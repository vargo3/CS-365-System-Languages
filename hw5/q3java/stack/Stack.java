//Jacob Vargo
package stack;

import java.util.*;

public class Stack<T>{
	protected ArrayList<T> al;
	protected int maxsize;

	public Stack(){
		al = new ArrayList<T>();
		maxsize = 100;
		al.ensureCapacity(maxsize);
	}
	public Stack(int size){
		al = new ArrayList<T>();
		maxsize = size;
		al.ensureCapacity(maxsize);
	}
	public boolean push(T value){
		if (al.size() == maxsize) return false;
		al.add(value);
		return true;
	}
	public T pop(){
		return al.remove(al.size()-1);
	}
	public boolean isEmpty(){
		if (al.isEmpty()) return true;
		return false;
	}
};

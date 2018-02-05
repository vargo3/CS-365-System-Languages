package graphics;
import java.awt.*;

public class Rectangle extends Shape{
	public void draw(Graphics g){
		g.setColor(color);
		g.fillRect(left, top, width, height);
	}
	public boolean containsPt(int x, int y){
		if (left < x && x <= left+width && top < y & y <= height) return true;
		return false;
	}
	public String toString(){
		return String.format("Rectangle(%d, %d, %d, %d)%n", left, top, width, height);
	}
	public Rectangle(){
		setLeft(0);
		setTop(0);
		setWidth(20);
		setHeight(20);
		setColor(Color.black);
	}
	public Rectangle(int l, int t, int w, int h, Color c){
		setLeft(l);
		setTop(t);
		setWidth(w);
		setHeight(h);
		setColor(c);
	}
}

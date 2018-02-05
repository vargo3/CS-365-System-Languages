package graphics;
import java.awt.*;

public class Oval extends Shape{
	public void draw(Graphics g){
		g.setColor(color);
		g.fillOval(left, top, width, height);
	}
	public boolean containsPt(int x, int y){
		if (left < x && x <= left+width && top < y & y <= height) return true;
		return false;
	}
	public String toString(){
		return String.format("Oval(%d, %d, %d, %d)%n", left, top, width, height);
	}
	public Oval(){
		left = 0;
		top = 0;
		width = 20;
		height = 20;
		color = Color.black;
	}
	public Oval(int l, int t, int w, int h, Color c){
		left = l;
		top = t;
		width = w;
		height = h;
		color = c;
	}
}

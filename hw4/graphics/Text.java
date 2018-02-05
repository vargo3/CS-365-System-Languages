package graphics;
import java.awt.*;

public class Text extends Shape{
	protected String text;
	public void draw(Graphics g){
		g.setColor(color);
		g.drawString(text, left, top);
	}
	public boolean containsPt(int x, int y){
		if (left < x && x <= left+width && top < y & y <= height) return true;
		return false;
	}
	public String toString(){
		return String.format("Text(%d, %d, %d, %d)%n", left, top, width, height);
	}
	public Text(){
		left = 0;
		top = 0;
		width = 7;
		height = 16;
		text = "";
		color = Color.black;
	}
	public Text(int l, int t, Color c, String s){
		left = l;
		top = t;
		width = 7;
		height = 16;
		color = c;
		text = s;
	}
}

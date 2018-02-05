package graphics;
import java.awt.*;

public class Roundtangle extends Shape{
	int arcsize;
	public static final int SMALL = 10;
	public static final int MEDIUM = 20;
	public static final int LARGE = 30;
	public void draw(Graphics g){
		g.setColor(getColor());
		g.fillRoundRect(getLeft(),getTop(), getWidth(), getHeight(), arcsize, arcsize);
	}
	public boolean containsPt(int x, int y){
		if (getLeft() < x && x <= getLeft()+getWidth() && getTop() < y & y <= getHeight()) return true;
		return false;
	}
	public String toString(){
		return String.format("Roundtangle(%d, %d, %d, %d)%n", getLeft(), getTop(), getWidth(), getHeight());
	}
	public Roundtangle(){
		setLeft(0);
		setTop(0);
		setWidth(20);
		setHeight(20);
		setColor(Color.black);
		arcsize = MEDIUM;
	}
	public Roundtangle(int l, int t, int w, int h, Color c, int arc){
		setLeft(l);
		setTop(t);
		setWidth(w);
		setHeight(h);
		setColor(c);
		arcsize = arc;
	}
}

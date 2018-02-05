package graphics;
import java.awt.*;

public class Line implements GraphicalObject{
	protected int x1, y1, x2, y2;
	protected Color color;
	public int getX1(){ return x1; }
	public int getY1(){ return y1; }
	public int getX2(){ return x2; }
	public int getY2(){ return y2; }
	public Color getColor(){ return color; }
	public void setX1(int i){ x1 = i; }
	public void setY1(int i){ y1 = i; }
	public void setX2(int i){ x2 = i; }
	public void setY2(int i){ y2 = i; }
	public void setColor(Color c){ color = c; }
	public void draw(Graphics g){
		g.setColor(color);
		g.drawLine(x1, y1, x2, y2);
	}
	public boolean containsPt(int x, int y){
		return false;
	}
	public String toString(){
		return String.format("Line(%d, %d, %d, %d)%n", x1, y1, x2, y2);
	}
	public Line(){
		x1 = 0;
		y1 = 0;
		x2 = 20;
		y2 = 20;
		color = Color.black;
	}
	public Line(int a1, int b1, int a2, int b2, Color c){
		x1 = a1;
		y1 = b1;
		x2 = a2;
		y2 = b2;
		color = c;
	}
}

package graphics;
import java.awt.*;

public abstract class Shape implements GraphicalObject{
	protected int top, left, width, height;
	protected Color color;
	public int getTop(){ return top; }
	public void setTop(int t){ top = t; }
	public int getLeft(){ return left; }
	public void setLeft(int l){ left = l; }
	public int getWidth(){ return width; }
	public void setWidth(int w){ width = w; }
	public int getHeight(){ return height; }
	public void setHeight(int h){ height = h; }
	public Color getColor(){ return color; }
	public void setColor(Color c){ color = c; }
}

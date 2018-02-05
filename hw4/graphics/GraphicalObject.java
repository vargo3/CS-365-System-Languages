package graphics;
import java.awt.*;
import java.awt.geom.*;

public interface GraphicalObject{
	public void draw(Graphics g);
	public boolean containsPt(int x, int y);
	public String toString();
}

//Jacob Vargo
package SliderApp;

import java.util.Observable;
import java.util.ArrayList;
import java.util.List;

public class SliderAppModel {
	public int val, min, max, inc;
    List<UpdateView> observers = new ArrayList<UpdateView>();

    public int getValue() { return val; }

    public void setValue(int newVal) { 
		val = newVal; 
		for (UpdateView view : observers) {
			view.update();
		}
    }

    public void addObserver(UpdateView view) { observers.add(view); }
}
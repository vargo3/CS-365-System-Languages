//Jacob Vargo
package SliderApp;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class GaugeView extends JPanel implements UpdateView{
	SliderAppModel model;
	
	public GaugeView(SliderAppModel ParentModel){
		model = ParentModel;
		model.addObserver(this);
	}

    public void update() {
    }
}
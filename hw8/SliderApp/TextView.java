//Jacob Vargo
package SliderApp;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class TextView extends JLabel implements UpdateView{
	SliderAppModel model;
	
	public TextView(SliderAppModel ParentModel){
		model = ParentModel;
		model.addObserver(this);
		
		setText(Integer.toString(model.getValue()));//value of the numeric value
		setHorizontalAlignment(JLabel.CENTER);
	}

    public void update() {
		setText(Integer.toString(model.getValue()));//value of the numeric value
    }
}
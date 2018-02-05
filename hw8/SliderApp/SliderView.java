//Jacob Vargo
package SliderApp;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class SliderView extends JPanel implements ActionListener, ChangeListener, UpdateView{
	JButton up, down;
	JSlider slider;
	SliderAppModel model;
	
	public SliderView(SliderAppModel ParentModel){
		model = ParentModel;
		model.addObserver(this);
		
		slider = new JSlider(model.min, model.max, model.getValue());
		slider.addChangeListener(this);
		up = new JButton("Increment");
		up.setActionCommand("up");
		up.addActionListener(this);
		down = new JButton("Decrement");
		down.setActionCommand("down");
		down.addActionListener(this);
		this.add(down, BorderLayout.LINE_START);
		this.add(slider, BorderLayout.CENTER);
		this.add(up, BorderLayout.LINE_END);
	}

	public void actionPerformed(ActionEvent e){
		int val = model.getValue();
		int max = model.max;
		int min = model.min;
		int inc = model.inc;
		if ("up".equals(e.getActionCommand())){
			if (val == max){
				//JOptionPane.showMessageDialog(frame, "Value is already at its maximum");
			} else if (val + inc > max){
				val = max;
			} else {
				val += inc;
			}
		} else {
			if (val == min){
				//JOptionPane.showMessageDialog(frame, "Value is already at its minimum");
			} else if (val - inc < min){
				val = min;
			} else {
				val -= inc;
			}
		}
		slider.setValue(val);	
	}

	public void stateChanged(ChangeEvent e){
		JSlider source = (JSlider)e.getSource();
		if (!source.getValueIsAdjusting()){
			model.setValue((int)source.getValue());
		}
	}


    public void update() {
		slider.setValue(model.getValue());
    }
}
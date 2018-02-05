//Jacob Vargo
package SilderApp;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class SliderApp extends JPanel implements ActionListener, ChangeListener {
	protected int val, min, max, start, inc;
	protected JFrame frame;
	protected JLabel label;
	protected JPanel content, slidep; 	
	protected JButton down, up;
	protected JSlider slider;

	public SliderApp(String args[]){
		try{
			min = Integer.parseInt(args[0]);
			max = Integer.parseInt(args[1]);
			start = Integer.parseInt(args[2]);
			inc = Integer.parseInt(args[3]);
		}
		catch (NumberFormatException e){
			System.out.println("Error: could not convert all arguments to integers%n");
			return;
		}
		val = start;

		//create GUI and add components
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content = new JPanel(new BorderLayout());
		label = new JLabel();
		label.setText(Integer.toString(val));//value of the numeric value
		label.setHorizontalAlignment(JLabel.CENTER);
		content.add(label, BorderLayout.PAGE_START);
		slidep = new JPanel(new BorderLayout());
		down = new JButton("Decrement");
		down.setActionCommand("down");
		down.addActionListener(this);
		slidep.add(down, BorderLayout.LINE_START);
		slider = new JSlider(min, max, start);
		slider.addChangeListener(this);
		slidep.add(slider, BorderLayout.CENTER);
		up = new JButton("Increment");
		up.setActionCommand("up");
		up.addActionListener(this);
		slidep.add(up, BorderLayout.LINE_END);
		content.add(slidep, BorderLayout.CENTER);
		frame.setContentPane(content);
		frame.pack();
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		if ("up".equals(e.getActionCommand())){
			if (val == max){
				JOptionPane.showMessageDialog(frame, "Value is already at its maximum");
			} else if (val + inc > max){
				val = max;
			} else {
				val += inc;
			}
		} else {
			if (val == min){
				JOptionPane.showMessageDialog(frame, "Value is already at its minimum");
			} else if (val - inc < min){
				val = min;
			} else {
				val -= inc;
			}
		}
		label.setText(Integer.toString(val));
		slider.setValue(val);
	}

	public void stateChanged(ChangeEvent e){
		JSlider source = (JSlider)e.getSource();
		if (!source.getValueIsAdjusting()){
			val = (int)source.getValue();
			label.setText(Integer.toString(val));
		}
	}

	public static void main(String args[]){
		new SliderApp(args);
	}
}

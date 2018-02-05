//Jacob Vargo
package SliderApp;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JFrame;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class SliderAppMVC extends javax.swing.JFrame {

    SliderAppModel model = new SliderAppModel();

    public SliderAppMVC(String args[]) {
		try{
			model.min = Integer.parseInt(args[0]);
			model.max = Integer.parseInt(args[1]);
			model.inc = Integer.parseInt(args[3]);
			model.setValue(Integer.parseInt(args[2]));
		}
		catch (NumberFormatException e){
			System.out.println("Error: could not convert all arguments to integers%n");
			return;
		}
		initComponents();
    }

    private void initComponents() {

		JLabel text = new TextView(model);
		JPanel slider = new SliderView(model);
		JPanel gauge = new GaugeView(model);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.BorderLayout());

        getContentPane().add(text, BorderLayout.PAGE_START);
        getContentPane().add(slider, BorderLayout.CENTER);
        //getContentPane().add(gauge);

        pack();
    }

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SliderAppMVC(args).setVisible(true);
            }
        });
    }
}
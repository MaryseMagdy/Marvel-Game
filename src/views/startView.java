package views;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.Controller;

public class startView extends JPanel {
	private JButton startButton;
	private ActionListener lis;
	private ImageIcon bg;
	private JLabel label;
	
	public startView(ActionListener l){
		this.setSize(300,300);
		
		
		lis = l;
		startButton= new JButton();
		startButton.setText("Ready for an adventure?");
		startButton.setActionCommand("MaryzeHena");
		startButton.addActionListener(lis);
		
		bg = new ImageIcon("marvel1.png");
		label = new JLabel(bg);
		label.setSize(1600,900);
		this.add(label);
		
		
		this.add(startButton);
		startButton.setBounds(300,250,300,250);
		
		
	}

}

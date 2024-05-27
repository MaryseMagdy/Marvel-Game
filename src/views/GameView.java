package views;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import engine.Controller;

public class GameView extends JFrame {

	private ActionListener listener;
	private JPanel board;
	private JPanel p1;
	private JPanel p2;
	private JPanel info;
	private JPanel theOrder;
	private JPanel actions;
	private JPanel mdirections;
	private JTextArea text1;
	private JTextArea text2;
	private String Player_1;
	private String Player_2;
	private JLabel move;
	private JLabel attack;


	public GameView(ActionListener l) throws IOException {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.listener = l;
		this.setSize(1600,900);
		this.setVisible(true);
		
		this.setTitle("Marvel War Game");
		

	}
}

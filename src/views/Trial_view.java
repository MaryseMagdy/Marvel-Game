package views;
// this class represent the main window to the user whenever he launches the game , refreance lab 2 vod
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Trial_view extends JFrame {
	private JPanel board;
//	private JTextArea player1;
//	private JTextArea player2;

	public Trial_view(){
		// TODO Auto-generated constructor stub
		this.setBounds(0, 0, 1000, 1000);//first 2 # represent the place where the window appears 2nd 2 # are the dimensions
		this.setTitle("Marvel War Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);// in order to terminate the window
		this.setVisible(true);// any window starts invisible that why we should call this method 
		//
		board= new JPanel();
		board.setPreferredSize(new Dimension(500,500));
		board.setLayout(new GridLayout(5,5));
		this.add(board,BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
		//
		JButton b = new JButton();
		b.setText("trial");
		board.add(b);
		this.revalidate();
		this.repaint();
		//
//		player1=new JTextArea();
//		player1.setPreferredSize(new Dimension(200,100));
//		player1.setText("PLAYER 1");
//		player1.setEditable(false);
//		this.add(player1,BorderLayout.WEST);
//		this.revalidate();
//		this.repaint();
//		//
//		player2=new JTextArea();
//		player2.setPreferredSize(new Dimension(200,100));
//		player2.setText("PLAYER 2");
//		player2.setEditable(false);
//		this.add(player2,BorderLayout.EAST);
//		this.revalidate();
//		this.repaint();
//		
//		
//		
//	}
//
//	
//	public JTextArea getPlayer1() {
//		return player1;
//	}
//
//
//	public JTextArea getPlayer2() {
//		return player2;
//	}
//
//
//	public JPanel getBoard() {
//		return board;
//	}
//
//
//	public static void main(String[] args) {
//		new GameView();
//
	}

}

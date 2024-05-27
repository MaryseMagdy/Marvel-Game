package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import engine.Controller;

public class mainView extends JPanel {
	private ActionListener lis;
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
	
	public mainView() {
		// TODO Auto-generated constructor stub
		this.board= new JPanel();
		board.setPreferredSize(new Dimension(500,500));
		this.add(this.board,BorderLayout.CENTER);
		//boardMaker(game.getB);
		
//		

		p1= new JPanel();
		//TODO TITLE "FIRST PLAYER"	
		p1.setPreferredSize(new Dimension(150,this.getHeight()));
		this.add(p1,BorderLayout.WEST);
		this.revalidate();
		this.repaint();
		this.text1 = new JTextArea();
		this.text1.setText(" First Player's name \n"+Controller.getPlayer_1());
		this.text1.setEditable(false);
		p1.add(text1);
		this.revalidate();
		this.repaint();
//
		p2= new JPanel();
		//TODO TITLE "SECOND PLAYER"
		p2.setPreferredSize(new Dimension(150,this.getHeight()));
		this.add(p2,BorderLayout.EAST);
		this.revalidate();
		this.repaint();
		this.text2 = new JTextArea();
		this.text2.setText(" Second Player's name \n "+Controller.getPlayer_2());
		this.text2.setEditable(false);
		p2.add(text2);
		this.revalidate();
		this.repaint();
//	
		info = new JPanel();
		info.setPreferredSize(new Dimension(250,100));
		this.add(info,BorderLayout.NORTH);
		this.revalidate();
		this.repaint();
		JButton b3 = new JButton();
		b3.setText("trial INFO");
		info.add(b3);
		this.revalidate();
		this.repaint();
//		
		theOrder= new JPanel();
		theOrder.setPreferredSize(new Dimension(600,80));
		this.add(theOrder,BorderLayout.NORTH);
		this.revalidate();
		this.repaint();
		JButton b4 = new JButton();
		b4.setText("trial order");
		info.add(b4);
		this.revalidate();
		this.repaint();
//		
		actions= new JPanel();
		actions.setPreferredSize(new Dimension(500,150));
		this.add(actions,BorderLayout.SOUTH);
		this.revalidate();
		this.repaint();
//		
		JButton endTurn = new JButton();
		endTurn.setText("End Turn");
		endTurn.setActionCommand("End turn");
		actions.add(endTurn);
		this.revalidate();
		this.repaint();
		
		JButton leaderAbility = new JButton();
		leaderAbility.setText("Leader Ability");
		actions.add(leaderAbility);
		this.revalidate();
		this.repaint();
		
//		
		JPanel mattack= new JPanel();
		mattack.setPreferredSize(new Dimension(160,70));
		actions.add(mattack);
		this.revalidate();
		this.repaint();
		
		JButton upAttack=new JButton();
		upAttack.setText("up");
		upAttack.setActionCommand("attackUp");
		mattack.add(upAttack,BorderLayout.NORTH);
		this.revalidate();
		this.repaint();

		JButton downAttack=new JButton();
		downAttack.setText("down");
		downAttack.setActionCommand("attackDown");
		mattack.add(downAttack,BorderLayout.SOUTH);
		this.revalidate();
		this.repaint();
		
		JButton leftAttack=new JButton();
		leftAttack.setText("left");
		leftAttack.setActionCommand("attackLeft");
		mattack.add(leftAttack,BorderLayout.WEST);
		this.revalidate();
		this.repaint();

		JButton rightAttack=new JButton();
		rightAttack.setText("right");
		rightAttack.setActionCommand("attackRight");
		mattack.add(rightAttack,BorderLayout.EAST);
		this.revalidate();
		this.repaint();


		JLabel attack = new JLabel();
		attack.setText("attack");
		mattack.add(attack,BorderLayout.CENTER);
		this.revalidate();
		this.repaint();

		
		JButton castAbility = new JButton();
		castAbility.setText("Cast Ability");
		actions.add(castAbility);
		this.revalidate();
		this.repaint();	
//		
	
		
		mdirections= new JPanel();
		mdirections.setPreferredSize(new Dimension(160,70));
		mdirections.setLayout(new BorderLayout());
		actions.add(mdirections,BorderLayout.EAST);
		this.revalidate();
		this.repaint();
		move = new JLabel();
		move.setText("MOVE");
		mdirections.add(move);
		this.revalidate();
		this.repaint();
		
		JButton moveUP= new JButton();
		moveUP.setText("up");
		moveUP.setActionCommand("moveUP");
		mdirections.add(moveUP,BorderLayout.NORTH);
		this.revalidate();
		this.repaint();
		
		JButton moveDOWN = new JButton();
		moveDOWN.setText("down");
		moveDOWN.setActionCommand("moveDOWN");
		mdirections.add(moveDOWN,BorderLayout.SOUTH);
		this.revalidate();
		this.repaint();
		
		JButton moveLEFT = new JButton();
		moveLEFT.setText("left");
		moveLEFT.setActionCommand("moveLEFT");
		mdirections.add(moveLEFT,BorderLayout.WEST);
		this.revalidate();
		this.repaint();
		
		JButton moveRIGHT = new JButton();
		moveRIGHT.setText("right");
		moveRIGHT.setActionCommand("moveRIGHT");
		mdirections.add(moveRIGHT,BorderLayout.EAST);
		this.revalidate();
		this.repaint();
		
		
		
	}
	public void boardMaker(Object[][]board){
		this.remove(this.board); 
		this.board = new JPanel(new GridLayout(engine.Game.getBoardheight(),engine.Game.getBoardwidth()));
		for (int i = 0 ; i<engine.Game.getBoardheight();i++){
			for(int j=0 ; j<engine.Game.getBoardwidth();j++){
				JButton b = new JButton();
				b.setActionCommand(i + " " + j);
				b.setText(""+i+","+j);
				b.addActionListener(lis);
				this.board.add(b);
			}
		}
		this.add(this.board);
		this.revalidate();
		this.repaint();
		this.board.setVisible(true);
		}

	
	public JTextArea getText1() {
		return text1;
	}
	public JTextArea getText2() {
		return text2;
	}
	public static void main(String[] args) {


	}
	public String getPlayer_1() {
		return Player_1;
	}
	public String getPlayer_2() {
		return Player_2;
	}
	}





package engine;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javafx.stage.Popup;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.world.Direction;
import views.GameView;
import views.mainView;
import views.choiceView;
import views.startView;

public class Controller implements ActionListener {
	private Game model;
	private GameView view;
	private Player p1;
	private Player p2;
	private static String Player_1;
	private static String Player_2;
	private JPanel choices;
	private static int count = 0;
	private choiceView cv;
	private startView stv;
	private mainView lol;

	private JButton b = new JButton("staart");

	public Controller() throws IOException {
		// TODO Auto-generated constructor stub
		view = new GameView(this);
		stv = new startView(this);
		cv = new choiceView(this);
		// view.setLayout(null);
		view.add(stv);
		stv.setBounds(0, 0, 100, 100);
		view.revalidate();
		view.repaint();

	}

	public static String getPlayer_1() {
		return Player_1;
	}

	public static String getPlayer_2() {
		return Player_2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());

		String[] s = e.getActionCommand().split(",");
		String x = s[0];
		System.out.println(x);

		if (x.equals("select")) {
			String y = s[1];
			int a = Integer.parseInt(y);
			((JButton) e.getSource()).setEnabled(false);
			if (count < 3) {
				count++;
				p1.getTeam().add(Game.getAvailableChampions().get(a));
				if (count == 1) {
					p1.setLeader(Game.getAvailableChampions().get(a));
				}

			}
			if (count >= 3 && count < 6) {
				count++;
				p2.getTeam().add(Game.getAvailableChampions().get(a));
				if (count == 4) {
					p2.setLeader(Game.getAvailableChampions().get(a));
				}
			}
		}
		System.out.println(count);
		if (x.equals("done") && count == 6) {
			System.out.println("here");
			view.remove(cv);
			lol = new mainView();
			view.add(lol);
			view.revalidate();
			view.repaint();
		}
		if (x.equals("attackUp")) {
			try {
				this.model.attack(Direction.UP);
			} catch (ChampionDisarmedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotEnoughResourcesException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvalidTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (x.equals("attackDown")) {
			try {
				this.model.attack(Direction.DOWN);
			} catch (ChampionDisarmedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotEnoughResourcesException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvalidTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (x.equals("attackLeft")) {
			try {
				this.model.attack(Direction.LEFT);
			} catch (ChampionDisarmedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotEnoughResourcesException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvalidTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (x.equals("attackRight")) {
			try {
				this.model.attack(Direction.RIGHT);
			} catch (ChampionDisarmedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotEnoughResourcesException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvalidTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (x.equals("moveUP")) {
			try {
				this.model.move(Direction.UP);
			} catch (UnallowedMovementException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotEnoughResourcesException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (x.equals("moveDOWN")) {
			try {
				this.model.move(Direction.DOWN);
			} catch (UnallowedMovementException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotEnoughResourcesException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (x.equals("moveLEFT")) {
			try {
				this.model.move(Direction.LEFT);
			} catch (UnallowedMovementException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotEnoughResourcesException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (x.equals("moveRIGHT")) {
			try {
				this.model.move(Direction.RIGHT);
			} catch (UnallowedMovementException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotEnoughResourcesException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (x.equals("MaryzeHena")) {
			System.out.println(123);
			
			
			this.Player_1 = JOptionPane.showInputDialog(null,
					"Enter the first player's name", "First player",
					JOptionPane.INFORMATION_MESSAGE);
			JLabel name1 = new JLabel(Player_1 + ": ");
			p1 = new Player(Player_1);
			name1.setBounds(50, 100, 100, 50);
			if (this.Player_1 == null) {
				this.Player_1 = " 1st player";
			}
			this.Player_2 = JOptionPane.showInputDialog(null,
					"Enter the second player's name", "Second player",
					JOptionPane.INFORMATION_MESSAGE);
			p2 = new Player(Player_2);
			JLabel name2 = new JLabel(Player_2 + ": ");
			name2.setBounds(50, 100, 100, 50);
			
			view.remove(stv);
			view.add(cv);
			view.revalidate();
			view.repaint();
			//this.lol.boardMaker(this.model.getBoard());
			//view.remove(cv);
			//view.add(lol);
			//view.revalidate();
			//view.repaint();
		}
	

	}

	// if(e.getActionCommand().equals("Attack")){
	// this.model.attack(d);
	// }else if(e.getActionCommand().equals("End turn")){
	// this.model.endTurn();
	// }
	//

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated
		new Controller();

	}

	public Game getModel() {
		return model;
	}

	public GameView getView() {
		return view;
	}
}

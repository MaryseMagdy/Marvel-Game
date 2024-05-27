package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.StyledEditorKit.FontSizeAction;

import model.world.Champion;
import engine.Game;

public class choiceView extends JPanel {
	private JPanel choices;
	private JPanel c;
	private JTextArea t;
	private JTextArea t1;
	private ActionListener lis;
	
	public choiceView(ActionListener lis) throws IOException {
		this.lis = lis;
		Game.loadAbilities("Abilities.csv");
		Game.loadChampions("Champions.csv");
		ArrayList<Champion> a = Game.getAvailableChampions();
		
		this.setSize(1000, 1000);
		this.setVisible(true);
		this.choices= new JPanel();
		this.setLayout(new BorderLayout());
		this.add(choices,BorderLayout.NORTH);
		// should be made of 2 panels

		this.choices.setVisible(true);
		this.choices.setPreferredSize(new Dimension(500,500));
		this.choices.setLayout(new GridLayout(5,3)); 
		 Game.getAvailableChampions();
		 for(int i=0;i<a.size() ;i++){
		
			JButton b = new JButton();
			b.setActionCommand("select,"+i );
			b.setText(Game.getAvailableChampions().get(i).getName());
			b.addActionListener(lis);
			b.setToolTipText(Game.getAvailableChampions().get(i).toString()) ;

//			b.setToolTipText("" + "\n Abilities :"+
//			Game.getAvailableChampions().get(i).getAbilities().get(0).getName()+" "+
//			Game.getAvailableChampions().get(i).getAbilities().get(1).getName()+" "+
//			Game.getAvailableChampions().get(i).getAbilities().get(2).getName()) ;
//			b.setToolTipText();
			this.choices.add(b);
		}
		 	c= new JPanel();
		 	c.setLayout(new BorderLayout());
		 	this.add(c,BorderLayout.SOUTH);
		 	JButton done= new JButton();
		 	done.setText("Done!");
		 	done.addActionListener(lis);
		 	done.setActionCommand("done");
		 	c.add(done,BorderLayout.SOUTH);
		 	t=new JTextArea();
		 	t1=new JTextArea();
		 	t.setText("The first player should choose his champions first");
		 	t.setEditable(false);
		 	t1.setText("Please note that the first champion you choose is the Leader for your team");
		 	t1.setEditable(false);
		 	c.add(t,BorderLayout.NORTH);
		 	Font f = new Font("Ink Free" , Font.BOLD , 20);
		 	t.setFont(f);
		 	t1.setFont(f);
		 	c.add(t1);
		 	this.revalidate();
			this.repaint();	
//			new mainView();
	}

//		// TODO Auto-generated constructor stub
		
	}
	

//}

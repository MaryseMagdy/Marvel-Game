package model.world;

import java.awt.Point;
import java.util.ArrayList;

import engine.Game;
import model.abilities.Ability;
import model.effects.Effect;

public abstract class Champion implements Comparable, Damageable{

	private String name;
	private int mana;
	private int attackRange;
	private int attackDamage;
	private int speed;
	private int maxHP;
	private int currentHP;
	private ArrayList<Ability> abilities;
	private ArrayList<Effect> appliedEffects;
	private Point location;
	private Condition condition;
	private int maxActionPointsPerTurn;
	private int currentActionPoints;

	public Champion(String name, int maxHP, int mana, int maxActionsPerTurn, int speed, int attackRange,
			int attackDamage) {
		this.name = name;
		this.mana = mana;
		this.attackRange = attackRange;
		this.attackDamage = attackDamage;
		this.speed = speed;
		this.maxHP = maxHP;
		this.maxActionPointsPerTurn = maxActionsPerTurn;
		this.currentActionPoints = maxActionsPerTurn;
		this.currentHP = maxHP;
		this.abilities = new ArrayList<Ability>();
		this.appliedEffects = new ArrayList<Effect>();
		this.condition = Condition.ACTIVE;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
		if (currentHP <= 0) {
			this.currentHP = 0;
			this.condition = Condition.KNOCKEDOUT;
		}
		else if (currentHP > maxHP)
			this.currentHP = maxHP;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condtion) {
		this.condition = condtion;
	}

	public int getMaxActionPointsPerTurn() {
		return maxActionPointsPerTurn;
	}

	public void setMaxActionPointsPerTurn(int maxActionsPerTurn) {
		this.maxActionPointsPerTurn = maxActionsPerTurn;
	}

	public String getName() {
		return name;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getAttackRange() {
		return attackRange;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public ArrayList<Ability> getAbilities() {
		return abilities;
	}

	public ArrayList<Effect> getAppliedEffects() {
		return appliedEffects;
	}

	public int getCurrentActionPoints() {
		return currentActionPoints;
	}

	public void setCurrentActionPoints(int currentActionPoints) {
		this.currentActionPoints = currentActionPoints;
		if (currentActionPoints > maxActionPointsPerTurn)
			this.currentActionPoints = maxActionPointsPerTurn;
		if (currentActionPoints < 0)
			this.currentActionPoints = 0;
	}
	
	public abstract void useLeaderAbility(ArrayList<Champion> targets);

	public int compareTo(Object o) {
		if(o instanceof Champion) {
			Champion c = (Champion) o;
			if(this.speed != c.speed)
				return c.speed - this.speed;
			else
				return this.name.compareTo(c.name);
		}
		return 0;
	}
	public String toString(){
		ArrayList<Champion> a = Game.getAvailableChampions();
		for(int i=0;i<a.size() ;i++){
		String s = "Name:" +getName() +"\n"
				+ "Mana:" + getMana() + "\n" 
				+ "Abilities :" + "\n"+ 
					Game.getAvailableChampions().get(i).getAbilities().get(0).getName()+" "+
				    Game.getAvailableChampions().get(i).getAbilities().get(1).getName()+" "+
					Game.getAvailableChampions().get(i).getAbilities().get(2).getName() ;
		//TODO kamle ba2et l attributes.
		return s;
		}
		return null;
	}
	
}

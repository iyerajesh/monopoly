package com.barclays.microservices.monopoly.cell;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.barclays.microservices.monopoly.game.GameMaster;
import com.barclays.microservices.monopoly.player.Player;

public abstract class Cell implements IOwnable {

	@Autowired
	protected GameMaster gameMaster;

	private static final Logger logger = LoggerFactory.getLogger(Cell.class);

	private boolean available = true;
	protected Player owner;
	private String name;


	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	public String getName() {
		return name;
	}

	public int getPrice() {
		return 0;
	}

	public abstract void playAction();

	void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
	
	public abstract void setColorGroup();

	public abstract String getColorGroup();

}
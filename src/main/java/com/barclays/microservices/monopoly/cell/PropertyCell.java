package com.barclays.microservices.monopoly.cell;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.barclays.microservices.monopoly.game.GameMaster;
import com.barclays.microservices.monopoly.player.Player;

@Component
@PropertySource({ "classpath:${envTarget:monopoly}.properties" })

public class PropertyCell extends Cell {

	@Autowired
	public GameMaster gameMaster;

	@Autowired
	private Environment env;

	private static final Logger logger = LoggerFactory.getLogger(PropertyCell.class);

	public static String COLOR_GROUP;

	private int housePrice;
	private int numHouses;
	private int rent;
	private int sellPrice;

	private String colorGroup;

	public int getHousePrice() {
		return housePrice;
	}

	public int getNumHouses() {
		return numHouses;
	}

	public int getPrice() {
		return sellPrice;
	}

	public int getRent() {
		int rentToCharge = rent;
		rentToCharge = calcMonopolyRent(rentToCharge);

		if (numHouses > 0) {
			rentToCharge = rent * (numHouses + 1);
		}
		return rentToCharge;
	}

	private int calcMonopolyRent(int rentToCharge) {
		String[] monopolies = owner.getMonopolies();
		for (int i = 0; i < monopolies.length; i++) {
			if (monopolies[i].equals(colorGroup)) {
				rentToCharge = rent * 2;
			}
		}
		return rentToCharge;
	}

	public void playAction() {
		Player currentPlayer = null;
		if (!isAvailable()) {
			currentPlayer = gameMaster.getCurrentPlayer();
			payRent(currentPlayer);
		}
	}

	private void payRent(Player currentPlayer) {
		if (owner != currentPlayer) {
			currentPlayer.payRentTo(owner, getRent());
		}
	}

	public void setHousePrice(int housePrice) {
		this.housePrice = housePrice;
	}

	public void setNumHouses(int numHouses) {
		this.numHouses = numHouses;
	}

	public void setPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	@Override
	public String getColorGroup() {
		return COLOR_GROUP;
	}

	@Override
	public void setColorGroup() {
		this.COLOR_GROUP = env.getProperty("cell.color.property");
	}
}

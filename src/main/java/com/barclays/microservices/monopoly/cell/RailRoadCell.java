package com.barclays.microservices.monopoly.cell;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.barclays.microservices.monopoly.player.Player;

@Component
@PropertySource({ "classpath:${envTarget:monopoly}.properties" })

public class RailRoadCell extends Cell {

	@Autowired
	private Environment env;

	private static final Logger logger = LoggerFactory.getLogger(RailRoadCell.class);
	public static String COLOR_GROUP;

	private static int baseRent;
	private static int price;

	public static void setBaseRent(int baseRent) {
		RailRoadCell.baseRent = baseRent;
	}

	public static void setPrice(int price) {
		RailRoadCell.price = price;
	}

	public int getPrice() {
		return RailRoadCell.price;
	}

	public int getRent() {
		return RailRoadCell.baseRent * (int) Math.pow(2, owner.numberOfRR() - 1);
	}

	public void playAction() {

		Player currentPlayer = null;
		if (!isAvailable()) {
			currentPlayer = gameMaster.getCurrentPlayer();
			checkOwnership(currentPlayer);
		}
	}

	public void checkOwnership(Player currentPlayer) {
		if (owner != currentPlayer) {
			currentPlayer.payRentTo(owner, getRent());
		}
	}

	@Override
	public String getColorGroup() {
		return COLOR_GROUP;
	}

	@Override
	public void setColorGroup() {
		this.COLOR_GROUP = env.getProperty("cell.color.railroad");
	}
}

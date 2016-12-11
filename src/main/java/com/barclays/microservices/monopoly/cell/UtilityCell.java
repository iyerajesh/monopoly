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
public class UtilityCell extends Cell {

	private static final Logger logger = LoggerFactory.getLogger(UtilityCell.class);

	@Autowired
	private Environment env;

	public static String COLOR_GROUP;

	private static int PRICE;

	public static void setPrice(int price) {
		UtilityCell.PRICE = price;
	}

	public int getPrice() {
		return UtilityCell.PRICE;
	}

	public int getRent(int diceRoll) {
		if (owner.numberOfUtil() == 1) {
			return diceRoll * 4;
		} else if (owner.numberOfUtil() >= 2) {
			return diceRoll * 10;
		}
		return 0;
	}

	public void playAction() {

		Player currentPlayer = null;
		if (!isAvailable()) {
			currentPlayer = gameMaster.getCurrentPlayer();
			if (owner != currentPlayer) {
				gameMaster.utilRollDice();
				int diceRoll = gameMaster.getUtilDiceRoll();
				currentPlayer.payRentTo(owner, getRent(diceRoll));
			}
		}
	}

	@Override
	public String getColorGroup() {
		return COLOR_GROUP;
	}

	@Override
	public void setColorGroup() {
		this.COLOR_GROUP = env.getProperty("cell.color.utility");
	}
}

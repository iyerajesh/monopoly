package com.barclays.microservices.monopoly.game;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barclays.microservices.monopoly.player.Player;

@Component
public class GameMaster {

	@Autowired
	public GameBoard gameBoard;

	private static final Logger logger = LoggerFactory.getLogger(GameMaster.class);

	public static final int MAX_PLAYER = 8;

	private int turn = 0;
	private int initAmountOfMoney;
	private int utilDiceRoll;

	private List<Player> players = new ArrayList<Player>();

	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public Player getCurrentPlayer() {
		return getPlayer(turn);
	}

	public Player getPlayer(int index) {
		return (Player) players.get(index);
	}

	public int getPlayerIndex(Player player) {
		return players.indexOf(player);
	}

	public void setGameBoard(GameBoard board) {
		this.gameBoard = board;
	}

	public void setInitAmountOfMoney(int money) {
		this.initAmountOfMoney = money;
	}

	public void setNumberOfPlayers(int number) {
		players.clear();

		for (int i = 0; i < number; i++) {

			Player player = new Player();
			player.setMoney(initAmountOfMoney);
			players.add(player);
		}
	}

	public void utilRollDice() {
		this.utilDiceRoll = 1;
	}

	public int getUtilDiceRoll() {
		return this.utilDiceRoll;
	}

	public void updateGUI() {
		// TODO: Implemented blank
	}

}

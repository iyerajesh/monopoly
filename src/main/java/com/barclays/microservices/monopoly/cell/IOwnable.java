package com.barclays.microservices.monopoly.cell;

import com.barclays.microservices.monopoly.player.Player;

public interface IOwnable {

	public abstract Player getOwner();

	public abstract void setOwner(Player owner);

}
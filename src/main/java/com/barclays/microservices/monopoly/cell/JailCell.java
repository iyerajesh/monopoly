package com.barclays.microservices.monopoly.cell;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource({ "classpath:${envTarget:monopoly}.properties" })

public class JailCell extends Cell {

	private static final Logger logger = LoggerFactory.getLogger(JailCell.class);

	@Autowired
	private Environment env;

	public static int BAIL = 50;
	private static String COLOR_GROUP;

	public JailCell() {
		setName("Jail");
	}

	public void playAction() {

	}

	@Override
	public String getColorGroup() {
		return COLOR_GROUP;
	}

	@Override
	public void setColorGroup() {
		// TODO Auto-generated method stub
		this.COLOR_GROUP = env.getProperty("cell.color.jail");
	}

}

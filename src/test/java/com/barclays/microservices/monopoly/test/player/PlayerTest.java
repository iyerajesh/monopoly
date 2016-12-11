package com.barclays.microservices.monopoly.test.player;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.barclays.microservices.monopoly.cell.PropertyCell;
import com.barclays.microservices.monopoly.config.PlayerApplication;
import com.barclays.microservices.monopoly.player.Player;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PlayerApplication.class })
public class PlayerTest {

	private static final Logger logger = LoggerFactory.getLogger(PlayerTest.class);

	@Autowired
	@Mock
	private Player player;

	@Autowired
	@Mock
	PropertyCell propertyCell;

	@Before
	public void beforeTests() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Autowired
	private Environment env;

	@Test
	public void testBuyPropertyFunction() {

		player.buyProperty(propertyCell, 500);
		boolean checkProperty = player.checkProperty("PROPERTY");

		assertEquals("The check property value should be: ", false, checkProperty);

	}

	@Test
	public void testGetOutOfJail() {
		player.getOutOfJail();

	}

}
package com.barclays.microservices.monopoly.test.game;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.barclays.microservices.monopoly.cell.JailCell;
import com.barclays.microservices.monopoly.cell.PropertyCell;
import com.barclays.microservices.monopoly.cell.RailRoadCell;
import com.barclays.microservices.monopoly.cell.UtilityCell;
import com.barclays.microservices.monopoly.config.PlayerApplication;
import com.barclays.microservices.monopoly.game.GameMaster;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PlayerApplication.class })
public class GameMasterTest {

	private static final Logger LOG = LoggerFactory.getLogger(GameMasterTest.class);

	@Autowired
	@Mock
	private GameMaster gameMaster;

	@Before
	public void beforeTests() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Autowired
	private Environment env;

	@Test
	public void testMaxPlayerLimit() {

		assertEquals("The Max limit for this game should be: ", 8, GameMaster.MAX_PLAYER);
	}

}
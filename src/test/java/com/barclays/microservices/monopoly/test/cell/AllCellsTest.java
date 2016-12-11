package com.barclays.microservices.monopoly.test.cell;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PlayerApplication.class })
public class AllCellsTest {

	private static final Logger logger = LoggerFactory.getLogger(AllCellsTest.class);

	@Autowired
	@Mock
	private UtilityCell utilityCell;

	@Autowired
	@Mock
	private PropertyCell propertyCell;

	@Autowired
	@Mock
	private JailCell jailCell;

	@Autowired
	@Mock
	private RailRoadCell railRoadCell;

	@Before
	public void beforeTests() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Autowired
	private Environment env;

	@Test
	public void testColorGroupForUtilityCell() {

		assertEquals("The Color Group for the UtilityCell should be: ", "UTILITY",
				env.getProperty("cell.color.utility"));
	}

	@Test
	public void testColorGroupForPropertyCell() {

		assertEquals("The Color Group for the Property Cell should be: ", "PROPERTY",
				env.getProperty("cell.color.property"));
	}

	@Test
	public void testColorGroupForJailCell() {

		assertEquals("The Color Group for the Jail Cell should be: ", "JAIL", env.getProperty("cell.color.jail"));
	}

	@Test
	public void testColorGroupForRailRoadCell() {

		assertEquals("The Color Group for the RailRoad Cell should be: ", "RAILROAD",
				env.getProperty("cell.color.railroad"));
	}

	@Test
	public void testPlayerActionWithUtilityCell() {

		utilityCell.playAction();

	}

	@Test
	public void testPlayerActionWithPropertyCell() {

		propertyCell.playAction();

	}

	@Test
	public void testPlayerActionWithJailCell() {

		jailCell.playAction();

	}

	@Test
	public void testPlayerActionWithRailRoadCell() {

		railRoadCell.playAction();

	}

}
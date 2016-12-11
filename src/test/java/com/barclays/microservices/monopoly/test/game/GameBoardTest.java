package com.barclays.microservices.monopoly.test.game;

import static org.junit.Assert.assertEquals;

import java.util.List;

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

import com.barclays.microservices.monopoly.cell.Cell;
import com.barclays.microservices.monopoly.cell.PropertyCell;
import com.barclays.microservices.monopoly.config.PlayerApplication;
import com.barclays.microservices.monopoly.game.GameBoard;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PlayerApplication.class })
public class GameBoardTest {

	private static final Logger logger = LoggerFactory.getLogger(GameBoardTest.class);

	@Autowired
	@InjectMocks
	private GameBoard gameBoard;

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
	public void testCellAddFunction() {

		gameBoard.addCell(propertyCell);
		List<Cell> cells = gameBoard.getAllCells();
		
		assertEquals("The Cell added should be: ", 1, cells.size());
	}

}
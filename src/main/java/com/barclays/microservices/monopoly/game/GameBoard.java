package com.barclays.microservices.monopoly.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.barclays.microservices.monopoly.cell.Cell;
import com.barclays.microservices.monopoly.cell.PropertyCell;

@Component
public class GameBoard {

	private static final Logger logger = LoggerFactory.getLogger(GameBoard.class);

	private List<Cell> cells = new ArrayList<Cell>();
	private List chanceCards = new ArrayList();

	// the key of colorGroups is the name of the color group.
	private HashMap<String, Integer> colorGroups = new HashMap<String, Integer>();

	private ArrayList communityChestCards = new ArrayList();

	public void addCell(Cell go) {
		cells.add(go);
	}

	public void addCell(PropertyCell cell) {
		String colorGroup = cell.getColorGroup();
		int propertyNumber = getPropertyNumberForColor(colorGroup);
		colorGroups.put(colorGroup, new Integer(propertyNumber + 1));
		cells.add(cell);

		logger.debug("The size of cells:" + cells.size());
	}

	public List<Cell> getAllCells() {
		return cells;
	}

	public Cell queryCell(String string) {

		logger.debug("The size of the cells:" + cells.size());

		for (int i = 0; i < cells.size(); i++) {
			Cell temp = (Cell) cells.get(i);
			if (temp.getName().equals(string)) {
				return temp;
			}
		}
		return null;
	}

	public PropertyCell[] getPropertiesInMonopoly(String color) {
		PropertyCell[] monopolyCells = new PropertyCell[getPropertyNumberForColor(color)];
		int counter = 0;
		for (int i = 0; i < getCellNumber(); i++) {
			Cell c = getCell(i);
			counter = getCounter(color, monopolyCells, counter, c);
		}
		return monopolyCells;
	}

	private int getCounter(String color, PropertyCell[] monopolyCells, int counter, Cell c) {
		if (c instanceof PropertyCell) {
			PropertyCell pc = (PropertyCell) c;
			if (pc.getColorGroup().equals(color)) {
				monopolyCells[counter] = pc;
				counter++;
			}
		}
		return counter;
	}

	public Cell getCell(int newIndex) {
		return (Cell) cells.get(newIndex);
	}

	public int getCellNumber() {
		return cells.size();
	}

	public int getPropertyNumberForColor(String name) {
		Integer number = (Integer) colorGroups.get(name);
		if (number != null) {
			return number.intValue();
		}
		return 0;
	}

	public void removeCards() {
		communityChestCards.clear();
	}
}

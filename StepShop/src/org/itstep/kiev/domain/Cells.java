package org.itstep.kiev.domain;

import java.util.ArrayList;

public class Cells {

	Cell cell;
	ArrayList<Cell> cells;
	
	public Cell getCell() {
		return cell;
	}
	public void setCell(Cell cell) {
		cell = cell;
	}
	
	public void addCell(Cell cell) {
		cells.add(cell);
	}
	public void removeCell(Cell cell) {
		cells.remove(cell);
	}
	public ArrayList<Cell> getCells() {
		return cells;
	}
}

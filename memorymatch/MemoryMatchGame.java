package memorymatch;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.NotYetImplementedException;

public class MemoryMatchGame {
	private static final int X = 0;
	private static final int Y = 1;

	private static void defineWorldBoundaries() {
		// TODO: change values to a more convenient space if you so desire
		double xMin = 0.0;
		double xMax = 4.0;
		double yMin = 0.0;
		double yMax = 4.0;



		StdDraw.setXscale(xMin, xMax);
		StdDraw.setYscale(yMin, yMax);
	}

	private static double[] waitForMouseClick() {
		// wait for the mouse to be pressed
		while (!StdDraw.isMousePressed()) {
			StdDraw.pause(10);
		}
		// wait for the mouse to be released
		while (StdDraw.isMousePressed()) {
			StdDraw.pause(10);
		}
		// TODO: return the current mouse position

		// Delete the line below and implement this method
		double[] position = new double[2];
		position[X] = StdDraw.mouseX();
		position[Y] = StdDraw.mouseY();
		return position;
	}

	private static int toRow(double[] xy) {
		double y = xy[Y];
		int row = 0;
		// Delete the line below and implement this method
		for (int i = 0; i < 4; i++) {
			if (y > 0 + i && y < 1 + i) {
				row = i;
			}
		}
		return row;
	}

	private static int toColumn(double[] xy) {
		double x = xy[X];
		int column = 0;
		// Delete the line below and implement this method
		for (int j = 0; j < 4; j++) {
			if (x > 0 + j && x < 1 + j) {
				column = j;
			}
		}
		return column;
	}

	private static int[] waitForClickOnRowColumn() {
		double[] xy = waitForMouseClick();
		int r = toRow(xy);
		int c = toColumn(xy);
		return new int[] { r, c };
	}

	private static void drawBoard(Color[][] board) {
		//draw colors
		for (int i = 0; i < board.length; i++) {	
			for (int j = 0; j < board[0].length; j++) {
			StdDraw.setPenColor();
			StdDraw.filledSquare(0.5 + i, 0.5 + j, 0.4);
			}
		}
	}

	private static boolean isGameStillAlive(int matches) {
		if (matches == 8) {
			return false;
		}
		else {
			return true;
		}
	}

	public static void playGame() {
		defineWorldBoundaries();
		Color[] palette = MemoryMatchBoard.getPalette();
		Color[][] board = MemoryMatchBoard.generateShuffled4x4Board(palette);

		// Delete the line below and implement this method
		int matches = 0;
		int turns = 0;
		drawBoard(board);

		//reveals color
		while (isGameStillAlive(matches) == true) {
			//first flip
			int[] card1 = waitForClickOnRowColumn();
			StdDraw.setPenColor(Color.white);
			StdDraw.filledSquare(0.5 + card1[Y], 0.5 + card1[X], 0.4);
			StdDraw.setPenColor(board[card1[X]][card1[Y]]);
			StdDraw.filledCircle(0.5 + card1[Y], 0.5 + card1[X], 0.25);
			//second flip
			int[] card2 = waitForClickOnRowColumn();
			StdDraw.setPenColor(Color.white);
			StdDraw.filledSquare(0.5 + card2[Y], 0.5 + card2[X], 0.4);
			StdDraw.setPenColor(board[card2[X]][card2[Y]]);
			StdDraw.filledCircle(0.5 + card2[Y], 0.5 + card2[X], 0.25);
			//checks match

			if (board[card1[X]][card1[Y]] != board[card2[X]][card2[Y]]) {
				StdDraw.pause(500);
				StdDraw.setPenColor();
				StdDraw.filledSquare(0.5 + card1[Y], 0.5 + card1[X], 0.4);
				StdDraw.filledSquare(0.5 + card2[Y], 0.5 + card2[X], 0.4);
			}
			else {
				matches++;
			}
			turns++;
		}
		StdDraw.setPenColor(Color.white);
		StdDraw.filledSquare(2, 2, 2);
		StdDraw.setPenColor();
		StdDraw.text(2, 2, "It took you " + turns + " turns");
	}

	public static void main(String[] args) {
		playGame();
	}

}

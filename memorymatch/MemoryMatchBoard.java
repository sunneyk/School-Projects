package memorymatch;

import java.awt.Color;

import support.cse131.NotYetImplementedException;

public class MemoryMatchBoard {
	/**
	 * @return an array of 8 discernible colors
	 */
	public static Color[] getPalette() {
		// http://mkweb.bcgsc.ca/colorblind/img/colorblindness.palettes.v11.pdf
		Color[] palette = new Color[] {
				new Color(0, 0, 0),
				new Color(34, 113, 178),
				new Color(61, 183, 233),
				new Color(247, 72, 165),
				new Color(53, 155, 115),
				new Color(213, 94, 0),
				new Color(230, 159, 0),
				new Color(240, 228, 66)
		};
		return palette;
	}

	/**
	 * Swaps the colors located at board[aRow][aCol] and board[bRow][bCol].
	 * 
	 * Note: this mutates (changes) the contents of the specified board.
	 * 
	 * @param board the 2D array of colors
	 */
	public static void swapCells(Color[][] board, int aRow, int aCol, int bRow, int bCol) {

		// TODO
		Color temp = null;
		temp = board[aRow][aCol];
		board[aRow][aCol]= board[bRow][bCol];
		board[bRow][bCol] = temp;

	}



	/**
	 * Rearranges the colors in the specified board until they are in a reasonably
	 * random arrangement.
	 * 
	 * Note: this mutates (changes) the contents of the specified board.
	 * 
	 * @param board the 2D array of colors to shuffle
	 */
	public static void shuffle(Color[][] board) {

		// TODO
		int count = 0;
		while (count < 100) {
		int randomI = (int)(Math.random() * ((board.length))); 
		int randomJ = (int)(Math.random() * ((board[0].length)));
		int randomR = (int)(Math.random() * ((board.length))); 
		int randomC = (int)(Math.random() * ((board[0].length)));

		swapCells(board, randomI, randomJ, randomR, randomC);
		count++;
		}
	}



	/**
	 * @param palette an array of 8 Colors
	 * @return shuffled 4x4 2D array of Colors suitable for a memory match game
	 */
	public static Color[][] generateShuffled4x4Board(Color[] palette) {
		Color[][] board = new Color[4][4];
		// Delete the line below and implement this method

		int count = 0;
		
		for (int k = 0; k < palette.length; k++) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					if (board[i][j] == null && count == 0) {
						board[i][j] = palette[k];
						board[i][j + 1] = palette[k];
						count++;
					}
				}
			}
			count = 0;
		}
		shuffle(board);
		return board;
	}
}

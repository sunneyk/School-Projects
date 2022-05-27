package divinelines;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Lines {
	/**
	 * 
	 * @param x1 x coordinate of starting point
	 * @param y1 y coordinate of starting point
	 * @param x2 x coordinate of ending point
	 * @param y2 y coordinate of ending point
	 */
	public static void drawLine(double x1, double y1, double x2, double y2) {
		// FIXME -- fill in this method according to the instructions
		double dist = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
		double midY = (y2+y1)/2;
		double midX = (x2+x1)/2;
		
		StdDraw.setPenColor(Color.black);
		StdDraw.setPenRadius(0.002);
		StdDraw.point(x2, y2);
		
		if(dist < 0.005){
			
		}
		else {
		drawLine(x1, y1, midX, midY);
		drawLine(x2, y2, midX, midY);
		}
		// Note: StdDraw.show() is required to draw that which is 
		// deferred by StdDraw.enableDoubleBuffering();
		StdDraw.show();
	}

	/**
	 * Code to test the drawLine method visually
	 */
	public static void main(String[] args) {
		// uncomment the line below when you are ready to speed up the drawing
		StdDraw.enableDoubleBuffering();

		StdDraw.setPenRadius(0.002);
		//
		// Test the drawing program
		//
		drawLine(0, 0, 1, 1); // lower left to upper right
		drawLine(0, 1, 1, 0); // upper left to lower right

		//
		// Draw rectangles of decreasing width and height
		//
		for (double r = 0.25; r < 0.5; r = r + .005) {
			double s = 1 - r;
			drawLine(r, r, r, s);
			drawLine(r, s, s, s);
			drawLine(s, s, s, r);
			drawLine(s, r, r, r);
		}
		System.out.println("done drawing");
	}


}

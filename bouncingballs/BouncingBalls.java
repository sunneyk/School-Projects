package bouncingballs;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.ArgsProcessor;

public class BouncingBalls {


	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int n = ap.nextInt("How many objects?");
		int frames = ap.nextInt("How many frames will be played?");
		int count = 0;
		
		double [] x = new double[n];
		double [] y = new double[n];
		double [] xV = new double[n];
		double [] yV = new double[n];
		for (int i = 0; i < n; i++) {
			x[i] = Math.random();
			y[i] = Math.random();
			xV[i] = Math.random() * (.0005);
			yV[i] = Math.random() * (.0005);

		}
		while (count < frames) {
			StdDraw.enableDoubleBuffering();
			StdDraw.clear();
			StdDraw.setPenColor(Color.BLACK);
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					double dist = (Math.hypot(x[i] - x[j], y[i] - y[j]));
					if (dist <= 0.1){
						xV[i] = -xV[i];
						xV[j] = -xV[j];
						yV[i] = -yV[i];
						yV[j] = -yV[j];
					}	
				}
				x[i] += xV[i];
				if (x[i] > 0.95 || x[i] < 0.05) {
					xV[i] = -xV[i];
				}
				y[i] += yV[i];
				if (y[i] > 0.95 || y[i] < 0.05) {
					yV[i] = -yV[i];
				}
				StdDraw.filledCircle(x[i], y[i], 0.05);
			}
			count++;
			StdDraw.show();
		}
	}

}

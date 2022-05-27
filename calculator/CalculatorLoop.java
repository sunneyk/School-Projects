package calculator;

import support.cse131.ArgsProcessor;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class CalculatorLoop {
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		String text = ap.nextString();
		while (text != null && text.length() > 0) {
			Calculator.main(new String[] { text });
			text = ap.nextString();
		}
	}
}

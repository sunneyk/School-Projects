package calculator;

import support.cse131.ArgsProcessor;

public class Calculator {
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);

		String text = ap.nextString();
		String string1 = "";
		String string2 = "";
		int ans = 0;
		String op = "";
		int count = 0;
		String textNew = text.replaceAll(" ", "");
		
		for (int i = 0; i < textNew.length(); i++) {
			if (Character.isDigit(textNew.charAt(i)) == false) {
				op = Character.toString(textNew.charAt(i));
			}
		}
		for (int i = 0; i < textNew.length(); i++) {
			if (Character.isDigit(textNew.charAt(i)) == false) {
				count++;
			}
			else if (Character.isDigit(textNew.charAt(i)) == true && count == 0){
				string1 = string1 + (Character.toString(textNew.charAt(i)));
			}
			else {
				string2 = string2 + (Character.toString(textNew.charAt(i)));
			}
		}
		if (op.equals("+")) {
			ans = Integer.parseInt(string1) + Integer.parseInt(string2);
		}
		if (op.equals("-")) {
			ans = Integer.parseInt(string1) - Integer.parseInt(string2);
		}
		if (op.equals("*")) {
			ans = Integer.parseInt(string1) * Integer.parseInt(string2);
		}
		if (op.equals("/")) {
			ans = Integer.parseInt(string1) / Integer.parseInt(string2);
		}
		System.out.println(text + " = " + ans);
		
	}
}

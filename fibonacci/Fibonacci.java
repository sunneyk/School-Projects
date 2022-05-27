package fibonacci;

public class Fibonacci {

	/**
	 * Below copy your solution to recursive Fibonacci from studio
	 * 
	 * @param n
	 * @return the nth Fibonacci number, computed recursively
	 */
	public static int recursive(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		else {
			return recursive(n - 1) + recursive (n - 2); // FIXME
		}
	}

	/**
	 * Below write your solution to Fibonacci, using iteration
	 * 
	 * @param n
	 * @return the nth Fibonacci number, computed iteratively
	 */
	public static int iterative(int n) {
		if (n <= 1) {
			return n;
		}

		int back1 = 1;
		int back2 = 0;
		
		for (int i = 2; i <= n; i++){
			int temp = back1;
			back1 += back2;
			back2 = temp;
		}
		return back1; // FIXME

	}
}

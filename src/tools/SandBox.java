package tools;

import java.util.ArrayList;
import java.util.Arrays;

public class SandBox {
	public static long rawCounter, algoCounter;

	public static long execute(EAlgo algorithm, int number) {
		rawCounter = (int) Math.pow((int) Math.sqrt(number) + 1, 4);
		algoCounter = 0;

		long tic = System.currentTimeMillis();

		ArrayList<int[]> solutions = null;
		switch (algorithm) {
			case METHOD_1:
				solutions = method1(number);
				break;
			case METHOD_2:
				solutions = method2(number);
				break;
			case METHOD_3:
				solutions = method3(number);
				break;
			case METHOD_4:
				solutions = method4(number);
				break;
			case METHOD_5:
				solutions = method5(number);
				break;
			case METHOD_6:
				solutions = method6(number);
				break;
			default:
				break;
		}

		long toc = System.currentTimeMillis();
		
		return toc - tic;
	}
	
	public static long executeWithLog(EAlgo algorithm, int number) {
		rawCounter = (int) Math.pow((int) Math.sqrt(number) + 1, 4);
		algoCounter = 0;

		long tic = System.currentTimeMillis();

		ArrayList<int[]> solutions = null;
		switch (algorithm) {
			case METHOD_1:
				solutions = method1(number);
				break;
			case METHOD_2:
				solutions = method2(number);
				break;
			case METHOD_3:
				solutions = method3(number);
				break;
			case METHOD_4:
				solutions = method4(number);
				break;
			case METHOD_5:
				solutions = method5(number);
				break;
			case METHOD_6:
				solutions = method6(number);
				break;
			default:
				break;
		}

		long toc = System.currentTimeMillis();

		System.out.println("\nListe des solutions indépendantes (" + solutions.size() + " solutions) :");
		solutions.forEach(sol -> System.out.println(Arrays.toString(sol)));

		System.out.println("\nrawCounter: " + rawCounter + ", algoCounter: " + algoCounter + " ("
				+ String.format("%.2f", 100.0 * algoCounter / rawCounter) + "%)");
		System.out.println("Durée du calcul : " + (toc - tic) + "ms");

		return toc - tic;
	}

	/** Méthode naïve pour le calcul */
	public static ArrayList<int[]> method1(int n) {
		ArrayList<int[]> result = new ArrayList<>();

		int max = (int) Math.sqrt(n);
		for (int a = max; a >= 0; a--) {
			for (int b = max; b >= 0; b--) {
				for (int c = max; c >= 0; c--) {
					for (int d = max; d >= 0; d--) {
						algoCounter++;
						if (n == a * a + b * b + c * c + d * d)
							result.add(new int[] { a, b, c, d });
					}
				}
			}
		}

		return result;
	}

	public static ArrayList<int[]> method2(int n) {
		ArrayList<int[]> result = new ArrayList<>();

		int majA = (int) Math.sqrt(n);
		for (int a = majA; a >= 0; a--) {
			for (int b = a; b >= 0; b--) {
				for (int c = b; c >= 0; c--) {
					algoCounter++;
					double d = Math.sqrt(n - a * a - b * b - c * c);
					if (d % 1 == 0)
						result.add(new int[] { a, b, c, (int) d });
				}
			}
		}

		return result;
	}

	public static ArrayList<int[]> method3(int n) {
		ArrayList<int[]> result = new ArrayList<>();

		int majA = (int) Math.sqrt(n);
		for (int a = majA; a >= 0; a--) {
			for (int b = a; b >= 0; b--) {
				for (int c = b; c >= 0; c--) {
					algoCounter++;
					double d = Math.sqrt(n - a * a - b * b - c * c);
					if (d % 1 == 0)
						result.add(new int[] { a, b, c, (int) d });
				}
			}
		}

		return result;
	}

	public static ArrayList<int[]> method4(int n) {
		ArrayList<int[]> result = new ArrayList<>();

		int majA = (int) Math.sqrt(n);
		int minA = (int) Math.sqrt(n / 4) + 1;
		for (int a = majA; a >= minA; a--) {
			int minB = (int) Math.sqrt((n - a * a) / 3) + 1;
			for (int b = a; b >= minB; b--) {
				int minC = (int) Math.sqrt((n - a * a - b * b) / 2) + 1;
				for (int c = b; c >= minC; c--) {
					algoCounter++;
					double d = Math.sqrt(n - a * a - b * b - c * c);
					if (d % 1 == 0)
						result.add(new int[] { a, b, c, (int) d });
				}
			}
		}

		return result;
	}

	public static ArrayList<int[]> method5(int n) {
		ArrayList<int[]> result = new ArrayList<>();

		int majA = (int) Math.sqrt(n);
		int minA = (int) Math.sqrt(n / 4) + 1;
		for (int a = majA; a >= minA; a--) {
			int minB = (int) Math.sqrt((n - a * a) / 3) + 1;
			for (int b = a; b >= minB; b--) {
				int minC = (int) Math.sqrt((n - a * a - b * b) / 2) + 1;
				for (int c = b; c >= minC; c--) {
					algoCounter++;
					double d = Math.sqrt(n - a * a - b * b - c * c);
					if (d == (int) d)
						result.add(new int[] { a, b, c, (int) d });
				}
			}
		}

		return result;
	}

	/** Méthode la plus optimisée pour le calcul */
	public static ArrayList<int[]> method6(int n) {
		ArrayList<int[]> result = new ArrayList<>();

		int majA = (int) Math.sqrt(n);
		int minA = (int) Math.sqrt(n / 4) + 1;
		for (int a = majA; a >= minA; a--) {
			int majB = (int) Math.sqrt(n - a * a);
			int minB = (int) Math.sqrt((n - a * a) / 3) + 1;
			for (int b = Math.min(a, majB); b >= minB; b--) {
				int majC = (int) Math.sqrt(n - a * a - b * b);
				int minC = (int) Math.sqrt((n - a * a - b * b) / 2) + 1;
				for (int c = Math.min(b, majC); c >= minC; c--) {
					algoCounter++;
					double d = Math.sqrt(n - a * a - b * b - c * c);
					if (d == (int) d)
						result.add(new int[] { a, b, c, (int) d });
				}
			}
		}

		return result;
	}
}
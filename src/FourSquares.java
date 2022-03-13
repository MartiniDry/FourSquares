import java.util.Scanner;

import javafx.application.Application;
import tools.EAlgo;
import tools.SandBox;
import tools.Visualizer;

public class FourSquares {
	public static void main(String... args) {
		// Algorithme de Lagrange pour illustrer le théorème des quatre carrés

		int N = -1;
		System.out.print("Veuillez entrer un entier naturel non-nul : ");
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		scan.close();

		calculateSolutions(N);
//		displaySolutions(N);
	}

	public static void calculateSolutions(int number) {
		SandBox.execute(EAlgo.METHOD_6, number);
	}

	private static void displaySolutions(int number) {
		Application.launch(Visualizer.class);
	}
}
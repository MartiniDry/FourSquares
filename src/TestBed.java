import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import tools.EAlgo;
import tools.SandBox;

public class TestBed {
	static File resultsFile = new File("log/table.csv");

	public static void main(String... args) {
		int iterations = 5;
		List<Integer> values = Arrays.asList( //
				/*1000000, 500000, 400000, 300000, 250000, */200000, 160000, 120000, //
				100000, 80000, 60000, 50000, 40000, 30000, 25000, 20000, 16000, 12000, //
				10000, 8000, 6000, 5000, 4000, 3000, 2500, 2000, 1600, 1200, //
				1000, 800, 600, 500, 400, 300, 250, 200, 160, 120, //
				100);

		try (FileWriter fw = new FileWriter(resultsFile)) {
			fw.write(";");
			for (int val : values)
				fw.write(val + ";");

			fw.write("\n");
			int progress = 0;
			System.out.println(String.format("%3d", 0) + "%");
			
			for (EAlgo algo : EAlgo.values()) {
				fw.write(algo.description + ";");
				for (int val : values) {
					long durationMean = 0L;
					for (int i = 0; i < iterations; i++) {
						long duration = SandBox.execute(algo, val);
						durationMean += duration;
						System.out.print("#");
					}

					durationMean /= iterations;
					fw.write(durationMean + ";");
					progress++;
					showPercent(progress, values.size() * EAlgo.values().length);
				}
				
				fw.write("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void showPercent(long value, long total) {
		System.out.println(String.format("%3d", 100 * value / total) + "%");
	}
}
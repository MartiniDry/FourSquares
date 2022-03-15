import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import tools.EAlgo;
import tools.SandBox;

public class TestBed {

	public static void main(String... args) {
//		test_time();
		test_aiming();
	}

	public static void test_time() {
		File resultsTimeFile = new File("log/benchmark_time.csv");
		
		int iterations = 5;
		List<Integer> values = Arrays.asList( //
				/* 1000000, 500000, 400000, 300000, 250000, */200000, 160000, 120000, //
				100000, 80000, 60000, 50000, 40000, 30000, 25000, 20000, 16000, 12000, //
				10000, 8000, 6000, 5000, 4000, 3000, 2500, 2000, 1600, 1200, //
				1000, 800, 600, 500, 400, 300, 250, 200, 160, 120, //
				100);

		try (FileWriter fw = new FileWriter(resultsTimeFile)) {
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

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void test_aiming() {
		File resultsAimingFile = new File("log/benchmark_aiming.csv");

//		List<Integer> values = IntStream.range(100, 2000).boxed().collect(Collectors.toList());
		List<Integer> values = IntStream.range(10, 6000).filter(val -> val % 5 == 0).boxed().collect(Collectors.toList());
		
		try (FileWriter fw = new FileWriter(resultsAimingFile)) {
			fw.write(";");
			for (int val : values)
				fw.write(val + ";");

			fw.write("\n");
			int progress = 0;
			System.out.println(String.format("%3d", 0) + "%");
			int lastPercent = 0;

			for (EAlgo algo : EAlgo.values()) {
				fw.write(algo.description + ";");
				for (int val : values) {
					SandBox.algoCounter = 0L;
					ArrayList<int[]> solutions = null;
					switch (algo) {
						case METHOD_1:
							solutions = SandBox.method1(val);
							break;
						case METHOD_2:
							solutions = SandBox.method2(val);
							break;
						case METHOD_3:
							solutions = SandBox.method3(val);
							break;
						case METHOD_4:
							solutions = SandBox.method4(val);
							break;
						case METHOD_5:
							solutions = SandBox.method5(val);
							break;
						case METHOD_6:
							solutions = SandBox.method6(val);
							break;
						default:
							break;
					}

					fw.write((solutions.size() * 1.0 / SandBox.algoCounter) + ";");
					progress++;
					int len = values.size() * EAlgo.values().length;
					if (lastPercent != 100 * progress / len) {
						showPercent(progress, len);
						lastPercent = 100 * progress / len;
					}
				}
				
				fw.write("\n");
			}

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void showPercent(long value, long total) {
		System.out.println(String.format("%3d", 100 * value / total) + "%");
	}
}
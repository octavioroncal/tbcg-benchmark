package benchmark;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class RecursionBenchmarkRunner {

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder()
				.include(EnginesOnRecursionContextBenchmark.class.getSimpleName())
				.build();
		new Runner(opt).run();
	}
}

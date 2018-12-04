package com.hz.pojo;

import java.util.function.Function;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
//		System.out.println("cmd: " + measureSumPerf(ParallelStreams::cmdSum, 10_000_000));
//		System.out.println("seq: " + measureSumPerf(ParallelStreams::sequentialSum, 10_000_000));
//		System.out.println("par: " + measureSumPerf(ParallelStreams::parellelSum, 10_000_000));
//		System.out.println("ran: " + measureSumPerf(ParallelStreams::rangedSum, 10_000_000));
		System.out.println("prs: " + measureSumPerf(ParallelStreams::parallelRangedSum, 10_000_000L));
	}
	
	//对前n个自然数求和耗时[性能测试]
	public static long measureSumPerf(Function<Long, Long> adder, long n) {
		long fastest = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			long sum = adder.apply(n);
			long duration = (System.nanoTime() - start) / 1_000_000;
			System.out.println("Result: " + sum);
			if (duration < fastest) fastest = duration;
		}
		return fastest;
	}
}

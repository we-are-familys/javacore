package com.hz.pojo;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 *
 * @author CHUANQI.DONG
 * @version 创建时间：2018年12月4日 下午6:54:51
 * @ClassName 类名称
 * @Description 类描述
 *
 */
public class ParallelStreams {
	
	//指令式
	public static long cmdSum(long l) {
		long result = 0L;
		for (long i = 0; i < l; i++) {
			result += i;
		}
		return result;
	}

	//顺序流
	public static long sequentialSum(long l) {
		return Stream.iterate(1L, i -> i + 1).limit(l).reduce(0L, Long::sum);
	}
	
	//并行流
	public static long parellelSum(long l) {
		return Stream.iterate(1L, i -> i + 1).limit(l).parallel().reduce(0L, Long::sum);
	}
	
	//LongStream: 没有拆箱、装箱 [串行]
	public static long rangedSum(long l) {
		return LongStream.rangeClosed(1, l).reduce(0L, Long::sum);
	}
	
	//LongStream: 没有拆箱、装箱 [并行]
	public static long parallelRangedSum(long l) {
		return LongStream.rangeClosed(1, l).parallel().reduce(0L, Long::sum);
	}
	
}

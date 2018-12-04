package com.hz.pojo;

import java.util.concurrent.RecursiveTask;

/**
 * 使用分支/合并框架执行并行求和
 * @author CHUANQI.DONG
 * @version 创建时间：2018年12月4日 下午8:23:10
 * @ClassName 类名称
 * @Description 类描述
 *
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {
	
	private final long[] numbers; //子任务处理的数组
	private final int start; //子任务处理的数组的开始位置
	private final int end; //子任务处理的数组的结束位置
	
	public static final long THRESHOLD = 10_000;
	
	private ForkJoinSumCalculator(long[] numbers, int start, int end) {
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		int length = end - start;
		
		if (length <= THRESHOLD) { //条件成立则顺序计算结果
			return computeSequentially();
		}
		
		ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
		leftTask.fork();
		
		ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
		Long rightResult = rightTask.compute();
		Long leftResult = leftTask.join();
		return leftResult + rightResult;
	}
	
	private long computeSequentially(){
		long sum = 0;
		for (int i = start; i < end; i++) {
			sum += numbers[i];
		}
		return sum;
	}

}

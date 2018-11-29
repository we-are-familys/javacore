package org.java8.ch03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author CHUANQI.DONG
 * @version 创建时间：2018年11月29日 下午2:26:33
 * @ClassName 类名称
 * @Description 类描述
 *
 */
public class FunctionTest {

	public static void main(String[] args) {
		System.out.println(map(Arrays.asList("abc", "bc", "gefg"), (String s) -> s.length()));
		
		System.out.println(map(Arrays.asList("abc", "bc", "gefg"), s -> s.length()));
//		Object o = () -> {System.out.println("ABC"); return "";}; //Object 不是一个函数式接口
		Runnable r = () -> {System.out.println("ABC");};
	}
	
	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();
		for (T t : list) {
			result.add(f.apply(t));
		}
		return result;
	}
}
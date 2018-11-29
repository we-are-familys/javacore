package org.java8.ch03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 练习 Predicate 接口
 * @author CHUANQI.DONG
 * @version 创建时间：2018年11月29日 下午2:14:16
 * @ClassName 类名称
 * @Description 类描述
 *
 */
public class PredicateTest {
	
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for (T t : list) {
			if (p.test(t)) {
				result.add(t);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Predicate<String> noEmpty = (String s) -> !s.isEmpty();
		
		List<String> list = Arrays.asList("", "abc", "def");
		
		System.out.println(filter(list, noEmpty));
	}
}

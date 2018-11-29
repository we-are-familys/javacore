package org.java8.ch03;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 *
 * @author CHUANQI.DONG
 * @version 创建时间：2018年11月29日 下午9:12:41
 * @ClassName 类名称
 * @Description 类描述
 *
 */
public class 方法引用 {

	public static void main(String[] args) {
		List<String> str = Arrays.asList("a", "b", "A", "B");
		str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		//方法引用
		str.sort(String::compareToIgnoreCase);
		
		Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
		System.out.println(stringToInteger);
		stringToInteger = Integer::parseInt;
		System.out.println(stringToInteger);
		
		BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
		System.out.println(contains);
		contains = List::contains;
		System.out.println(contains);
	}
	
}

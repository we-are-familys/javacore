package com.hz.action;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author CHUANQI.DONG
 * @version 创建时间：2018年11月29日 下午9:46:23
 * @ClassName 类名称
 * @Description 类描述
 *
 */
public class Main {

	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple("green", 150), new Apple("red", 120));
		
		System.out.println("before: " + inventory);
		
//		inventory.sort(new AppleComparator());//传递代码
		
//		inventory.sort(new Comparator<Apple>() {//使用匿名类
//
//			@Override
//			public int compare(Apple a1, Apple a2) {
//				return a1.getWeight().compareTo(a2.getWeight());
//			}
//		});
		
		//Lambda表达式
//		inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
//		inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
//		inventory.sort(comparing((a) -> a.getWeight()));
		
		inventory.sort(comparing(Apple::getWeight));//方法引用 (最终解决方案)
		
		//逆序[重量逆序]
		inventory.sort(comparing(Apple::getWeight).reversed());
		//比较器链[重量相同再按颜色排序]
		inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
		
		Predicate<Apple> redApple = (a) -> "red".equals(a.getColor());
		
		Predicate<Apple> notRedApple = redApple.negate();
		Predicate<Apple> redAndHeavyApple = redApple.and((a) -> a.getWeight() > 130);
		Predicate<Apple> redAndHeavyAppleOrGreen = redApple.and(a -> a.getWeight() > 130)
				.or(a -> "green".equals(a.getColor()));
		
		
		System.out.println("after: " + inventory);
		
	}
	
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for (T t : list) {
			if (p.test(t)) {
				result.add(t);
			}
		}
		return result;
	}
}

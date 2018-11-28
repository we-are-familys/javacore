package com.hz.method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hz.filter.AppleFormatter;
import com.hz.filter.ApplePredicate;
import com.hz.filter.Predicate;
import com.hz.pojo.Apple;

/**
 *
 * @author CHUANQI.DONG
 * @version 创建时间：2018年11月28日 下午9:59:34
 * @ClassName 类名称
 * @Description 类描述
 *
 */
public class MyMethods {

	/**
	 * 常规方式筛选绿苹果(若需要筛选其他颜色的苹果则问题出来了)
	 * @param inventory
	 * @return
	 */
	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if ("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}
	
	/**
	 * 在filterGreenApples方法的基础上,将颜色作为参数传入(若希望通过重量来筛选则问题又来了)
	 * @param inventory
	 * @param color
	 * @return
	 */
	public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (apple.getColor().equals(color)) {
				result.add(apple);
			}
		}
		return result;
	}
	
	/**
	 * 筛选大于某个重量的苹果
	 * @param inventory
	 * @param color
	 * @return
	 */
	public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (apple.getWeight() > weight) {
				result.add(apple);
			}
		}
		return result;
	}
	
	/**
	 * 对每个需要筛选的属性做参数传入(再加入参数呢?会疯掉的)
	 * @param inventory
	 * @param color
	 * @param weight
	 * @param flag
	 * @return
	 */
	public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if ((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)) {
				result.add(apple);
			}
		}
		return result;
	}
	
	/*************************************** 针对以上的问题可以可以使用行为参数化来实现灵活性 **************************************/
	
	/**
	 * 相对于以上三个方法更加灵活
	 * @param inventory
	 * @param p
	 * @return
	 */
	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
	
	/**
	 * 按照一定条件打印苹果
	 */
	public static void prettyPrintApple(List<Apple> inventory, AppleFormatter p) {
		for (Apple apple : inventory) {
			System.out.println(p.accept(apple));
		}
	}
	
	/**********************************************************
	 * 上面的两个方法需要大量的实现类 过于啰嗦, 可以将上面的参数改为匿名类传递, 但是也是存在一定问题的
	 * 1、匿名类往往很笨重
	 * 2、不便于理解
	 *  ******************************************************/
	
	public static <T> List<T> filter(List<T> inventory, Predicate<T> p) {
		List<T> result = new ArrayList<T>();
		for (T t : inventory) {
			if (p.test(t)) {
				result.add(t);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		//匿名类调用
		MyMethods.filterApples(null, new ApplePredicate() {
			
			@Override
			public boolean test(Apple apple) {
				return "green".equals(apple.getColor());
			}
		});
		
		List<Apple> list = Arrays.asList(new Apple(), new Apple(), new Apple());
		
		//Lambda表达式调用
		MyMethods.filterApples(list, (Apple apple) -> "green".equals(apple.getColor()));
		
		//filterApples只适用于对Apple类型。可以继续进行抽象化
		MyMethods.filter(list, (Apple apple) -> "green".equals(apple.getColor()));
	}
	
}

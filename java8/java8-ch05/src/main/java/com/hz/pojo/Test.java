package com.hz.pojo;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 *
 * @author CHUANQI.DONG
 * @version 创建时间：2018年11月30日 下午1:01:45
 * @ClassName 类名称
 * @Description 类描述
 *
 */
public class Test {

	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(
			new Dish("port", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT),
			new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french", true, 530, Dish.Type.OTHER),
			new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season", false, 120, Dish.Type.OTHER),
			new Dish("pizza", true, 550, Dish.Type.FISH),
			new Dish("salmon", false, 450, Dish.Type.FISH)
		);
		
		System.out.println(lowCaloric(menu));
		System.out.println(lowCaloric8(menu));
		
		List<Dish> vegs = menu.stream().filter(Dish::isVegetarian).collect(toList());
		System.out.println("所有的素菜: " + vegs);
		
		List<Integer> numbers = Arrays.asList(1,2,3,3,2,4);
		//distinct: 筛选各异的元素(根据流所生成的hashCode和equals方法实现)
		numbers.stream().filter((Integer i) -> i % 2 == 0).distinct().forEach(System.out::println);
		
		//limit: 截短流
		List<Dish> dis = menu.stream().filter(d -> d.getCalories() > 300).limit(3).collect(toList());
		System.out.println(dis);
		
		//skip: 跳过元素(跳过前几个)
		dis = menu.stream().filter(d -> d.getCalories() > 300).skip(2).collect(toList());
		System.out.println(dis);
		
		
		//映射
		List<String> words = Arrays.asList("Java 8", "Lambda", "in", "action");
		List<Integer> wordLengths = words.stream().map(String::length).collect(toList());
		System.out.println(wordLengths);
		
		wordLengths = menu.stream().map(Dish::getName).map(String::length).collect(toList());
		System.out.println(wordLengths);
		
		words = Arrays.asList("Hello", "World");
		List<String[]> ws = words.stream().map(word -> word.split("")).distinct().collect(toList());
		
		String[] arrayOfWords = {"Goodbye", "World"};
		Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
		
		words.stream().map(w -> w.split("")).map(Arrays::stream).collect(toList());
		
		words = words.stream().map(w -> w.split("")).flatMap(Arrays::stream).distinct().collect(toList());
		System.out.println(words);
		
		Integer[] integer = {1,2,3,4,5};
		List<Integer> integer2 = Arrays.stream(integer).map(i -> i * i).collect(toList());
		System.out.println(integer2);
		
		List<Integer> integer01 = Arrays.asList(1,2,3);
		List<Integer> integer02 = Arrays.asList(3,4);
		List<int[]> ii = integer01.stream().flatMap(i -> integer02.stream().map(j -> new int[]{i, j})).collect(toList());
		ii = integer01.stream().flatMap(i -> integer02.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j})).collect(toList());

		//检查谓词中是否至少匹配一个元素
		if (menu.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("菜单里有素菜...");
		}
		
		//检查谓词是否匹配所有元素
		System.out.println(menu.stream().allMatch(d -> d.getCalories() < 1000));
		//检查谓词中没有任何元素匹配
		System.out.println(menu.stream().noneMatch(d -> d.getCalories() > 1000));
		
		//查找一道素菜
		//Optional: 容器类
		Optional<Dish> optional = menu.stream().filter(Dish::isVegetarian).findAny();
		System.out.println("optional: " + optional);
		
		menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(d -> System.out.println(d.getName()));
		
		Integer[] ns = {1,2,3,4,5,6,7,8,9};
		
		int sum = 0;
		for (int x : ns) {
			sum += x;
		}
		System.out.println(sum);
		sum = 0;
		sum = Arrays.stream(ns).reduce(0, (a, b) -> a + b);
//		sum = Arrays.stream(ns).reduce(0, (a, b) -> a * b);
		System.out.println(sum);
		
		//看看流中有多少道菜
		System.out.println(menu.size());
		System.out.println(menu.stream().map(d -> 1).reduce(Integer::sum));
		System.out.println(menu.stream().count());
		
	}
	
	//Java7
	public static List<String> lowCaloric(List<Dish> menu){
		List<Dish> lowCaloricDishes = new ArrayList<>();
		for (Dish d :menu) {
			if (d.getCalories() < 400) {
				lowCaloricDishes.add(d);
			}
		}
		
		Collections.sort(lowCaloricDishes, new Comparator<Dish>() {

			@Override
			public int compare(Dish d1, Dish d2) {
				return Integer.compare(d1.getCalories(), d2.getCalories());
			}
		});
		
		List<String> lowCaloricDishesName = new ArrayList<>();
		for (Dish d : lowCaloricDishes) {
			lowCaloricDishesName.add(d.getName());
		}
		
		return lowCaloricDishesName;
	}
	
	//Java8
	public static List<String> lowCaloric8(List<Dish> menu){
		List<String> lowCaloricDishesName = menu.parallelStream() //多核处理
				//menu.stream() //单核处理
				.filter(d -> d.getCalories() < 400)
				.sorted(comparing(Dish::getCalories))
				.map(Dish::getName)
				.collect(toList());
		return lowCaloricDishesName;
	}
}

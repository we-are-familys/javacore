package com.hz.pojo;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

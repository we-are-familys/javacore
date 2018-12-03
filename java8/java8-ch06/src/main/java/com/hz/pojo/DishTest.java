package com.hz.pojo;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

/**
 * 菜单测试类
 * @author CHUANQI.DONG
 * @version 创建时间：2018年12月3日 下午1:42:28
 * @ClassName 类名称
 * @Description 类描述
 *
 */
public class DishTest {
	List<Dish> menu = null;

	@Before
	public void test() {
		menu = Arrays.asList(new Dish("port", false, 800, Dish.Type.MEAT), new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT), new Dish("french", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER), new Dish("season", false, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));
	}
	
	//连接字符串
	@Test
	public void test5(){
		String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining());
		System.out.println(shortMenu);
		
		shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining(","));
		System.out.println(shortMenu);
	}
	
	//最大值、最小值、和、平均值、流个数
	@Test
	public void test4(){
		IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
		System.out.println(menuStatistics + " : " + menuStatistics.getCount());
	}
	
	//求和/求平均值
	@Test
	public void test3() {
		int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
		System.out.println(totalCalories);
		
		double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
		System.out.println(avgCalories);
	}
	
	//菜单中热量最高的菜[流的最大值]
	@Test
	public void test2() {
		Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
		Optional<Dish> mostCalorieDish = menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));
		System.out.println(mostCalorieDish);
	}
	
	//看看菜单有几种菜[流的数量]
	@Test
	public void test1(){
		Long count = menu.stream().collect(Collectors.counting());
		
		count = menu.stream().count();
		
		System.out.println(count);
	}

}

package org.java8.ch03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * 
 * @author CHUANQI.DONG
 * @version 创建时间：2018年11月29日 下午2:21:30
 * @ClassName 类名称
 * @Description 类描述
 *
 */
public class ConsumerTest {

	public static void main(String[] args) {
		forEach(Arrays.asList(1,2,3,4,5,6), (Integer i) -> System.out.println(i));
		
		System.out.println("----------------------------------------");
		
		forEach(Arrays.asList(1,2,3,4,5,6), (Integer i) -> System.out.println(2 * i));
		
	}
	
	public static <T> void forEach(List<T> list, Consumer<T> c) {
		for (T t : list) {
			c.accept(t);
		}
	}
}

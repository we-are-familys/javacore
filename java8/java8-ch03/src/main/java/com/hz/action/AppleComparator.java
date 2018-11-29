package com.hz.action;

import java.util.Comparator;

/**
 * 按照Apple的重量来排序【一种排序策略】
 * @author CHUANQI.DONG
 * @version 创建时间：2018年11月29日 下午9:44:32
 * @ClassName 类名称
 * @Description 类描述
 *
 */
public class AppleComparator implements Comparator<Apple> {

	@Override
	public int compare(Apple a1, Apple a2) {
		return a1.getWeight().compareTo(a2.getWeight());
	}

}

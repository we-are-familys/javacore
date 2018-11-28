package com.hz.filter;

import com.hz.pojo.Apple;

/**
 *
 * @author CHUANQI.DONG
 * @version 创建时间：2018年11月28日 下午10:38:42
 * @ClassName 类名称
 * @Description 类描述
 *
 */
public class AppleRedAndHeavyPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return "red".equals(apple.getColor()) && apple.getWeight() > 150;
	}

}

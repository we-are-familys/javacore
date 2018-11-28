package com.hz.filter;

import com.hz.pojo.Apple;

/**
 * 筛选绿色的苹果
 * @author CHUANQI.DONG
 * @version 创建时间：2018年11月28日 下午10:33:16
 * @ClassName 类名称
 * @Description 类描述
 *
 */
public class AppleGreenColorPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return "green".equals(apple.getColor());
	}

}

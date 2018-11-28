package com.hz.filter;

import com.hz.pojo.Apple;

/**
 * 根据重量筛选
 * @author CHUANQI.DONG
 * @version 创建时间：2018年11月28日 下午10:31:53
 * @ClassName 类名称
 * @Description 类描述
 *
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return apple.getWeight() > 150;
	}

}

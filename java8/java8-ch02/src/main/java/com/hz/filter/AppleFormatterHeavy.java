package com.hz.filter;

import com.hz.pojo.Apple;

/**
 *
 * @author CHUANQI.DONG
 * @version 创建时间：2018年11月28日 下午10:48:17
 * @ClassName 类名称
 * @Description 类描述
 *
 */
public class AppleFormatterHeavy implements AppleFormatter {

	@Override
	public String accept(Apple apple) {
		return apple.getWeight() > 150 ? apple.toString() : null;
	}

}

package com.hz.filter;

import com.hz.pojo.Apple;

/**
 * 选择标准建模
 * @author CHUANQI.DONG
 * @version 创建时间：2018年11月28日 下午10:29:43
 * @ClassName 类名称
 * @Description 类描述
 *
 */
public interface ApplePredicate {

	//可以称之为-谓词(返回一个boolean值的函数)
	boolean test(Apple apple);
}

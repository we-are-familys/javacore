package com.hz.filter;

/**
 *
 * @author CHUANQI.DONG
 * @version 创建时间：2018年11月28日 下午11:03:35
 * @ClassName 类名称
 * @Description 类描述
 *
 */
public interface Predicate<T> {

	boolean test(T t);
}

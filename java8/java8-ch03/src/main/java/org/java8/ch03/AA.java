package org.java8.ch03;

/**
 *
 * @author CHUANQI.DONG
 * @version 创建时间：2018年11月29日 下午10:08:42
 * @ClassName 类名称
 * @Description 类描述
 *
 */
@FunctionalInterface
public interface AA {

	void test();
	
	default void test2(){}
}

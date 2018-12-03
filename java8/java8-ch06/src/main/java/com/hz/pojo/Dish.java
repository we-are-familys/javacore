package com.hz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 菜肴
 * @author CHUANQI.DONG
 * @version 创建时间：2018年11月30日 下午12:59:11
 * @ClassName 类名称
 * @Description 类描述
 *
 */
@Data
@AllArgsConstructor
public class Dish {
	enum Type {
		FISH, OTHER, MEAT
	}

	private final String name;
	private final boolean vegetarian;
	//热量(卡路里)
	private final int calories;
	private final Type type;
	
}

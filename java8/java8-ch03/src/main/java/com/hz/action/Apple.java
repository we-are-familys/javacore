package com.hz.action;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 对多个Apple进行排序【不同的排序策略】
 * @author CHUANQI.DONG
 * @version 创建时间：2018年11月29日 下午9:41:45
 * @ClassName 类名称
 * @Description 类描述
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apple {

	private String color;
	private Integer weight;
}

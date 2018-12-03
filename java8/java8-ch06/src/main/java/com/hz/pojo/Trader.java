package com.hz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 交易员
 * @author CHUANQI.DONG
 * @version 创建时间：2018年12月2日 上午9:49:03
 * @ClassName 类名称
 * @Description 类描述
 *
 */
@Data
@AllArgsConstructor
public class Trader {

	private final String name;
	private final String city;
}

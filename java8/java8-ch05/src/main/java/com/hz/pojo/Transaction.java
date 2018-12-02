package com.hz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 交易
 * @author CHUANQI.DONG
 * @version 创建时间：2018年12月2日 上午9:50:38
 * @ClassName 类名称
 * @Description 类描述
 *
 */
@Data
@AllArgsConstructor
public class Transaction {

	private final Trader trader;
	private final int year;
	private final int value;
}

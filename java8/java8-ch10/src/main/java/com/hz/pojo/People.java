package com.hz.pojo;

import java.util.Optional;

import lombok.Data;

/**
 * 人类
 * @author CHUANQI.DONG
 * @version 创建时间：2018年12月5日 下午9:33:55
 * @ClassName 类名称
 * @Description 类描述
 *
 */
@Data
public class People {

	private Car car;
	
//	private Optional<Car> optionalCar = Optional.of(car); //依据一个非空值创建
//	private Optional<Car> optionalCar = Optional.ofNullable(car); //可接受null的Optional
	private Optional<Car> optionalCar = Optional.empty(); //创建一个空的Optional对象
		
}

package com.hz.pojo;

import java.util.Optional;

import lombok.Data;

/**
 * 车类
 * @author CHUANQI.DONG
 * @version 创建时间：2018年12月5日 下午9:33:19
 * @ClassName 类名称
 * @Description 类描述
 *
 */
@Data
public class Car {

	private Insurance insurance;
	
	private Optional<Insurance> optionalInsurance = Optional.ofNullable(insurance);
	private Optional<String> name = optionalInsurance.map(Insurance::getName);
}

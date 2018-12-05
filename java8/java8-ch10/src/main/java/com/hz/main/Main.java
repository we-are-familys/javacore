package com.hz.main;

import java.util.Optional;

import org.junit.Test;

import com.hz.pojo.Car;
import com.hz.pojo.Insurance;
import com.hz.pojo.People;

/**
 * 测试主类[Optional若作为类的一个属性,则该类不可序列化,若必须序列化可以用一个方法返回一个Optional对象]
 * @author CHUANQI.DONG
 * @version 创建时间：2018年12月5日 下午9:34:30
 * @ClassName 类名称
 * @Description 类描述
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
	}

	@Test
	public void test() {
//		People p = 
//		String 
	}
	
	public String getCarInsuranceName(People people) { //大概率出现【空异常】
		return people.getCar().getInsurance().getName();
	}
	
	public String getCarInsuranceName2(People people) { //对每一步都进行null检测
		if (people != null) {
			Car car = people.getCar();
			if (car != null) {
				Insurance insurance = car.getInsurance();
				if (insurance != null) {
					return insurance.getName();
				}
			}
		}
		return "Unknown";
	}
	
	public String getCarInsuranceName3(People people) {
		if (people == null) {
			return "Unknown";
		}
		Car car = people.getCar();
		if (car == null) {
			return "Unknown";
		}
		Insurance insurance = car.getInsurance();
		if (insurance == null) {
			return "Unknown";
		}
		return insurance.getName();
	}
	
	public String getCarInsuranceName4(People people) {
		Optional<People> optPeople = Optional.of(people);
//		Optional<String> name = optPeople.map(People::getOptionalCar).map(Car::getOptionalInsurance).map(Insurance::getName);
//		return name.get();
		return optPeople.flatMap(People::getOptionalCar).flatMap(Car::getOptionalInsurance).map(Insurance::getName).orElse("Unknown");
	}
}

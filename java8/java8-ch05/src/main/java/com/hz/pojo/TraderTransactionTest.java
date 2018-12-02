package com.hz.pojo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Before;

/**
 * 交易员-交易测试类
 * @author CHUANQI.DONG
 * @version 创建时间：2018年12月2日 上午9:52:01
 * @ClassName 类名称
 * @Description 类描述
 *
 */
public class TraderTransactionTest {
	
	List<Transaction> transactions = null;
//	List<Trader> traders = null;

	@Before
	public void beforeTest(){
		Trader zhangsan = new Trader("zhangsan", "shanghai");
		Trader lisi = new Trader("lisi", "beijing");
		Trader wangwu = new Trader("wangwu", "shanghai");
		Trader zhaoliu = new Trader("zhaoliu", "shanghai");
		
//		traders = Arrays.asList(zhangsan, lisi, wangwu, zhaoliu);
		
		transactions = Arrays.asList(
			new Transaction(zhaoliu, 2011, 300),
			new Transaction(zhangsan, 2012, 1000),
			new Transaction(zhangsan, 2011, 400),
			new Transaction(lisi, 2012, 710),
			new Transaction(lisi, 2012, 700),
			new Transaction(wangwu, 2012, 950)
		);
	}
	
	//2011年发生的交易,按照交易额排序
	@org.junit.Test
	public void test1(){
		List<Transaction> l = transactions.stream().filter(t -> t.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue))
				.collect(Collectors.toList());
		System.out.println(l);
	}
	
	//交易员都在哪些不同的城市工作过
	@org.junit.Test
	public void test2(){
//		traders.stream().map(Trader::getCity).distinct().forEach(s -> System.out.print(s + "\t"));
		transactions.stream().map(t -> t.getTrader().getCity()).distinct().forEach(s -> System.out.print(s + "\t"));
	}
	
	//找出来自上海的交易员,按照名字排序
	@org.junit.Test
	public void test3(){
//		List<Trader> l = traders.stream()
//				.filter(t -> "shanghai".equals(t.getCity()))
//				.sorted(Comparator.comparing(Trader::getName))
//				.collect(Collectors.toList());
		List<Trader> l = transactions.stream().map(Transaction::getTrader)
			.filter(t -> "shanghai".equals(t.getCity()))
			.distinct()
			.sorted(Comparator.comparing(Trader::getName))
			.collect(Collectors.toList());
		System.out.println(l);
	}
	
	//返回交易员姓名字符串,并按照字母顺排序
	@org.junit.Test
	public void test4(){
		String traderStr = transactions.stream().map(t -> t.getTrader().getName())
			.distinct()
			.sorted()
			.reduce("", (n1, n2) -> n1 + n2);
		
		traderStr = transactions.stream().map(t -> t.getTrader().getName())
			.distinct()
			.sorted()
			.collect(Collectors.joining());
		
		System.out.println(traderStr);
	}
	
	//有没有交易员在上海工作
	@org.junit.Test
	public void test5(){
		transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("shanghai"));
	}
	
	//生活在上海的交易员的所有交易额
	@org.junit.Test
	public void test6(){
		transactions.stream().filter(t -> "shanghai".equals(t.getTrader().getCity()))
			.map(Transaction::getValue)
			.forEach(v -> System.out.print(v + "\t"));
	}
	
	//所有交易中,最高的交易额是多少
	@org.junit.Test
	public void test7(){
		Optional<Integer> o = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
		System.out.println(o);
	}
	
	//找到交易额最小的交易
	@org.junit.Test
	public void test8(){
		Optional<Integer> o = transactions.stream().map(Transaction::getValue).reduce(Integer::min);
		System.out.println(o);
		
		Optional<Transaction> ot = transactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
		System.out.println(ot);
		
		ot = transactions.stream().min(Comparator.comparing(Transaction::getValue));
		System.out.println(ot);
		
	}
	
}

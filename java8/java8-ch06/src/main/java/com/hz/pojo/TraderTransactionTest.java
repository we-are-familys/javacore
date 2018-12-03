package com.hz.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

/**
 * 交易员-交易测试类
 * 
 * @author CHUANQI.DONG
 * @version 创建时间：2018年12月2日 上午9:52:01
 * @ClassName 类名称
 * @Description 类描述
 *
 */
public class TraderTransactionTest {

	List<Transaction> transactions = null;

	@Before
	public void beforeTest() {
		Trader zhangsan = new Trader("zhangsan", "shanghai");
		Trader lisi = new Trader("lisi", "beijing");
		Trader wangwu = new Trader("wangwu", "shanghai");
		Trader zhaoliu = new Trader("zhaoliu", "shanghai");

		transactions = Arrays.asList(new Transaction(zhaoliu, 2011, 300, Currency.getInstance(Locale.CHINA)),
				new Transaction(zhangsan, 2012, 1000, Currency.getInstance(Locale.CHINA)),
				new Transaction(zhangsan, 2011, 400, Currency.getInstance(Locale.US)),
				new Transaction(lisi, 2012, 710, Currency.getInstance(Locale.US)),
				new Transaction(lisi, 2012, 700, Currency.getInstance(Locale.UK)),
				new Transaction(wangwu, 2012, 950, Currency.getInstance(Locale.UK)));
	}

	// 对交易按照货币进行分组[Java8]
	@Test
	public void test2() {
		Map<Currency, List<Transaction>> map = transactions.stream()
				.collect(Collectors.groupingBy(Transaction::getCurrency));
		System.out.println(map);
	}

	// 对交易按照货币进行分组[使用指令式风格-Java7]
	@Test
	public void test1() {
		Map<java.util.Currency, List<Transaction>> transactionByCurrencies = new HashMap<>();

		for (Transaction transaction : transactions) {
			java.util.Currency currency = transaction.getCurrency();

			List<Transaction> transactionsForCurrency = transactionByCurrencies.get(currency);

			if (transactionsForCurrency == null) {
				transactionsForCurrency = new ArrayList<>();
				transactionByCurrencies.put(currency, transactionsForCurrency);
			}
			transactionsForCurrency.add(transaction);
		}

		System.out.println(transactionByCurrencies);
	}

}

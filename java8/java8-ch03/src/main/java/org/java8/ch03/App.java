package org.java8.ch03;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
//		System.out.println("Hello World!");
		
		Runnable r1 = () -> System.out.println("Hello World 1");
		
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello World 2");
			}
		};
		
		process(r1); //行为参数化
		process(r2); //匿名类方式
		
		process(() -> System.out.println("Hello World 3")); //
		
		System.out.println("--------------------------------------------------------");
		//环绕执行模式
		try {
			String lineone = processFile((BufferedReader br) -> br.readLine());
			String linetwo = processFile((BufferedReader br) -> br.readLine() + "\n" + br.readLine());
			
			System.out.println(lineone);
			System.out.println();
			System.out.println(linetwo);
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	
	// 1
	public static String processFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("data.txt"));
			return br.readLine();
		} catch (Exception e) {
			return null;
		}
	}
	
	//3
	public static String processFile(BufferedReaderProcessor b) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("data.txt"));
		return b.process(br);
	}
	
	public static void process(Runnable r) {
		r.run();
	}
}

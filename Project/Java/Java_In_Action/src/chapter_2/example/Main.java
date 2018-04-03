package chapter_2.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {
	public static void main(String[] args) {
		List<Integer> weights = Arrays.asList(7, 3 , 4 , 10);
		List<String> result = map(weights, String::new);
		
		System.out.println(result);
	}
	
	public static List<String> map(List<Integer> list,
			Function<Integer, String> f) {
		List<String> test = new ArrayList<>();
		for(Integer a : list) {
			test.add(a);
		}
		return test;
	}
}

interface Test {
	public int test(int a, int b);
}

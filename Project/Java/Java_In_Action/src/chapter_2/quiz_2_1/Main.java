package chapter_2.quiz_2_1;

import java.util.Arrays;
import java.util.List;

import chapter_2.Apple;
import chapter_2.AppleHeavyWeightPredicate;

public class Main {
	public static void main(String[] args) {
		List<Apple> apples = Arrays.asList(
				new Apple(500, 9, "green"),
				new Apple(120, 1, "red"),
				new Apple(30, 50, "blue")
		);
		
		prettyPrintApple(apples, new PrettyGood());
	
	}
	
	public static void prettyPrintApple(List<Apple> inventory, PrettyPredicate p) {
		for(Apple apple : inventory) {
			String output = p.process(apple);
			System.out.println(output);
		}
	}
}

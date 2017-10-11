package chapter_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Apple> apples = Arrays.asList(
				new Apple(500, 9, "green"),
				new Apple(120, 1, "red"),
				new Apple(30, 50, "blue")
		);
		
		List<Apple> weightApple = filterApples(apples, new AppleHeavyWeightPredicate());
	
	}
	
	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
		List<Apple> result = new ArrayList<>();
		
		for(Apple apple : inventory) {
			if(p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
}

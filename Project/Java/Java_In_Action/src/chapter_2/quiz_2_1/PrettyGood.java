package chapter_2.quiz_2_1;

import chapter_2.Apple;

public class PrettyGood implements PrettyPredicate {

	@Override
	public String process(Apple apple) {
		return "사과 무게 : "+apple.getWeight();
	}
	
}

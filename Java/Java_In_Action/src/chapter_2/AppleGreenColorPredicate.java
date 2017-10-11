package chapter_2;

public class AppleGreenColorPredicate implements ApplePredicate{

	@Override
	public boolean test(Apple apple) {
		return "green".equals(apple.getType());
	}	
}

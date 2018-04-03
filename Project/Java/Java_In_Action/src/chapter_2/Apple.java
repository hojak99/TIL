package chapter_2;

public class Apple {
	
	private int weight;
	private int count;
	private String type;
	
	public Apple(int weight, int count, String type) {
		this.weight = weight;
		this.count = count;
		this.type = type;
	}
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}

import java.util.*;

/*
 * 개구리가 X 위치에 있으며 Y보다 크거나 같은 위치로 가고 싶어한다. 개구리는 항상 고정된 D 거리 만큼 점프한다.
 * 개구리가 점프할 수 있는 최소 횟수를 구하세용
 * 
 * 풀이 :
 * 이번 문제는 쉬웠다. 
 * 우선 Y-X 를 이용해 거리를 구하고, 거기서 그냥 점프할 수 있는 D 거리를 나누어주면 해결되지만 만약 소수점이 나왔을 시에
 * 버림하므로 Math.ceil() 메소드를 이용해서 항상 올림하도록 한다. 해결~
 * */

public class FrogJmp {
	public static void main(String[] args) {
		System.out.println(solution(1,6,3));
	}
	
	public static int solution(int X, int Y, int D){
		return (int) Math.ceil((Y-X) / (double)D);
	}
}

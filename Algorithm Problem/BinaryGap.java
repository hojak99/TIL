import java.util.*;

public class BinaryGap {
	public static void main(String[] args){
		System.out.println(solution(561892));
	}
	
	public static int solution(int N){
		
		String binaryString = Integer.toBinaryString(N);
		char[] binaryToChar = binaryString.toCharArray();
		
		
		int tempLen = 0;
		int maxLen = 0;
		
		
		// 10001001001011100100
		for(char a : binaryToChar){
			if(String.valueOf(a).equals("1")){
				if(tempLen >= maxLen){
					maxLen = tempLen;
					tempLen = 0;
				}else{
					tempLen =0;
				}
			}else{
				tempLen += 1;
			}
		}
		
		return maxLen;
	}
}

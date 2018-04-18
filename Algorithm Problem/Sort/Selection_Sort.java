import java.util.Scanner;

/**
 * Selection sort 
 * 
 * 주어진 리스트 중에 최솟값을 찾아 맨 앞에 위치한 값과 교체 후 그 위치를 제외하고 리스트를 같은 방법으로 교체하는 방식
 * 시간복잡도 : O n제곱 
 * 
 * @author KwonJH
 * @since 2018.04.17
 */

public class Main {

	public static void main(String[] args) {
		
		int arr[] = {9, 1, 4, 6, 7, 2, 3, 4, 5, 5};
			
		for(int i=0; i<arr.length-1; ++i) {
			
			int tempResult = arr[i];
			int count = 0;
			
			for(int q = i+1; q<arr.length; ++q) {
				if(tempResult > arr[q]) {
					tempResult = arr[q];
					count = q;
				}
			}
			
			int tmp;
			tmp = arr[i];
			arr[i] = tempResult;
			arr[count] = tmp;
		}
		

		for(int temp : arr){
			System.out.print(temp +" ");
		}	
	}
}

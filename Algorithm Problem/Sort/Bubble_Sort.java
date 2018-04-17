import java.util.Scanner;

/**
 * Bubble sort 
 * 
 * 두 인접한 원소를 검사하여 정렬하는 방법
 * 시간복잡도 : O n제곱 
 * 
 * @author KwonJH
 * @since 2018.03.29
 */

public class Main {

	public static void main(String[] args) {
		
		int arr[] = {9, 1, 4, 6, 7, 2, 3, 4, 5, 5};
		
		// 오름차순
		for(int i = 0; i < arr.length; ++i) {
			for(int q = 0; q< arr.length-1; ++q){
				if(arr[q] > arr[q+1]) {
					int temp = arr[q];
					arr[q] = arr[q+1];
					arr[q+1] = temp;	
				}
			}
		}
		
		for(int temp : arr){
			System.out.print(temp +" ");
		}	
	}
}

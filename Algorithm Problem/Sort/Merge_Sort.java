import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 그래프 : 인접행렬
 * @author KwonJH
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] arr = {7 , 4, 5, 7, 1,9, 6, 5, 9, 8};
		
		merge(arr, 0, arr.length-1);
	}
	
	public static void merge(int []arr, int left, int right) {
		int middle;
		if(left < right) {
			middle = (left + right) / 2;
			
			merge(arr, left, middle, "left");
			merge(arr, middle+1, right, "right");
			
			mergeSort(arr, left, middle, right, "");
		}
	}
	
	public static void merge(int []arr, int left, int right, String str) {
		int middle;
		if(left < right) {
			middle = (left + right) / 2;
			
			merge(arr, left, middle, str);
			merge(arr, middle+1, right, str);
			
			mergeSort(arr, left, middle, right, str);
		}
	}
	
	public static void mergeSort(int []arr, int left, int middle, int right, String str) {
		int tempLeft = left;
		int tempMiddle = middle+1;
		int tl = left;
		
		int[] temp = new int[arr.length];
		
		while(tempLeft <= middle && tempMiddle <= right) {
			if(arr[tempLeft] <= arr[tempMiddle]) {
				temp[tl++] = arr[tempLeft++]; 
			} else {
				temp[tl++] = arr[tempMiddle++];
			}
		}
		
		while(tempLeft <= middle) 
			temp[tl++] = arr[tempLeft++];
		while(tempMiddle <= right)
			temp[tl++] = arr[tempMiddle++];
		
		for(int i = left; i<tl; ++i) {
			arr[i] = temp[i];
		}
		System.out.println(left +" " + middle + " " + right + " " + str);
		printArray(arr, str);
	}
	
	public static void printArray(int arr[], String str) {
		for( int i=0; i<arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("  : "+ str);
	}
}

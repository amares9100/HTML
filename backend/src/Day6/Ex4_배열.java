package Day6;

public class Ex4_배열 {
	public static void main(String[] args) {
		int sum = 0;
		
		int[] score = {20, 30, 40, 50, 66, 4, 99, 54, 32, 67};
		for(int i = 0 ; i <10 ; i++) {
			sum += score[i];
		}
		int avg = sum/10;
		System.out.println(avg);
		
		int[] scores;
		scores = new int[] {83, 90, 87};
		int sum1 = 0;
		
		for(int i=0 ; i < 3 ; i++) {
			sum1 += scores[i];
			
		}
		
		System.out.println("총합 : "+sum1);
		
		printItem( new int[] {83, 90, 87});
		
	}
	
	public static void printItem(int[] scores) {
		for(int i = 0 ; i < 3 ; i++) {
			System.out.println("scores["+i+"]"+ scores[i]);
		}
		xy(new int[] {90, 80, 70}); // 함수xy에 배열 생성 - int 배열내 값 : 90, 80, 70
		
	}
	public static void xy(int[] T) { // xy배열를 선언하고 xy의 int[]을 T로 가져옴  => T는 배열 T = {90,80,70}
		for(int i = 0 ; i < 3 ; i++) {
			System.out.println(T[i]); // 불러온 값을 호출
		}
		int[] array = new int[4];
		for(int p = 0 ; p <4 ; p++) {
			array[p] = p;
			
			System.out.println(array[p]);
		}
		
		array[0] = 90;
		array[1] = 70;
		array[2] = 550;
		array[3] = 60;
		
		for(int i = 0 ; i < array.length ; i++) {
			System.out.println(array[i]);
		}
		
		double[] arr2 = new double[4];
		
		for(int i = 0 ; i < 4 ; i++) {
			System.out.println(arr2[i]); // 기본값 출력 - 0.0 x 4
		}
		
		
		arr2[0] = 0.2;
		arr2[1] = 0.4;
		arr2[2] = 0.6;
		arr2[3] = 0.8;
		
		// ex1
		for(int i = 0 ; i <arr2.length ; i++) {
			System.out.println(arr2[i]);
		}
		// ex2
		for(double value : arr2) {
			System.out.println(value);
		}
		// ex1과 ex2는 같은뜻
		
		
		// 다차원 배열
		int[][] arr3 = {
				{1 , 2 , 3 , 4}, // 0차원 배열
				{10, 20, 30, 40} // 1차원 배열
				};
		System.out.println(arr3[1][3]); // 1차원 배열의 인덱스3을 출력
		
		}
}
		
		
	

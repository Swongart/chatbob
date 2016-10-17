package array;

public class Array2 {
	public static void main(String[] args){
		int[] arr = new int[50];
		System.out.println("First Array");
		fifty(arr);
		System.out.println("Second Array");
		random(arr);
	}
	
	private static void fifty(int[] a){
		for(int i = 0; i<a.length; i++){
			a[i] = (i+1);
		}
		for(int s: a){
			System.out.println(s);
		}
	}
	
	private static void random(int[] a){
		
		for(int i = 0; i<a.length; i++){
			double rand = Math.random(); 
			int roll = (int) (50 * rand); 
			a[i] = roll;
		}
		for(int s: a){
			System.out.println(s);
		}
	}
}

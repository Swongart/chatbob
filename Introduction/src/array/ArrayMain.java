package array;

public class ArrayMain {
	
	public static void main(String[] args){
		//This is how you time how quickly the computer processes
		long startTime = System.currentTimeMillis();
		arrayIntroMethod();
		long endTime = System.currentTimeMillis();
		System.out.println("Completed method in " + (endTime-startTime) + " milliseconds");
	}
	
	public static void arrayIntroMethod(){
		// construct 3 interger arrays
				//these two methods are the same thing
				//primitive type array are filled with ZEROES 0,0,0 false
				int[] zeros1 = {0,0,0};
				int[] zeros2 = new int [3];
				//example
				boolean[] booleans = new boolean[3];
				//iterate (two ways)
				//WHEN TO USE THIS FOR LOOP **for loop**
				//	- the index of the data is important to reference
				//	- you need to customize how you iterate
				//	- (increase by 2, backwards, etc.)
				for(int i=0; i<booleans.length; i++){
					System.out.println( i + ") " + booleans[i]);
				}
				//SECOND METHOD **for each**
				// always goes in order, does not keep track of index
				//easier to type
				for(boolean b: booleans){
					System.out.println(b + "");
				}
				
				//these two constructors are different
				String[] strings1 = {"", "", ""};
				String[] strings2 = new String[3];
				
				for(String s: strings1){
					System.out.println(s);
				}
				for(String s: strings2){
					System.out.println(s);
				}
	}
}
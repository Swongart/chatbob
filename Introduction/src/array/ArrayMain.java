package array;

public class ArrayMain {
	//PASS BY VALUE
	public static void main(String[] args){ 
		//This is how you time how quickly the computer processes
		long startTime = System.currentTimeMillis();
		String[] someStrings = new String[100];
		populateArray(someStrings);
		
		changeString(someStrings[99]);
		
		printArray(someStrings);
		//arrayIntroMethod();
		long endTime = System.currentTimeMillis();
		System.out.println("Completed method in " + (endTime-startTime) + " milliseconds");
	}
	
	private static void changeString(String s) {
		// TODO Auto-generated method stub
		s = "This string has been changed";
	}

	private static void printArray(String[] a) {
		// TODO Auto-generated method stub
		for(String s: a){
			System.out.println(s);
		}
	}

	private static void populateArray(String[] a) {
		// TODO Auto-generated method stub
		for(int i = 0; i<a.length; i++){
			a[i] = "value " + (i+1);
		}
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
				
				for(int i = 0; i<strings2.length; i++){
					strings2[i] = "value " + (i+1);
				}
				
				
				for(String s: strings1){
					System.out.println(s);
				}
				
				//this loop prints the string
				for(String s: strings2){
					System.out.println(s);
				}
	}
}
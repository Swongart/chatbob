package array;
	
	import java.util.Scanner;

public class LoginProgram {
	
	static Scanner input = new Scanner(System.in);
	
	public static String waitForEntry(){
		return input.nextLine();
	}
	//1 point for "private" or inaccessible
	//1 point for declaration of data type
	private static String username = "test_user";
	private static String password = "test";
	
	//1 point correct method header
	public static void main(String[] args){
		//1 point, user has one chance to enter name
		if(correctUser()){
			askPassword();
		}
		else {
			System.out.println("Unknown username. Please contact network administrator.");
		}
	}

	private static void askPassword() {
		boolean inLoop = true;
		int remainTries = 3;
		// 1 point, using a loop
		while (inLoop){
			System.out.println("Enter your password.");
			String entry = waitForEntry();
			if(entry.equals(password)){
				System.out.println("You are in!");
				inLoop=false;
			}
			else{
				remainTries--;
				if(remainTries == 0){
					System.out.println("invalid password.");
					inLoop = false;
				}
				else{
					System.out.println("Incorrect password. You have "+remainTries+" tries left.");
				}
			}
		}
	}

	private static boolean correctUser() {
		System.out.println("Enter username.");
		//1 point for using .equals
		if(waitForEntry().equals(username)){
			return true;
		}
		return false;
	}
}

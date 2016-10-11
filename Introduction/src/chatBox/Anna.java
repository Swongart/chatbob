package chatBox;

import java.util.Scanner;

public class Anna {

	static Scanner input;
	static String user;
	//static int lineCount;
	static boolean inLoop;
	static String response;
	static Topic school;
	static Topic like;
	static Topic hello;
	
	public static void main (String[] args){
		createTopic();
		//lineCount = 0;
		//demonstrateStringMethods();
		promptName();
		talkForever();
	}
	
	private static void promptName() {
		print("Hello human! I am a board covered with semi conductors and other such electronic components. What is your name?");
		user = input.nextLine();
		print("Awesome, I will call you " + user + " until you terminate me!");
	}

	public static void talkForever(){
		inLoop = true;
		while(inLoop){
				print("Greetings, " + user + ". How are you doing?");
				response = getInput(); 
				if (findKeyword(response, "good", 0) >= 0){
					print("I'm so happy you're good");
				}
				else if (like.isTriggered(response)){
					inLoop = false;
					like.talk();
				}
				
				else if (school.isTriggered(response)){
					inLoop = false;
					school.talk();
				}
				else if (hello.isTriggered(response)){
					inLoop = false;
					hello.talk();
				}
		}
	}
	
	public static int findKeyword(String searchString, String key, int startIndex) {
		//delete white space
		String phrase = searchString.trim();
		//set all letters to lowercase
		// prevents case sensitive
		phrase = phrase.toLowerCase();
		key = key.toLowerCase();
		
		//System.out.println("the phrase is " + phrase);
		//System.out.println("the key is " +key);
		
		//find position of key
		int psn = phrase.indexOf(key);
		//System.out.println("the position found is " + psn);
		//keep looking for the word until you find the right context
		while(psn >= 0){
			String before = " ";
			String after = " ";
			//if the phrase does not end with this word
			if(psn + key.length() < phrase.length()){
				after = phrase.substring(psn +key.length(), psn + key.length()+1).toLowerCase();
				//System.out.println("the character after " + key + " is " + after);
			}
			// if the phrase doesnt begin with this word
			if(psn>0){
				before = phrase.substring(psn-1, psn).toLowerCase();
				//System.out.println("the character before " + key + " is " + before);
			}
			if (before.compareTo("a") < 0 && after.compareTo("a")<0){
				//System.out.println(key + " was found at  " + psn);
				if(noNegotiations(phrase,psn)){
				return psn;
				}
			}
			psn = phrase.indexOf(key,psn+1);
			//System.out.println(key + " was not found. " + " checking " +psn);
		}
		
		return -1;
	}
	
	//helper method a method that contribute functionality to another method
	//helper methods are very common when you need to do the same thing repeatedly
	// they also help make methods more readable
	//it is private because it is only used by the method it is helping
	private static boolean noNegotiations(String phrase, int index){
		//check for the word "no "(3 characters)
		// check to see if there is space for the word no to be in front of the index
		if (index - 3 >=0 && phrase.substring(index-3, index).equals("no ")){
			return false;
		}
		//check for "not "
		if (index - 4 >=0 && phrase.substring(index-4, index).equals("not ")){
			return false;
		}
		//check for "never "
		if (index - 6 >=0 && phrase.substring(index-6, index).equals("never ")){
			return false;
		}
		//check for "n't "
		if (index - 4 >=0 && phrase.substring(index-4, index).equals("n't ")){
			return false;
		}
		return true;
	}
	
	private static void promptInput() {
		print(user + ", try inputing a String!");
		String userInput = input.nextLine();
		print("You typed:" +userInput);
	}
	
	public static String getInput(){
		return input.nextLine();
	}
	
	public static void print(String s){
		//create a multi line string
		String printString = "";
		int cuttoff = 35;
		//check to see if there's words to add
		//
		while(s.length()>0){
			String currentLine="";
			String nextWord="";
			//while the current line and next word are less than the cuttoff, do the following loop AND there are still words to add
			while(currentLine.length() + nextWord.length() <= cuttoff && s.length() > 0){
				//add the next word to the line
				currentLine += nextWord;
				//remove that word
				s = s.substring(nextWord.length());
				// get the following word 
				int endOfWord = s.indexOf(" ");
				//check to see if this i the last word
				if (endOfWord==-1){
					endOfWord = s.length()-1;
				}
				// get the next word and space
				nextWord = s.substring(0, endOfWord + 1);
			}
			printString += currentLine + "\n";
		}
		
		System.out.println(printString);
	}
	
	private static void createTopic() {
		input = new Scanner(System.in);
		school = new School();
		like = new AnnaLikes();
		hello = new AnnaHello();
	}
	
	public static void demonstrateStringMethods(){
//			String text = new String("Hello World");
			String text1 = "Hello World"; //same as above
			String text2 = "Hello ";
			String text3 = "World";
			
			if(text1 .equals (text2 + text3)) System.out.println("these strings are equal");
			
			System.out.println(text1);
			System.out.println(text2+text3);
			
			String word1 = "aardvark";
			String word2 = "zyzzyva";
			if (word1.compareTo(word2)<0) System.out.println("word1 is before word2 " + "lex");
	}

}
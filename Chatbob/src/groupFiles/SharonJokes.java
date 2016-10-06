package groupFiles;

import java.util.Random;

public class SharonJokes implements Topic {
	private boolean inJokesLoop;
	private String jokesResponse;

		public void talk() {
			String[] puns = {"A guy gets hit by a car and suffers brain damage. I guess you could say he was driven insane",
					"Time flies like an arrow, fruit flies like banana.",
					"If you want to catch a squirrel just climb a tree and act like a nut.",
					"When I get naked in the bathroom, the shower usually gets turned on." };
			int i = new Random().nextInt(puns.length); //draws value between 0(inclusive)-length(exclusive)
			System.out.println("Fun's my middle name.\n"+puns[i]);
			 String punResponse= SharonChatBox.getInput();
			 
			 if (punResponse== "not funny"|| punResponse=="lame") {
				 System.out.println("well then...");
			 };
				 System.out.println("very well\n"); 
			 
		inJokesLoop = true;
		while(inJokesLoop)
		{

			SharonChatBox.print("let me tell you a joke");
			inJokesLoop=true;
			while(inJokesLoop){
				jokesResponse=SharonChatBox.getInput();
				int jokePsn=SharonChatBox.findKeyword(jokesResponse, "joke", 0);
				
				}
//				else{
//					SharonChatBox.print("I don't understand you.");
//				}
			}
		
			System.out.println(); //what do you call a ___ ...
			jokesResponse=SharonChatBox.getInput(); //idk.

			
			System.out.println(); //answer
			jokesResponse=SharonChatBox.getInput(); //final response
			
		
			//System.out.println("this is where the jokes will go.");
		}
			 


		
		

		
		public boolean isTriggered(String userInput) {
			if(SharonChatBox.findKeyword(userInput, "joke", 0)>= 0)
			{
				return true;
			}
			if(SharonChatBox.findKeyword(userInput, "funny", 0)>= 0)
			{
				return true;
			}
			return false;
		}
}



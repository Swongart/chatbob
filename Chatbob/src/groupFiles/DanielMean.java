package groupFiles;

import Chatbot.DanielQMain;

public class DanielMean implements Topic {
	
	private boolean inMeanLoop;
	private String meanResponse;
	private int meanCount;
	private static String[] sadResponses = {"That's not very nice.", "Why are you being so mean?", "You should apologize" };
	
	public DanielMean(){
		meanCount = 0;
	}
	
	

	@Override
	public void talk() {
		while(inMeanLoop){
			meanCount++;
		}
		printSadResponse();
		meanResponse = SharonChatBox.getInput();
		if(!isTriggered(meanResponse)){
			inMeanLoop = false;
			SharonChatBox.talkForever();
		}

		
	}

	private void printSadResponse() {
//		for(int a = 0; a < sadResponses.length; a++){
//			SharonChatBox.print(sadResponses[a]);
//		}
		
		
		
	}



	@Override
	public boolean isTriggered(String userInput) {
		String[] meanTriggers = {"stupid", "idiot", "ugly", "dumb", "useless", "loser", "failure"};
		for(int i = 0; i < meanTriggers.length; i++){
			
			if(SharonChatBox.findKeyword(userInput, i , 0)>=0){
				return true;
			}

		}
			
		return false;
	}

}

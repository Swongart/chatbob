package groupFiles;

//import Chatbot.DanielQMain;

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
		inMeanLoop = true;
		while(inMeanLoop){
			meanCount++;

			printSadResponse();
			meanResponse = SharonChatBox.getInput();
			if(meanCount > 4 && isApology(meanResponse) == true){
				SharonChatBox.print("I accept your apology");

				inMeanLoop = false;
				SharonChatBox.talkForever();
			}
			else if(meanCount<4 && !isTriggered(meanResponse)){
				inMeanLoop = false;
				SharonChatBox.talkForever();
				
			}
		}


	}

	private boolean isApology(String apology) {
		String[] apologyResponse = {"sorry", "apologize"};
		for(int i = 0; i < apologyResponse.length; i++){

			if(SharonChatBox.findKeyword(apology, apologyResponse[i] , 0)>=0){
				return true;
			}

		}


		return false;
	}



	private void printSadResponse() {
		if(meanCount<4){
			SharonChatBox.print(sadResponses[meanCount-1]);
		}
		if(meanCount>=4){
			SharonChatBox.print("...");
		}



	}



	@Override
	public boolean isTriggered(String userInput) {
		String[] meanTriggers = {"stupid", "idiot", "ugly", "dumb", "useless", "loser", "failure"};
		for(int i = 0; i < meanTriggers.length; i++){

			if(SharonChatBox.findKeyword(userInput, meanTriggers[i] , 0)>=0){
				return true;
			}

		}

		return false;
	} 

}

package groupFiles;

public class SharonJokes implements Topic {
	private boolean inJokesLoop;
	private String jokesResponse;

		public void talk() {
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
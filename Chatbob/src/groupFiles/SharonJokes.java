package groupFiles;

public class SharonJokes implements Topic {
	private boolean inJokesLoop;
	//private String jokesResponse;

		public void talk() {
		inJokesLoop = true;
		while(inJokesLoop)
		{
			
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
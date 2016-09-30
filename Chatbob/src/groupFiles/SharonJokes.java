package groupFiles;

public class SharonJokes implements Topic{
	private boolean inJokeLoop;
	private String foodResponse;
	
	
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

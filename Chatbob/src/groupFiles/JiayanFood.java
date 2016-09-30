package groupFiles;

public class JiayanFood implements Topic {
private boolean inFoodLoop;
private String foodResponse;

	public void talk() {
	inFoodLoop = true;
	while(inSchoolLoop)
	{
		
	}
		

	}
	public boolean isTriggered(String userInput) {
		if(SharonChatBox.findKeyword(userInput, "food", 0)>= 0)
		{
			return true;
		}
		if(SharonChatBox.findKeyword(userInput, "eat", 0)>= 0)
		{
			return true;
		}
		return false;
	}

}

package groupFiles;

//import chatBox.Anna;

public class AnnaWWE implements Topic{

	private boolean inWWELoop;
	private String WWEResponse;
	
	@Override
	public void talk() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isTriggered(String userInput) {
		if (SharonChatBox.findKeyword(userInput, "dean ambrose", 0)>=0){
			return true;
		}
		if (SharonChatBox.findKeyword(userInput, "s", 0)>=0){
			return true;
		}
		return false;
	}

}

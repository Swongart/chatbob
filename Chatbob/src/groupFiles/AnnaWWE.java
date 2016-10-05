package groupFiles;

//import chatBox.Anna;

public class AnnaWWE implements Topic{

	private boolean inWWELoop;
	private String WWEResponse;
	
	@Override 
	public void talk() {
		// TODO Auto-generated method stub
		SharonChatBox.print("Do you like wrestling?");
		inWWELoop = true;
		while (inWWELoop){
			WWEResponse = SharonChatBox.getInput();
			int likePsn = SharonChatBox.findKeyword(WWEResponse,"yes",0);
			if(likePsn>=0){
				SharonChatBox.print("Do you like WWE?");
				if (SharonChatBox.findKeyword(WWEResponse, "yes", 0)>=0){
					SharonChatBox.print("You are so cool. Who do you like?");
					 
				}
				else{
					inWWELoop = false;
					SharonChatBox.talkForever();
				}
				
			}
			else{
				SharonChatBox.print("I don't understand you");
			}
		}
	}

	@Override
	public boolean isTriggered(String userInput) {
		String[] array = {"wrestling","wrestler","wwe","champion"};
		for (int  i = 0; i < array.length; i++){
			if (SharonChatBox.findKeyword(userInput, array[i], 0)>=0){
				return true;
			}
		}
		return false;
	} 

}
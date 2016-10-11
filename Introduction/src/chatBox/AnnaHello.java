package chatBox;

public class AnnaHello implements Topic{

	private boolean inHelloLoop;
	private String helloResponse;
	
	private int helloCount;
	
	//responses are constants(nver change, alway exist)
	private static String[] calmResponses = {"We've already said our hellos. Remember?",
			"Yes, hello to you too. Let's actually to talk"};
	private static String[] angryResponses = {"Seriously, this has to stop.", 
			"You are beginning to annoy me", 
			"We've SAID HELLO!"}; 
	
	public AnnaHello(){
		helloCount = 0;
	}
	
	@Override
	public void talk() {
		inHelloLoop = true;
		while(inHelloLoop){
			helloCount++;
			printResponse();
			helloResponse = Anna.getInput();
			if(!isTriggered(helloResponse)){
				inHelloLoop = false;
				Anna.talkForever();
			}
		}
		
	}

	private void printResponse() {
		int responseIndex = 0;
		//calm response
		if(helloCount<5){
			responseIndex = (int)(Math.random()*calmResponses.length);
			Anna.print(calmResponses[responseIndex]);
		}
		//angry response
		else{
			responseIndex = (int)(Math.random()*angryResponses.length);
			Anna.print(angryResponses[responseIndex]);
		}
		
	}

	@Override
	public boolean isTriggered(String userInput) {
		if (Anna.findKeyword(userInput, "hi", 0)>=0){
			return true;
		}
		if (Anna.findKeyword(userInput, "hello", 0)>=0){
			return true;
		}
		return false;
	}
	

}

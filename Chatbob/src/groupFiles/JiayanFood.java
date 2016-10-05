package groupFiles;

public class JiayanFood implements Topic {
private boolean inFoodLoop;
private String foodResponse;
//private static String [] foods = {"pizza","ice cream","Japanese Food", "Korean Food"};
private static String [] restaurants = {"Di Fara Pizza","Ample Hills Creamery","Kyo Ya","Shilla"};

	public void talk() {
	inFoodLoop = true;
	while(inFoodLoop)
	{
		foodResponse = SharonChatBox.getInput();
		suggestRestaurants();
		if(!isTriggered(foodResponse))
		{
			inFoodLoop = false;
			SharonChatBox.talkForever();
		}
	}
		 

	}
	private void suggestRestaurants()
	{
		if(SharonChatBox.findKeyword(foodResponse, "pizza", 0)>= 0)
		{
			SharonChatBox.print("Since you like pizza, I suggest you go to "+ restaurants[0]);
		}
		if(SharonChatBox.findKeyword(foodResponse, "ice cream", 0)>= 0)
		{
			SharonChatBox.print("In New York, I think "+ restaurants[1] + "is great for ice cream");
		}
		if(SharonChatBox.findKeyword(foodResponse, "Japanese Food", 0)>= 0)
		{
			SharonChatBox.print("I know all about Japanese food! The "+ restaurants[2]+ "restaurant is awesome!");
		}
		if(SharonChatBox.findKeyword(foodResponse, "Korean Food", 0)>= 0)
		{
			SharonChatBox.print("In manhattan, I suggest you go to "+ restaurants[3] + "for authentic korean food.");
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

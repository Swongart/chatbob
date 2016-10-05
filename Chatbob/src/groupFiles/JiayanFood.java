package groupFiles;

public class JiayanFood implements Topic {
private boolean inRestaurantLoop;
private boolean inFoodLoop;
private String foodResponse;
private static String [] foods = {"pizza","ice cream","Japanese Food","Korean Food"};
private static String [] foodResponseArr = {"I like pizza too. I like plain cheese pizza the best.",
		"I love ice cream too! Eating ice cream in the winter is the best",
		"I don't enjoy Japanese food. Why do you like it?", "I only enjoy certain Korean dishes. Which is your favorite?"};
private static String [] restaurants = {"Di Fara Pizza","Ample Hills Creamery","Kyo Ya","Shilla"};

	public void talk() {
	inRestaurantLoop = true;
	inFoodLoop = true;
	while(inRestaurantLoop)
	{
		foodResponse = SharonChatBox.getInput();
		suggestRestaurant();
		if(!isTriggered(foodResponse))
		{
			inRestaurantLoop = false;
			SharonChatBox.talkForever();
		}
	} 
	while(inFoodLoop)
	{
		foodResponse = SharonChatBox.getInput();
		talkFoods();
		if(!isTriggered(foodResponse))
		{
			inFoodLoop = false;
			SharonChatBox.talkForever();
		}
	} 
	}
	private void suggestRestaurant()
	{
		for(int foodIndex = 0; foodIndex < 8; foodIndex++)
		{
			if(SharonChatBox.findKeyword(foodResponse, foods[foodIndex], 0)>= 0)
			{
				SharonChatBox.print("Since you like " + foods[foodIndex] + ". I suggest you go to "+ restaurants[foodIndex]);
			}
		}
	}
	private void talkFoods()
	{
		if(SharonChatBox.findKeyword(foodResponse, "pizza", 0)>= 0)
		{
			SharonChatBox.print(foodResponseArr[0]);
		}
		if(SharonChatBox.findKeyword(foodResponse, "ice cream", 0)>= 0)
		{
			SharonChatBox.print(foodResponseArr[1]);
		}
		if(SharonChatBox.findKeyword(foodResponse, "Japanese Food", 0)>= 0)
		{
			SharonChatBox.print(foodResponseArr[2]);
		}
		if(SharonChatBox.findKeyword(foodResponse, "Korean Food", 0)>= 0)
		{
			SharonChatBox.print(foodResponseArr[3]);
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

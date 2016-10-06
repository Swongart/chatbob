package groupFiles;

public class JiayanFood implements Topic {
private boolean inRestaurantLoop;
private boolean inFoodLoop;
private String foodResponse;
private static String [] foods = {"pizza","ice cream","Japanese Food","Korean Food","Halal","Pasta",};
private static String [] foodResponseArr = {"I like pizza too. I like plain cheese pizza the best.",
		"I love ice cream too! Eating ice cream in the winter is the best",
		"I don't enjoy Japanese food. Why do you like it?", 
		"I only enjoy certain Korean dishes. Which is your favorite?","There are so many halal carts in the city.",
		"What is you favorite pasta dish?"};
private static String [] restaurants = {"Di Fara Pizza","Ample Hills Creamery","Kyo Ya","Shilla","The Halal Guys Food Cart","Osteria Morini",};

	public void talk() {
	whichLoop();
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
	private void whichLoop()
	{
		int ranLoop = (int)(Math.random()*20+1);
		if(ranLoop > 10)
		{
			inRestaurantLoop = true;
		}
		else
		{
			inFoodLoop = true;
		}
	}
	private void suggestRestaurant()
	{
		for(int foodIndex = 0; foodIndex < 6; foodIndex++)
		{
			if(SharonChatBox.findKeyword(foodResponse, foods[foodIndex], 0)>= 0 
					&& SharonChatBox.findKeyword(foodResponse, "like", 0)>= 0)
			{
				SharonChatBox.print("Since you like " + foods[foodIndex] + ". I suggest you go to "+ restaurants[foodIndex]);
			}
			else if(SharonChatBox.findKeyword(foodResponse, "you", 0)>= 0)
			{
				SharonChatBox.print("I operate only on electricity.");
			}
		}
	}
	private void talkFoods()
	{
		for(int strIndex = 0; strIndex < 6; strIndex++)
		{
			if(SharonChatBox.findKeyword(foodResponse, foods[strIndex], 0)>= 0)
			{
				SharonChatBox.print(foodResponseArr[strIndex]);
			}
			
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
		if(SharonChatBox.findKeyword(userInput, "restaurant", 0)>= 0)
		{
			return true;
		}
		return false;
	}

}

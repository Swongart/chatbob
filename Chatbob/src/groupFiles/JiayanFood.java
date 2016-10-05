package groupFiles;

public class JiayanFood implements Topic {
private boolean inRestaurantLoop;
private boolean inFoodLoop;
private String foodResponse;
private static String [] foods = {"pizza","ice cream","Japanese Food", "Korean Food"};
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
	/*private void suggestRestaurants()
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
	}*/
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

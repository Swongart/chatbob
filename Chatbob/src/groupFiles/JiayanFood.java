package groupFiles;

public class JiayanFood implements Topic {
	private boolean inRestaurantLoop;
	private String foodResponse;
	private static String [] foods = {"pizza","ice cream","sushi","Korean","Halal","Pasta","pancakes","burger","tacos","coffee"};
	private static String [] restaurants = {"Di Fara Pizza","Ample Hills Creamery","Kyo Ya","Shilla","The Halal Guys Food Cart","Osteria Morini","IHOP","Shake Shack","Los Tacos No.1","Cafe Grumpy"};
	private static String [] convoExtensions = {"Why do you like it?", "Is it your favorite?","Where do you like to go to get it?","What makes you like it?"};
	public void talk() {
	inRestaurantLoop = true;
	while(inRestaurantLoop) 
	{
		foodResponse = SharonChatBox.getInput();
		suggestOrAsk();
		if(!isTriggered(foodResponse))
		{
			inRestaurantLoop = false;
			SharonChatBox.talkForever();
		}
	} 
	}
	private void suggestOrAsk()
	{
		for(int foodIndex = 0; foodIndex < 10; foodIndex++)
		{
			if(SharonChatBox.findKeyword(foodResponse, foods[foodIndex], 0)>= 0 
					&& SharonChatBox.findKeyword(foodResponse, "like", 0)>= 0)
			{
				SharonChatBox.print("Since you like " + foods[foodIndex] + ". I suggest you go to "+ restaurants[foodIndex]);
			}
			else 
			{
				int arrIndex = (int)(Math.random()*4 +1);
				SharonChatBox.print(convoExtensions[arrIndex]);
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

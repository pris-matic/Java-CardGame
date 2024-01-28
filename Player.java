import java.util.ArrayList;

/**
The player class stores stats about the player.
Also shows the cards they are currently holding after
someone is declared the winner.

@author Anthony B. Deocadiz Jr. (232166)
@version November 10, 2023
**/

/*
I have not discussed the Java language code in my program
with anyone other than my instructor or the teaching assistants
assigned to this course.

I have not used Java language code obtained from another student,
or any other unauthorized source, either modified or unmodified.

If any Java language code or documentation used in my program
was obtained from another source, such as a textbook or website,
that has been clearly noted with a proper citation in the comments
of my program.
*/

public class Player {
	
	private String playerName;
	private int tokenCounter;
	private boolean fullHand;
	private ArrayList<Card> cardList;
	private ArrayList<String> powerUps;

	/**
		The findCard() method is only called by the swap() 
		method and is used to check for the highest product 
		of the inactive cards of the player (indexes 1 to n)
		the card with the highest product is then swapped in
		to become the new active card.
	**/
	private int findCard(){
		// stores the product of the inactive cards in an ArrayList
		ArrayList<Integer> productList = new ArrayList<>();
		int maxIndex = -1;
		int product = 1;

		if (cardList.size() > 1){
			for (int i = 1; i < cardList.size();i++){
				productList.add(cardList.get(i).getPower()*cardList.get(i).getHealth());
			}
		}
		/**  
			checks the highest product of the inactive cards, 
			then stores its index to maxIndex, which is added
			by 1 to relate its position in the cardList ArrayList.
		**/
		for (int i = 0;i < productList.size();i++){
			if (productList.get(i) > product){
				product = productList.get(i);
			}
			maxIndex = productList.indexOf(product) + 1;
		}

		return maxIndex;
	}
	/**
		@param n initializes player name
		initializes tokenCounter to 0, 
		fullHand to false (as they have no cards at start) and
		creates a new ArrayList named cardList to store the cards.
	**/
	public Player (String n){
		playerName = n;
		tokenCounter = 0;
		fullHand = false;
		cardList = new ArrayList<>();
		powerUps = new ArrayList<>();

	}
	/**
		add card to player if they have less than 5 cards.
		@param c is the card to be added to the player's deck
	**/
	public void drawCard (Card c){
		if (cardList.size() < 5){
			fullHand = false;
			cardList.add(c);
			if (cardList.size() == 5){
				fullHand = true;
			}
		} else {
			fullHand = true;
		}
	}
	
	/**
		discards / removes the active card (index 0) since 
		it is the one being used for battle when its hp reaches 
		less than or equal to zero.
	**/
	public void discard (){
		cardList.remove(0);
	}
	
	/**
		swaps current active card with the result of 
		findCard() and prints out its name and health
		swapping the variables with the help of variable 
		x as a placeholder.
		@return a string that says the name of the swapped cards
	**/
	public String swap(){
		String swapMessage = "";

		if (cardList.size() > 1){

			Card x = cardList.get(0);
			cardList.set(0, cardList.get(findCard()));
			cardList.set(findCard(),x);
			swapMessage += "   " + getActiveCard().getName() + " is now active with " + getActiveCard().getHealth() + " health.";

		} else if (findCard() == -1){
			swapMessage += playerName + " has no other card to swap with. Turn forfeited.";
		}
		return swapMessage;
	}
	
	/**
		gives a token to the player.
	**/
	public void claimToken(){
		tokenCounter ++;
	}
	
	/**
		A method to call the first (or active) card the player has.
		@return the first card from the array, which will be used for actions.
	**/
	public Card getActiveCard(){
		return cardList.get(0);
	}
	
	/**
		A method that calls the player's name.
		@return the name of the player.
	**/
	public String getName(){
		return playerName;
	}
	
	/**
		method that determines how many tokens a player has
		@return the number of tokens the player currently has.
	**/
	public int getTokens(){
		return tokenCounter;
	}
	
	/**
		checks if the player has 5 cards in their hand
		@return true if player has 5 cards, false otherwise.
	**/
	public boolean handIsFull(){
		return fullHand;
	}
	
	/**
		prints out the player's name, and the cards they are holding
		@return a string that tells the cards (and its stats) of the player
	**/
	public String statusReport(){
		
		String playerStats = "";

		playerStats += playerName.toUpperCase() + "\n";
		for (int i = 0; i < cardList.size() ; i++){
			playerStats += "\t" + cardList.get(i).getName() + " : " + cardList.get(i).getHealth() +"\n";
		}
		return playerStats;
	}

	/**
		A method to call the player's cards
		@return the cards of the player
	**/
	public ArrayList<Card> callCards(){
		return cardList;
	}

	/** 
		gives the player a powerup based on what the
		GameMaster has rolled.
		@param x is the string that will be stored, and will be checked for what power up
		to activate later.
	**/
	public void claimPowerUp(String x){
		powerUps.add(x);
	}

	/**
		calls the power ups of the player
		@return an arraylist that cointains the player's powerups
	**/
	public ArrayList<String> callPowerUps(){
		return powerUps;
	}

}

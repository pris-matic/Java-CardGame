import java.util.ArrayList;

/**
GameMaster takes note of the stats of both players,
as well as the one responsible for every action that
happens in the game.

@author Anthony B. Deocadiz Jr. (232166)
@version November 11, 2023
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

public class GameMaster {

  private int turnCounter;
  private boolean gameWinner;
  private Player player1;
  private Player player2;
  private ArrayList<Card> deck;
  private boolean dealRandom;
  private boolean powerUps;
  private int winCondition;
  private String[] powerUpsList;

  // power up truth values for player 1
  private boolean player1ActivePower;
  private boolean player1ActiveDouble;
  private boolean player1ActiveResist;

  // power up truth values for player 2
  private boolean player2ActivePower;
  private boolean player2ActiveDouble;
  private boolean player2ActiveResist;

  private boolean againstComputer;

  	/**
	  	The assembleDeck() method is a private method.
	  	It is given entirely to the student.
	  	It must NOT be modified.
	**/
	private void assembleDeck(){
		deck.add( new Card( "Dragon", "Aquira", 174, 26 ) );
		deck.add( new Card( "Ghost", "Brawn", 130, 48 ) );
		deck.add( new Card( "Fairy", "Cerulea", 162, 29 ) );
		deck.add( new Card( "Dragon", "Demi", 147, 28 ) );
		deck.add( new Card( "Ghost", "Elba", 155, 37 ) );
		deck.add( new Card( "Fairy", "Fye", 159, 42 ) );
		deck.add( new Card( "Dragon", "Glyede", 129, 26 ) );
		deck.add( new Card( "Ghost", "Hydran", 163, 35 ) );
		deck.add( new Card( "Fairy", "Ivy", 146, 45 ) );
		deck.add( new Card( "Dragon", "Jet", 170, 24 ) );
		deck.add( new Card( "Ghost", "Kineti", 139, 21 ) );
		deck.add( new Card( "Fairy", "Levi", 160, 43 ) );
		deck.add( new Card( "Dragon", "Meadow", 134, 29 ) );
		deck.add( new Card( "Ghost", "Naidem", 165, 26 ) );
		deck.add( new Card( "Fairy", "Omi", 145, 21 ) );
		deck.add( new Card( "Dragon", "Puddles", 170, 34 ) );
		deck.add( new Card( "Ghost", "Quarrel", 151, 29 ) );
		deck.add( new Card( "Fairy", "Raven", 168, 32 ) );
		deck.add( new Card( "Dragon", "Surge", 128, 27 ) );
		deck.add( new Card( "Ghost", "Takiru", 140, 26 ) );
		deck.add( new Card( "Fairy", "Ustelia", 163, 47 ) );
		deck.add( new Card( "Dragon", "Verwyn", 145, 25 ) );
		deck.add( new Card( "Ghost", "Wyverin", 158, 32 ) );
		deck.add( new Card( "Fairy", "Xios", 155, 27 ) );
		deck.add( new Card( "Dragon", "Yora", 159, 44 ) );
		deck.add( new Card( "Ghost", "Zulu", 125, 46 ) );
	}

	/**
		initiates turnCounter to 1 -- indicating player 1's turn
		sets gameWinner to false and also calls assembleDeck()
		@param a initializes the first player.
		@param b initializes the second player.
	**/
	public GameMaster (Player a , Player b){
		player1 = a;
		player2 = b;
		turnCounter = 1;
		gameWinner = false;
		deck = new ArrayList<Card>();
		assembleDeck();
		winCondition = 3;
	}

	/**
		initiates turnCounter to 1 -- indicating player 1's turn
		sets gameWinner to false and also calls assembleDeck()
		@param a initializes the first player.
		@param b initializes the second player.
		@param r initializes random deal of cards
	**/
	public GameMaster(Player a, Player b, boolean r){ 
	  
		dealRandom = r;
		player1 = a;
		player2 = b;
		turnCounter = 1;
		gameWinner = false;
		deck = new ArrayList<Card>();
		assembleDeck();
		winCondition = 3;
	  
	}

	/**
		initiates turnCounter to 1 -- indicating player 1's turn
		sets gameWinner to false and also calls assembleDeck()
		@param a initializes the first player.
		@param b initializes the second player.
		@param r initializes random deal of cards
		@param p determines whether power ups should be dealt
	**/
	public GameMaster(Player a, Player b, boolean r, boolean p){ 
	  
		dealRandom = r;
		player1 = a;
		player2 = b;
		turnCounter = 1;
		gameWinner = false;
		deck = new ArrayList<Card>();
		assembleDeck();
		powerUps = p;
		winCondition = 3;
		powerUpsList = new String[] {"doubleDamage" , "autoResist" , "instaHeal"};

		// first set as false
		player1ActivePower = false;
		player1ActiveDouble = false;
		player1ActiveResist = false;

		player2ActivePower = false;
		player2ActiveDouble = false;
		player2ActiveResist = false;

	}

	/**
		initiates turnCounter to 1 -- indicating player 1's turn
		sets gameWinner to false and also calls assembleDeck()
		@param a initializes the first player.
		@param b initializes the second player.
		@param r initializes random deal of cards
		@param p determines whether power ups should be dealt
		@param wc determines the number of tokens needed to win
	**/
	public GameMaster(Player a, Player b, boolean r, boolean p, int wc){ 
	  
		dealRandom = r;
		player1 = a;
		player2 = b;
		turnCounter = 1;
		gameWinner = false;
		deck = new ArrayList<Card>();
		assembleDeck();
		powerUps = p;
		winCondition = wc;
		powerUpsList = new String[] {"doubleDamage" , "autoResist" , "instaHeal"};

		// first set as false
		player1ActivePower = false;
		player1ActiveDouble = false;
		player1ActiveResist = false;

		player2ActivePower = false;
		player2ActiveDouble = false;
		player2ActiveResist = false;
	}
	
	/**
		initiates turnCounter to 1 -- indicating player 1's turn
		sets gameWinner to false and also calls assembleDeck()
		@param a initializes the first player.
		@param b initializes the second player.
		@param r initializes random deal of cards
		@param p determines whether power ups should be dealt
		@param wc determines the number of tokens needed to win
		@param c determines whether a computer / bot will play instead of another player
	**/
	public GameMaster(Player a, Player b, boolean r, boolean p, int wc , boolean c){ 
	  
		dealRandom = r;
		player1 = a;
		player2 = b;
		turnCounter = 1;
		gameWinner = false;
		deck = new ArrayList<Card>();
		assembleDeck();
		powerUps = p;
		winCondition = wc;
		powerUpsList = new String[] {"doubleDamage" , "autoResist" , "instaHeal"};

		// first set as false
		player1ActivePower = false;
		player1ActiveDouble = false;
		player1ActiveResist = false;

		player2ActivePower = false;
		player2ActiveDouble = false;
		player2ActiveResist = false;

		// determines whether a bot will be initialized
		againstComputer = c;
		
	}

	/**
		The Play method allows the players to make an action during their turn.
		@param action determines what the action of the player 
		on that turn does
		@return a string that shows the action
	**/
	public String play(String action){

	/** 
		player x -- player attacking / swapping
		player y -- player defending / target (if x is attacking)
	**/ 
		Player x = null;
		Player y = null;
		String playMessage = "";

		// indicator of who's turn it is.
		if (turnCounter % 2 == 0){
			x = player2;
			y = player1;
		} else {
			x = player1;
			y = player2;
		}
	  
		if (action.equalsIgnoreCase("swap")){

			playMessage += "   " + x.getName() + " swaps out " + x.getActiveCard().getName() +"...\n" + x.swap();
			turnCounter ++;

		} else if (action.equalsIgnoreCase("attack")){
			playMessage += "   " + x.getName() + " attacks with " + x.getActiveCard().getName() + ".\n" + dealDamage(x.getActiveCard(),y.getActiveCard()); 
			if (y.getActiveCard().getHealth() <= 0){
				playMessage += "\n   " + y.getName() + " discards " + y.getActiveCard().getName() + ".\n";
				y.discard();

				/** 
					GameMaster checks the first 2 cards, and get their products
					card with higher product is given out to the player.
					higherValue is the index in the deck ArrayList.
					if there's is only 1 card in deck, return that card
					if there's no cards, print that the deck is empty.
				**/
				int higherValue = 0;
				if (deck.size() == 0){
					playMessage += "The deck is empty.\n";
				} else if (deck.size() == 1){
					playMessage += "   " + y.getName() + " draws " + deck.get(higherValue).getName() + ".\n";
					y.drawCard(deck.get(higherValue));
					deck.remove(higherValue);
				} else {
					// product of 2 topmost cards in ArrayList deck.
					// give card with higherValue (product) to player then put the lowerValue to the bottom of the deck.
					int product1 = deck.get(0).getHealth() * deck.get(0).getPower(); 
					int product2 = deck.get(1).getHealth() * deck.get(1).getPower();
					if (product2 > product1){
						higherValue = 1;
					}

					playMessage += "   " + y.getName() + " draws " + deck.get(higherValue).getName() + ".\n";
					y.drawCard(deck.get(higherValue));

					/**
						lesserValue acts as a placeholder for the card with the 
						lower product, which be put at the bottom part of the deck
					**/ 
					Card lesserValue = null; 
					if (higherValue == 0){
					lesserValue = deck.get(1);
						for (int i = 1 ; i >= 0 ; i --){
							deck.remove(i);
						}
					} else {
					lesserValue = deck.get(0);
						for (int i = 1 ; i >= 0 ; i --){
							deck.remove(i);
						}	  	  
					}
					deck.add(lesserValue);
				}
				if (powerUps){
					playMessage += "   " + givePowerUp(y);
				}
				
				/** 
					gives token to the attacker, then check if they
					have 3 tokens already. If they have 3 tokens,
					GameMaster declares a winner then ends the game.
				**/
				playMessage += "   " + x.getName() + " gets a token!";
				x.claimToken();
				if (x.getTokens() == winCondition){
					gameWinner = true;
					if (hasWinner()){
						playMessage += "\n" + x.getName() + " wins!!!\n\n" + gameReport();
					}
				}
			}
			
			turnCounter ++;
		} else if (action.equalsIgnoreCase("power up")){
			if (powerUps){
				if (x.callPowerUps().size() == 0){
					playMessage += "   No power Ups Available.";
				} else {
					playMessage += "\n   Available Power Ups:";
					for (int i = 0; i < x.callPowerUps().size() ; i++){
						playMessage += "\n   " + x.callPowerUps().get(i);
					}

				}
			} else {
				playMessage += "   Power ups are disabled for this game.";
			}
			
		}
		return playMessage;
	}

	/**
		Check if the card being attacked is resistant
		to the attacker's card.
		@param type1 is the card being attacked
		@param type2 is the attacker's card.
		@return true if one of the conditions are met, otherwise false.
	**/
	public boolean checkResistance(String type1 , String type2){
	  
	/**
		used x as a placeholder to determine whether the defender's
		card resists the attacker's card.
	**/
	  boolean x = false;

	  if (type1.equalsIgnoreCase("Dragon")){
		switch (type2) {
		  case "Ghost":
			x = true;
			break;
		
		  default:
			x = false;
		}
	  } else if (type1.equalsIgnoreCase("Ghost")){
		switch (type2) {
		  case "Fairy":
			x = true;
			break;
		
		  default:
			x = false;
		}
	  } else if (type1.equalsIgnoreCase("Fairy")){
		switch (type2) {
		  case "Dragon":
		  	x = true;
		  	break;
		
		  default:
			x = false;
		}
	  }
	  return x;
	}

	/**
		checks if the card being attacked is weak to 
		the attacker's card.
		@param type1 is the card being attacked
		@param type2 is the attacker's card.
		@return true if one of the conditions are met, otherwise false.
	**/
	public boolean checkWeakness(String type1 , String type2){

	/**
		used x as a placeholder to determine whether the defender's
		card is weak against the attacker's card.
	**/
	  boolean x = false;

	  if (type1.equalsIgnoreCase("Dragon")){
		switch (type2) {
		  case "Fairy":
			x = true;
			break;

		  default:
			x = false;
		}
	  } else if (type1.equalsIgnoreCase("Fairy")){
		switch (type2) {
		  case "Ghost":
			x = true;
			break;

		  default:
			x = false;
		}
	  } else if (type1.equalsIgnoreCase("Ghost")){
		switch (type2) {
		  	case "Dragon":
		  	x = true;
		  	break;
		
			default:
				x = false;
			
		}
	  }
	  return x;
	}

	/**
		GameMaster deals cards to the players at the start of 
		the game. player1 gets cards on odd-numbered turns,
		while player2 gets cards on even-numbered turns.
		if they have 5 cards, it prints out that they have
		a full hand.
		@return a string that tells what card was dealt to the player
	**/
	public String dealCard(){
	  String dealCardMessage = "";
	  Player x = null;

	  if (turnCounter % 2 == 0){
		x = player2;
	  } else {
		x = player1;
	  }

	  if (dealRandom){
		// turn the result of Math.random() into an integer
		double randomCard = (Math.random() * deck.size());
		int giveRandom = (int) randomCard;

		if (x.handIsFull()){
		  	dealCardMessage += "\n" + x.getName()+"'s hand is full.";
		} else {
			dealCardMessage += "\n" + x.getName() + " draws " + deck.get(giveRandom).getName()+ ".";
			x.drawCard(deck.get(giveRandom));
			deck.remove(giveRandom);
			turnCounter ++;
		}
	  	} else {
			if (x.handIsFull()){
		  	dealCardMessage += "\n" + x.getName() + "'s hand is full.";
			} else {
			dealCardMessage += "\n" + x.getName() + " draws " + deck.get(0).getName()+".";
			x.drawCard(deck.get(0));
			deck.remove(0);
			turnCounter ++;
			}
		}

	  	return dealCardMessage;
	}

	/**
		Calculates for the damage dealt, and then sent to the
		opponent's card.
		@param inPlay is the one attacking
		@param target is the one taking damage.
		@return a string that indicates how much damage will be dealth
	**/
	public String dealDamage(Card inPlay, Card target){

		String damageMessage = "";
		int currentDamage = inPlay.getPower();

		// checks for autoResist and doubleDamage powerups from the players based on the turn counter
		boolean x = false;
		boolean y = false;

		Player a = null; // attacker
		Player b = null; // defender

		if (turnCounter % 2 == 0){ // determines who's doubleDamage and autoResist powerups will be checked.
			a = player2;
			x = player2ActiveDouble;

			b = player1;
			y = player1ActiveResist;
		} else {
			a = player1;
			x = player1ActiveDouble;

			b = player2;
			y = player2ActiveResist;
		}

		if (x){
				damageMessage += "      " + a.getName() + " has doubleDamage activated!\n";
				currentDamage *= 2;
				if (turnCounter % 2 == 0){
					player2ActiveDouble = false;
					player2ActivePower = false;
				} else {
					player1ActiveDouble = false;
					player1ActivePower = false;
				}
			}

		if (y){
				damageMessage += "      " + b.getName() + " has autoResist activated!\n";
				currentDamage /= 2;
				if (turnCounter % 2 == 0){
						player1ActiveResist = false;
						player1ActivePower = false;
					} else {
						player2ActiveResist = false;
						player2ActivePower = false;
					}
		}

		if (checkResistance(target.getType(), inPlay.getType())){
			damageMessage += "      " + target.getType() + " is resistant to " + inPlay.getType() + ".\n";
			damageMessage += "   " + inPlay.getName() + " deals " + currentDamage / 2 + " damage on " + target.getName() + ".\n";
			target.takeDamage(currentDamage / 2);
		} else if (checkWeakness(target.getType(), inPlay.getType())){
			damageMessage += "      " + target.getType() + " is weak to " + inPlay.getType() + ".\n";
			damageMessage += "   " + inPlay.getName() + " deals " + currentDamage * 2 + " damage on " + target.getName() + ".\n";
			target.takeDamage(currentDamage * 2);
		} else {
			damageMessage += "   " + inPlay.getName() + " deals " + currentDamage + " damage on " + target.getName() + ".\n";
			target.takeDamage(currentDamage);
		}
		damageMessage += "   " + target.getName() + " has " + target.getHealth() + " health left.";
		return damageMessage;
	}

	/**
		Determines whether the game should end if there
		is a winner.
		@return true if condition is met, false otherwise.
	**/
	public boolean hasWinner(){
	  	return gameWinner;
	}

	/**
		reports how long the game lasted and the 
		cards the players are currently holding.
		@return a string that shows the cards of both players
	**/
	public String gameReport(){

	  	String gameStats = "";

		gameStats += "---=== GAME SUMMARY ===---\n" + "This game lasted " + turnCounter + " turns.\n";
		gameStats += player1.statusReport() + "\n" + player2.statusReport();

		return gameStats;
	}

	/**
		gets the current turn counter of the game
		@return the number of turns that occurred
	**/
	public int getTurnCount(){
	  return turnCounter;
	}

	/**
		used in the gui to call the first player
		@return the first player, which is under the Player class
	**/
	public Player callPlayer1(){
		return player1;
	}

	/**
		used in the gui to call the second player
		@return the second player, which is under the Player class
	**/
  	public Player callPlayer2(){
		return player2;
  	}

	/** 
		gives a powerup to the defending player whenever
		they lose a card. Will only run if powerups are enabled
		in the GameMaster's Constructor.
		@param def is the player being attacked
		@return a powerup to the player when their activeCard's health reaches zero
	**/
	public String givePowerUp(Player def){
		String powerUpsMessage = "";
		double randomPower = (Math.random() * powerUpsList.length);
		int givePower = (int) randomPower; 

		powerUpsMessage += def.getName() + " gets a " + powerUpsList[givePower] + " power up!\n";
		def.claimPowerUp(powerUpsList[givePower]);
		return powerUpsMessage;
		
	}

	/**
	 	activates a power up when the method is called
		when a power up is activated, it ends the player's turn
		@param power is the name of the power up to be activated.
		@return a message that displays the activated power up
	**/
	public String activatePower(String power){

		String activateMessage = "";
	
		/** 
		 	power ups that are available for each player:

			doubleDamage -- doubles the next attack of the attacking player
			autoResist -- autmatically halves the damage of the next attack
			instaHeal -- heals the activeCard by 200. Can go beyond its starting health.

			can only have one instance of each power up active at a time
			(1 doubleDamage or 1 autoResist)

			instaHeal is immediately used upon calling
		**/

		Player x = null; // determines who will activate the power based on turn count

		if (turnCounter % 2 == 0){
			x = player2;
		} else {
			x = player1;
		}

		if (x == player1){
			boolean found = false;
			int i;
			for ( i = 0; i < x.callPowerUps().size() ; i++){
				String activatePower = x.callPowerUps().get(i);
				if (power.equalsIgnoreCase(activatePower)){
					found = true;
					break;
				} else {
					continue;
				}
			}
			if (found){
				if(power.equalsIgnoreCase("instaheal")){
					activateMessage += "   " + x.getName() + " heals " + x.getActiveCard().getName() + " by 200 health!\n";
					x.getActiveCard().takeDamage(-200);
					activateMessage += "   " + x.getActiveCard().getName() + " has now " + x.getActiveCard().getHealth() + " health!";
					x.callPowerUps().remove(i);
					turnCounter ++;
				} else if (player1ActivePower){
					activateMessage += "   " + x.getName() + " already has an active power up! ";
				} else {
					activateMessage += "   " + x.getName() + " activates " + power + "!\n";
					if (power.equalsIgnoreCase("doubleDamage")){
						activateMessage += "   " + x.getName() + "'s next attack deals double damage!";
						player1ActiveDouble = true;
					} else if (power.equalsIgnoreCase("autoResist")){
						activateMessage += "   Next damage against " + x.getName() + " is halved!";
						player1ActiveResist = true;
					}
					player1ActivePower = true;
					x.callPowerUps().remove(i);
					turnCounter ++;
				}
			} else {
				activateMessage += "   No power up of that type!";
			}
		} else {
			boolean found = false;
			int i;
			for ( i = 0; i < x.callPowerUps().size() ; i++){
				String activatePower = x.callPowerUps().get(i);
				if (power.equalsIgnoreCase(activatePower)){
					found = true;
					break;
				} else {
					continue;
				}
			}
			if (found){
				if(power.equalsIgnoreCase("instaheal")){
					activateMessage += "   " + x.getName() + " heals " + x.getActiveCard().getName() + " by 200 health!\n";
					x.getActiveCard().takeDamage(-200);
					activateMessage += "   " + x.getActiveCard().getName() + " has now " + x.getActiveCard().getHealth() + " health!";
					x.callPowerUps().remove(i);
					turnCounter ++;
				} else if (player2ActivePower){
					activateMessage += "   " + x.getName() + " already has an active power up! ";
				} else {
					activateMessage += "   " + x.getName() + " activates " + power + "!\n";
					if (power.equalsIgnoreCase("doubleDamage")){
						activateMessage += "   " + x.getName() + "'s next attack deals double damage!";
						player2ActiveDouble = true;
					} else if (power.equalsIgnoreCase("autoResist")){
						activateMessage += "   Next damage against " + x.getName() + " is halved!";
						player2ActiveResist = true;
					}
					player2ActivePower = true;
					x.callPowerUps().remove(i);
					turnCounter ++;
				}
			} else {
				activateMessage += "   No power up of that type!";
			}
		}
		return activateMessage;
	}
	
	/** 
		adds a bot / computer that will instead be playing 
		for the card game
	**/
	public void addComputer(){
		
	}
}
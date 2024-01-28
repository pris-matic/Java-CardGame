/**
The Card class shows information of one of the cards.
and is retrieved when needed.

@author Anthony B. Deocadiz Jr. (232166)
@version November 7, 2023
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

public class Card {
	
	private String cardType;
	private String cardName;
	private int cardHealth;
	private int cardAttackPower;

	/**
		initializes stats of the current card.
		@param t is the card's type
		@param n is the card's name
		@param h is the card's health
		@param p is the card's damage or attack power.
	**/
	public Card (String t, String n, int h, int p){
		cardType = t;
		cardName = n;
		cardHealth = h;
		cardAttackPower = p;
	}
	
	/**
		@return gets the name of the card.
	**/
	public String getName(){
		return cardName;
	}
	
	/**
		@return gets the type of the card (dragon, fairy, ghost).
	**/
	public String getType(){
		return cardType;
	}
	
	/**
		@return gets the current health of the card.
	**/
	public int getHealth(){
		return cardHealth;
	}
	
	/**
		@return gets the damage / attack power of the card.
	**/
	public int getPower(){
		return cardAttackPower;
	}
	
	/**
		@param d is subtracted to the card's health.
	**/
	public void takeDamage(int d){
		cardHealth -= d;
	}
	
}
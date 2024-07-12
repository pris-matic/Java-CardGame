# Java Card Game

## Introduction 
Simple card game with a Graphical User Interface (GUI) in compliance with CSCI 21: Introduction to Programming I final requirement.

I have not discussed the Java language code in my program with anyone other than my instructor or the teaching assistants assigned to this course.

I have not used Java language code obtained from another student, or any other unauthorized source, either modified or unmodified.

If any Java language code or documentation used in my program was obtained from another source, such as a textbook or website, that has been clearly noted with a proper citation in the comments of my program.

Author: Deocadiz, Anthony Jr. B.

## Instructions
note: two (2) players are required in playing this game on the same computer.

- Both Player can insert their names in the fields provided in the GUI, and can have extra modifiers when they start the game.

### Modifiers
Power-up: Enables power-ups for when one of the player's cards has their health below 0
Currently, there are 3 power-ups:
- doubleDamage - doubles the next attack of the player
- autoResist - halves the next incoming damage
- instaHeal - heals the current active card by 200 health

Random: randomizes the initial card draw.
Win Condition: Specify the number of tokens needed by one of the players in order to win. 3 tokens will the default requirement if it is left blank.

### Controls
Attack - Attacks the enemy's card
Swap - Swap the current card to another card based on the player's highest non-active card value, calculated by the card's current health, and its attack.
Activate - (When power-up modifier is activated) Activate the selected power-up, if there's no power-up selected, it will not forfeit the player's turn.

## Gameplay
- Two players take turns in fighting against each other
- There are three different types of cards: Dragon, Fairy, and Ghost

These Card types are resistant or weak against certain types:
- Dragon cards are weak to Fairy cards.
- Fairy cards are weak to Ghost cards.
- Ghost cards are weak to Dragon cards.
If the card is weak against another, they take double damage.

- Dragon cards are resistant to Ghost cards.
- Ghost cards are resistant to Fairy cards.
- Fairy cards are resistant to Dragon cards.
If the card is resistant against another, they take half the damage.

## Additional notes
- Trying to make a bot to play instead of another player. Time until completion: Indefinite
- Current release is only for demo purposes and must NOT be modified in any means.

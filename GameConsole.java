import java.util.Scanner;

/**
Where the game will run and the only thing
the users will see on the terminal.

@author Anthony B. Deocadiz Jr. (232166)
@version November 13, 2023
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


public class GameConsole {

    public static void main(String[] args) {
        // converts args[0] and [1] to the Player class, and args[2] to a boolean value
        Player a = new Player(args[0]);
        Player b = new Player(args[1]);
        Scanner playerChoice = new Scanner(System.in);
        Scanner powerUpChoice = new Scanner(System.in);

        GameMaster gm = null;
        boolean r = false; // random
        boolean p = false; // power ups
        boolean com = false; // computer

        if (args.length == 2){
            gm = new GameMaster(a, b);
        } else if (args.length == 3){
            if (args[2].equals("random")){
                r = true;
            }
            gm = new GameMaster(a, b, r);
        } else if (args.length == 4){
            if (args[2].equals("random")){
                r = true;
            }
            p = Boolean.parseBoolean(args[3]);
            gm = new GameMaster(a, b, r, p);
        } else if (args.length == 5) {
            if (args[2].equals("random")){
                r = true;
            }
            p = Boolean.parseBoolean(args[3]);
            int winCondition = Integer.parseInt(args[4]);
            gm = new GameMaster(a, b, r, p, winCondition);
        } else if (args.length == 6){
            if (args[2].equals("random")){
                r = true;
            }
            p = Boolean.parseBoolean(args[3]);
            int winCondition = Integer.parseInt(args[4]);
            com = Boolean.parseBoolean(args[5]);
            gm = new GameMaster(a, b, r, p, winCondition,com);
        }
            
        System.out.printf("Welcome, %s and %s!\n",a.getName(),b.getName());
        System.out.println("The game begins.");
        
        while (!(a.handIsFull() && b.handIsFull())){
            System.out.println(gm.dealCard());
        }

        // while True loop
        while (!gm.hasWinner()){
            System.out.print("\nSelect Action (Attack | Swap | Power Up) : ");
            String action = playerChoice.nextLine();
            if (action.equalsIgnoreCase("power up") && p == true){
                Player x = null; // to determine who's player's powerup ArrayList will be called
                if (gm.getTurnCount() % 2 == 0){
                    x = b;
                } else {
                    x = a;
                }
                // checks whether the powerUp input is inside the currentPlayer's powerup ArrayList
                System.out.println(gm.play(action));
                if (x.callPowerUps().size() > 0){
                    System.out.print("\n   Choose a power up: ");                
                    String powerUp = powerUpChoice.nextLine();
                    System.out.println(gm.activatePower(powerUp));
                }  
            } else {
                System.out.println(gm.play(action));
            }
                
        }
        playerChoice.close();
        powerUpChoice.close();
    }
}


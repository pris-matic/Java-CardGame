import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
Game GUI for the Card game.

@author Anthony B. Deocadiz Jr. (232166)
@version November 16, 2023
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

public class GameGUI { 

    private JFrame gameFrame; // whole frame

    private JPanel mainGamePanel; // will store all the panels below

    /** 
        these are under the mainGamePanel JPanel
        these hold all of the requirements to run the game
    **/
    private JPanel namePanel;
    private JPanel settingPanel;
    private JPanel turnPanel; 
    private JPanel cardPanel; 

    /** 
        these are under the settingPanel JPanel, it
        contains the config for starting the game
        as well as the actions that will be done by players
    **/
    private JPanel startPanel;
    private JPanel actionPanel;

    /** 
        these are under the cardPanel JPanel, it stores
        the cards of the players, as well as the result of 
        their current move
    **/
    private JPanel activeCardPanel;
    private JPanel textPanel; 
    private JPanel inactiveCardPanel; 

    /** 
        these are under the activeCardPanel JPanel
        shows the active card of the respective players
    **/
    private JPanel player1ActivePanel;
    private JPanel player2ActivePanel; 

    /** 
        these are under the inactiveCardPanel JPanel
        shows the inactive cards of the respective players
    **/
    private JPanel player1InactivePanel;
    private JPanel player2InactivePanel; 
    
    /** 
        these are under the respective player's inactivePanel 
        JPanel which contains the images of the player/s inactive
        cards
    **/
    private JPanel player1CardsPanel;
    // labels that will store images of player 1's inactive cards
    private JLabel p1CardLabel1;
    private JLabel p1CardLabel2;
    private JLabel p1CardLabel3;
    private JLabel p1CardLabel4;


    private JPanel player2CardsPanel;
    // labels that will store images of player 2's inactive cards
    private JLabel p2CardLabel1;
    private JLabel p2CardLabel2;
    private JLabel p2CardLabel3;
    private JLabel p2CardLabel4;

    /** 
        will be under the settingPanel JPanel
    **/
    private JLabel player1Label;
    private JLabel player2Label;
    private JLabel actionLabel;

    private JLabel turnLabel; // will be under the turnPanel JPanel

    /** 
        will be under the respective player's activePanel JPanel
    **/
    private JLabel player1ActiveLabel;
    private JLabel player1ActiveImage;

    private JLabel player2ActiveLabel;
    private JLabel player2ActiveImage;

    /** 
        will be under the respective player's incativePanel JPanel
    **/
    private JLabel player1InactiveLabel;
    private JLabel player2InactiveLabel;
    

    private JTextArea gameText; // text area to display results of actions

    /** 
        text fields for the players' names
    **/
    private JTextField player1Name;
    private JTextField player2Name;

    /** 
        buttons that will be used for the game
        as well as a checkbox to indicate whether
        the game will deal random cards to players
    **/

    // game config buttons
    private JButton startButton;
    private JCheckBox randomCheckBox;
    private JCheckBox powerupCheckBox;
    private JLabel winConditionText;
    private JTextField winCondition;

    // player buttons
    private JButton attackButton;
    private JButton swapButton;
    private JButton powerButton;
    private JComboBox<String> powerupsList;
    
    /** 
        Images for the cards depending on their types
    **/
    private ImageIcon dragon;
    private ImageIcon fairy;
    private ImageIcon ghost;

    private JScrollPane scrollPane; // allows scrolling of a JTextArea when needed

    private GameMaster gm;

    /** 
        the constructor of the GUI, will initialize
        the components of the Card Game's GUI.
    **/
    public GameGUI(){
        
        gameFrame = new JFrame();

        mainGamePanel = new JPanel(new BorderLayout());

        settingPanel = new JPanel(new GridLayout(3,1));
        turnPanel = new JPanel();
        cardPanel = new JPanel(new GridLayout(1,3));

        namePanel = new JPanel();
        startPanel = new JPanel();
        actionPanel = new JPanel();

        activeCardPanel = new JPanel(new GridLayout(2,1));
        textPanel = new JPanel(new GridLayout(1,1));
        inactiveCardPanel = new JPanel(new GridLayout(2,1));

        player1ActivePanel = new JPanel(new GridBagLayout());
        player2ActivePanel = new JPanel(new GridBagLayout());

        player1InactivePanel = new JPanel(new GridBagLayout());
        player2InactivePanel = new JPanel(new GridBagLayout());

        player1CardsPanel = new JPanel();
        player2CardsPanel = new JPanel();

        player1Label = new JLabel("Player 1: ");
        player2Label = new JLabel("Player 2: ");
        actionLabel = new JLabel("Select Action: ");

        turnLabel = new JLabel("Current Turn Number: ",SwingConstants.CENTER);

        player1ActiveLabel = new JLabel("Player 1's Active Card",SwingConstants.CENTER);
        player2ActiveLabel = new JLabel("Player 2's Active Card",SwingConstants.CENTER);

        player1InactiveLabel = new JLabel("Player 1's Inactive Cards",SwingConstants.CENTER);
        player2InactiveLabel = new JLabel("Player 2's Inactive Cards",SwingConstants.CENTER);

        gameText = new JTextArea();

        player1Name = new JTextField(15);
        player2Name = new JTextField(15);

        startButton = new JButton("Start Game");
        randomCheckBox = new JCheckBox("Random");
        powerupCheckBox = new JCheckBox("Power Ups");
        winConditionText = new JLabel("Tokens needed to Win: ");
        winCondition = new JTextField(5);
        
        attackButton = new JButton("Attack");
        swapButton = new JButton("Swap");
        powerButton = new JButton("Activate");
        powerupsList = new JComboBox<>();
    
        scrollPane = new JScrollPane(gameText,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // where images of the active cards will be placed
        player1ActiveImage = new JLabel();
        player2ActiveImage = new JLabel();

        // where images of the inactive cards will be placed
        p1CardLabel1 = new JLabel();
        p1CardLabel2 = new JLabel();
        p1CardLabel3 = new JLabel();
        p1CardLabel4 = new JLabel();

        p2CardLabel1 = new JLabel();
        p2CardLabel2 = new JLabel();
        p2CardLabel3 = new JLabel();
        p2CardLabel4 = new JLabel();

        // images of the card
        dragon = new ImageIcon("dragonCard.png");
        fairy = new ImageIcon("fairyCard.png");
        ghost = new ImageIcon("ghostCard.png");
        
        // buttons disabled when the GUI has just started
        attackButton.setEnabled(false); 
        swapButton.setEnabled(false);
        powerButton.setEnabled(false);
        powerupsList.setEnabled(false);

    }
    
    /** 
        Sets up how the GUI will look, and arranges
        the components properly
    **/
    public void setUpGUI(){

        gameFrame.setSize(800,600);
        gameFrame.setResizable(false);
        gameFrame.setTitle("Card Game");

        // components that are related to the inactive cards of both players

        // sets up GridBagLayout for player 1's inactive cards
        player1InactivePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        GridBagConstraints p1InactiveConstraints = new GridBagConstraints();

        p1InactiveConstraints.gridx = 0;
        p1InactiveConstraints.gridy = 0;
        p1InactiveConstraints.weighty = 1;
        p1InactiveConstraints.anchor = GridBagConstraints.PAGE_END;
        player1InactivePanel.add(player1CardsPanel,p1InactiveConstraints);

        p1InactiveConstraints.gridx = 0;
        p1InactiveConstraints.gridy = 1;
        player1InactivePanel.add(player1InactiveLabel,p1InactiveConstraints);

        inactiveCardPanel.add(player1InactivePanel);

        // sets up GridBagLayout for player 2's inactive cards
        player2InactivePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        GridBagConstraints p2InactiveConstraints = new GridBagConstraints();

        p2InactiveConstraints.gridx = 0;
        p2InactiveConstraints.gridy = 0;
        p2InactiveConstraints.weighty = 1;
        p2InactiveConstraints.anchor = GridBagConstraints.PAGE_END;
        player2InactivePanel.add(player2CardsPanel,p2InactiveConstraints);

        p2InactiveConstraints.gridx = 0;
        p2InactiveConstraints.gridy = 1;
        player2InactivePanel.add(player2InactiveLabel,p2InactiveConstraints);

        inactiveCardPanel.add(player2InactivePanel);

        // components that are related to the active card of each player

        // sets up GridBagLayout for player 1's active card
        player1ActivePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        GridBagConstraints p1ActiveConstraints = new GridBagConstraints();

        p1ActiveConstraints.gridx = 0;
        p1ActiveConstraints.gridy = 0;
        p1ActiveConstraints.weighty = 1;
        p1ActiveConstraints.anchor = GridBagConstraints.PAGE_END;
        player1ActivePanel.add(player1ActiveImage,p1ActiveConstraints);
        
        p1ActiveConstraints.gridx = 0;
        p1ActiveConstraints.gridy = 1;
        player1ActivePanel.add(player1ActiveLabel,p1ActiveConstraints);

        activeCardPanel.add(player1ActivePanel);

        // sets up GridBagLayout for player 2's active card
        player2ActivePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        GridBagConstraints p2ActiveConstraints = new GridBagConstraints();

        p2ActiveConstraints.gridx = 0;
        p2ActiveConstraints.gridy = 0;
        p2ActiveConstraints.weighty = 1;
        p2ActiveConstraints.anchor = GridBagConstraints.PAGE_END;
        player2ActivePanel.add(player2ActiveImage,p2ActiveConstraints);

        p2ActiveConstraints.gridx = 0;
        p2ActiveConstraints.gridy = 1;
        player2ActivePanel.add(player2ActiveLabel,p2ActiveConstraints);

        activeCardPanel.add(player2ActivePanel);
        
        // sets up border for , setting, turn, and card JPanels
        settingPanel.setPreferredSize(new Dimension(800,125));
        settingPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        
        turnPanel.setPreferredSize(new Dimension(800,75));
        turnPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        turnPanel.add(turnLabel);
        
        cardPanel.setPreferredSize(new Dimension(800,400));
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        // sets up borders for the panels under cardPanel

        activeCardPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        cardPanel.add(activeCardPanel);

        textPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        cardPanel.add(textPanel);

        inactiveCardPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        cardPanel.add(inactiveCardPanel);
        
        // sets up components under settingPanel

        namePanel.add(player1Label);
        namePanel.add(player1Name);
        namePanel.add(player2Label);
        namePanel.add(player2Name);

        startPanel.add(randomCheckBox);
        startPanel.add(powerupCheckBox);
        startPanel.add(winConditionText);
        startPanel.add(winCondition);
        startPanel.add(startButton);
        
        actionPanel.add(actionLabel);
        actionPanel.add(attackButton);
        actionPanel.add(swapButton);
        actionPanel.add(powerButton);

        powerupsList.addItem(" // Choose Power up // ");
        actionPanel.add(powerupsList);
        
        settingPanel.add(namePanel);
        settingPanel.add(startPanel);
        settingPanel.add(actionPanel);

        // sets up components under textPanel
        gameText.setEditable(false);
        gameText.setLineWrap(true);
        textPanel.add(scrollPane);
        

        mainGamePanel.add(settingPanel,BorderLayout.NORTH);
        mainGamePanel.add(turnPanel,BorderLayout.CENTER);
        mainGamePanel.add(cardPanel,BorderLayout.SOUTH);

        gameFrame.add(mainGamePanel);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        
    }

    /** 
        will be used to determine the action of
        the players, as well as to determine whether
        the game has started.
    **/
    public void gameButtons(){

        ActionListener startGame = new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent ae){
                Object o = ae.getSource();

                // will enable attack and swap buttons
                if (o == startButton){
                    Player p1 = new Player(player1Name.getText());
                    Player p2 = new Player(player2Name.getText());
                    boolean r = randomCheckBox.isSelected();
                    boolean p = powerupCheckBox.isSelected();
                    
                    // converting content of Jtextfield to an integer
                    String x = winCondition.getText();
                    
                    int wc = 3;

                    if (x.length() > 0){
                        wc = Integer.parseInt(x);
                    }

                    

                    gm = new GameMaster(p1, p2, r, p, wc);

                    attackButton.setEnabled(true);
                    swapButton.setEnabled(true);
                    if (p){
                        powerButton.setEnabled(true);
                        powerupsList.setEnabled(true);
                    }
                    
                    player1ActiveLabel.setText(player1Name.getText()+ "'s Active Card");
                    player2ActiveLabel.setText(player2Name.getText()+ "'s Active Card");

                    player1InactiveLabel.setText(player1Name.getText()+ "'s Inactive Cards");
                    player2InactiveLabel.setText(player2Name.getText()+ "'s Inactive Cards");

                    gameText.setText("Welcome " + p1.getName() + " and " + p2.getName() + "!\n");
                    gameText.append("The game begins.\n");

                    while (!(p1.handIsFull() && p2.handIsFull())){
                        gameText.append(gm.dealCard() + "\n");
                        turnLabel.setText("Current Turn Number: " + gm.getTurnCount());

                    }
                    updateActiveCard();
                    updateInactiveCards();
                    updatePowerList();
                                      
                }
            }
        };
        ActionListener turnOptions = new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent ae){
                Object o = ae.getSource();

                if (o == attackButton) {
                    gameText.append("\n");
                    gameText.append(gm.play("Attack") + "\n");
                    turnLabel.setText("Current Turn Number: " + gm.getTurnCount());
                        
                    // will disable attack and swap button again when game is finished
                    if (gm.hasWinner()){ 
                        turnLabel.setText("Current Turn Number: " + (gm.getTurnCount()-1));
                        attackButton.setEnabled(false);
                        swapButton.setEnabled(false);
                        powerButton.setEnabled(false);
                        powerupsList.setEnabled(false);
                    }

                    updateActiveCard();
                    updateInactiveCards();
                    updatePowerList();
                        
                } else if (o == swapButton){
                    gameText.append("\n");
                    gameText.append(gm.play("Swap") + "\n");
                    turnLabel.setText("Current Turn Number: " + gm.getTurnCount());

                    updateActiveCard();
                    updateInactiveCards();
                    updatePowerList();
                } else if (o == powerButton){
                    gameText.append("\n");
                    Object x = powerupsList.getSelectedItem();
                    String selectedPowerUp = x.toString();
                    gameText.append(gm.activatePower(selectedPowerUp) + "\n");
                    turnLabel.setText("Current Turn Number: " + gm.getTurnCount());
                    updatePowerList();

                }
            }
        };

        
        attackButton.addActionListener(turnOptions);
        swapButton.addActionListener(turnOptions);
        powerButton.addActionListener(turnOptions);
    
        startButton.addActionListener(startGame);
        randomCheckBox.addActionListener(startGame);
        powerupCheckBox.addActionListener(startGame);
  
    }

    /** 
        will be responsible for changing the active 
        card's image, depending on what type it is.
        @param x is the card's type
        @return an icon of the card's type
    **/
    public ImageIcon addMainImage(String x){

        ImageIcon picture = null;

        switch (x) {
            case ("Dragon"):
                picture = dragon;
                break;
        
            case ("Fairy"):
                picture = fairy;
                break;

            case ("Ghost"):
                picture = ghost;
                break;
        }
        return picture;
    }

    /** 
        will be responsible for changing all of
        the images of inactive cards,depending on 
        what type it is.
        @param x is the card's type
        @return an icon of the card's type
    **/
    public ImageIcon addInactiveImage(String x){

        ImageIcon picture = null;

        Image tempDragon = dragon.getImage().getScaledInstance(55, 80, Image.SCALE_SMOOTH);
        Image tempFairy = fairy.getImage().getScaledInstance(55, 80, Image.SCALE_SMOOTH);
        Image tempGhost = ghost.getImage().getScaledInstance(55, 80, Image.SCALE_SMOOTH);

        ImageIcon smallDragon = new ImageIcon(tempDragon);
        ImageIcon smallFairy = new ImageIcon(tempFairy);
        ImageIcon smallGhost = new ImageIcon(tempGhost);

        switch (x) {
            case ("Dragon"):
                picture = smallDragon;
                break;
        
            case ("Fairy"):
                picture = smallFairy;
                break;

            case ("Ghost"):
                picture = smallGhost;
                break;
        }
        return picture;
    }
    
    /**
        Updates the image of the active card for both 
        players whenever an action is made.
    **/
    public void updateActiveCard(){

        player1ActiveImage.setIcon(addMainImage(gm.callPlayer1().getActiveCard().getType()));
        player2ActiveImage.setIcon(addMainImage(gm.callPlayer2().getActiveCard().getType()));
        gameFrame.revalidate();
        gameFrame.repaint();

    }

    /** 
        Updates the images of all the inactive cards 
        for both players whenever an action is made.
    **/
    public void updateInactiveCards(){
        
        // updates the inactive cards of player 1
        p1CardLabel1.setIcon(addInactiveImage(gm.callPlayer1().callCards().get(1).getType()));
        player1CardsPanel.add(p1CardLabel1);

        p1CardLabel2.setIcon(addInactiveImage(gm.callPlayer1().callCards().get(2).getType()));
        player1CardsPanel.add(p1CardLabel2);

        p1CardLabel3.setIcon(addInactiveImage(gm.callPlayer1().callCards().get(3).getType()));
        player1CardsPanel.add(p1CardLabel3);

        p1CardLabel4.setIcon(addInactiveImage(gm.callPlayer1().callCards().get(4).getType()));
        player1CardsPanel.add(p1CardLabel4);

        // updates the inactive cards of player 2
        p2CardLabel1.setIcon(addInactiveImage(gm.callPlayer2().callCards().get(1).getType()));
        player2CardsPanel.add(p2CardLabel1);

        p2CardLabel2.setIcon(addInactiveImage(gm.callPlayer2().callCards().get(2).getType()));
        player2CardsPanel.add(p2CardLabel2);

        p2CardLabel3.setIcon(addInactiveImage(gm.callPlayer2().callCards().get(3).getType()));
        player2CardsPanel.add(p2CardLabel3);

        p2CardLabel4.setIcon(addInactiveImage(gm.callPlayer2().callCards().get(4).getType()));
        player2CardsPanel.add(p2CardLabel4);

        gameFrame.revalidate();
        gameFrame.repaint();

    }
    /**
        displays the power ups that the player acting on the
        current turn owns which can then be activated.
    **/
    public void updatePowerList(){

        Player x = null; // 
        if (gm.getTurnCount() % 2 == 0){ // determines who's turn it is.
            x = gm.callPlayer2();
        } else {
            x = gm.callPlayer1();
        }
        powerupsList.removeAllItems();
        powerupsList.addItem(" // Choose Power up // ");
        
        for (int i = 0 ; i < x.callPowerUps().size() ; i++){
            powerupsList.addItem(x.callPowerUps().get(i));
        }

        gameFrame.revalidate();
        gameFrame.repaint();
    }
}
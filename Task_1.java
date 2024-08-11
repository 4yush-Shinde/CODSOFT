package codsoft;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Task_1 {
    private static int randomNumber;
    private static int attempts;
    private static int maxAttempts = 5;
    private static int totalRounds = 0;
    private static int totalAttempts = 0;
    
    

    public static void main(String[] args) {

    	JFrame frame = new JFrame("Number Guessing Game");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       
        JLabel instructionLabel = new JLabel("Guess a number between 1 and 100:");
        JTextField guessField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        JLabel feedbackLabel = new JLabel("");
        JButton playAgainButton = new JButton("Play Again");
        JButton hintButton = new JButton("Hint");

        playAgainButton.setVisible(false);

        
        JPanel panel = new JPanel();
        panel.add(instructionLabel);
        panel.add(guessField);
        panel.add(guessButton);
        panel.add(hintButton);
        panel.add(feedbackLabel);
        panel.add(playAgainButton);
        frame.add(panel);

        
        generateRandomNumber();

        
        guessButton.addActionListener(new ActionListener() {	// Guess
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int guess = Integer.parseInt(guessField.getText());
                    attempts++;
                    if (guess < randomNumber) {
                        feedbackLabel.setText("The Number you Guessed is Low! Attempts left: " + (maxAttempts - attempts));
                    } else if (guess > randomNumber) {
                        feedbackLabel.setText("The Number you Guessed is High! Attempts left: " + (maxAttempts - attempts));
                    } else {
                        feedbackLabel.setText("Correct! You guessed it in " + attempts + " attempts.");
                        totalAttempts += attempts;
                        guessButton.setEnabled(false);
                        playAgainButton.setVisible(true);
                    }

                    if (attempts >= maxAttempts && guess != randomNumber) {
                        feedbackLabel.setText("Sorry, you've used all attempts. The correct number was " + randomNumber);
                        guessButton.setEnabled(false);
                        playAgainButton.setVisible(true);
                    }
                } catch (NumberFormatException ex) {
                    feedbackLabel.setText("Please enter a valid number.");
                }
            }
        });


        
        playAgainButton.addActionListener(new ActionListener() {	// Play Again
            @Override
            public void actionPerformed(ActionEvent e) {
                totalRounds++;
                attempts = 0;
                guessField.setText("");
                feedbackLabel.setText("");
                guessButton.setEnabled(true);
                playAgainButton.setVisible(false);
                generateRandomNumber();
            }
        });
        
        
        
        
        hintButton.addActionListener(new ActionListener() {			// Hint
            @Override
            public void actionPerformed(ActionEvent e) {

            	if (randomNumber < 11 && randomNumber >= 1 ) 
            	{
                    feedbackLabel.setText("Number Is Between 1 to 10");
            	} 
            	
            	else if (randomNumber < 21 && randomNumber >= 11 ) 
            	{
                    feedbackLabel.setText("Number Is Between 11 to 20");
            	} 
            	
            	else if (randomNumber < 31 && randomNumber >= 21 ) 
            	{
                    feedbackLabel.setText("Number Is Between 21 to 30");
            	} 
            	
            	else if (randomNumber < 41 && randomNumber >= 31 ) 
            	{
                    feedbackLabel.setText("Number Is Between 31 to 40");
            	} 
            	
            	else if (randomNumber < 51 && randomNumber >= 41 ) 
            	{
                    feedbackLabel.setText("Number Is Between 41 to 50");
            	} 
            	
            	else if (randomNumber < 61 && randomNumber >= 51 ) 
            	{
                    feedbackLabel.setText("Number Is Between 51 to 60");
            	} 
            	
            	else if (randomNumber < 71 && randomNumber >= 61 ) 
            	{
                    feedbackLabel.setText("Number Is Between 61 to 70");
            	} 
            	
            	else if (randomNumber < 81 && randomNumber >= 71 ) 
            	{
                    feedbackLabel.setText("Number Is Between 71 to 80");
            	} 
            	
            	else if (randomNumber < 91 && randomNumber >= 81 ) 
            	{
                    feedbackLabel.setText("Number Is Between 81 to 90");
            	} 
            	
            	else if (randomNumber < 101 && randomNumber >= 91 ) 
            	{
                    feedbackLabel.setText("Number Is Between 91 to 100");
            	} 
            	
            }
        });
        

        
        frame.setVisible(true);
    }

    private static void generateRandomNumber() {
        Random rand = new Random();
        randomNumber = rand.nextInt(100) + 1;
    }
}

package codsoft;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Task_2 extends JFrame {
	private int english;
	private int marathi;
	private int hindi;
	private int history;
	private int geography;
	private int maths;
	private int science;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Student Grade Calculator");
		frame.setSize(1540, 500);
		
		// Main Heading
		JLabel mainLabel = new JLabel("Enter Marks Of Each Subject Out Of 100");

		
		JLabel englishLabel = new JLabel("English");
        JTextField englishField = new JTextField(10);

        
        JLabel marathiLabel = new JLabel("Marathi");
        JTextField marathiField = new JTextField(10);
        
        
        JLabel hindiLabel = new JLabel("Hindi");
        JTextField hindiField = new JTextField(10);
        
        
        JLabel scienceLabel = new JLabel("Science");
        JTextField scienceField = new JTextField(10);
        
        
        JLabel mathsLabel = new JLabel("Maths");
        JTextField mathsField = new JTextField(10);
        
        
        JLabel geographyLabel = new JLabel("Geography");
        JTextField geographyField = new JTextField(10);
        
        
        JLabel historyLabel = new JLabel("History");
        JTextField historyField = new JTextField(10);
        
            
	    JButton calculateButton = new JButton("Calculate");
	    JLabel feedbackLabel = new JLabel();
	    JTextField total = new JTextField();
	       
	    JPanel panel = new JPanel();
	    panel.add(mainLabel);
	    panel.add(englishLabel);
	    panel.add(englishField);
	    panel.add(marathiLabel);
	    panel.add(marathiField);
	    panel.add(hindiLabel);
	    panel.add(hindiField);
	    panel.add(scienceLabel);
	    panel.add(scienceField);
	    panel.add(mathsLabel);
	    panel.add(mathsField);
	    panel.add(geographyLabel);
	    panel.add(geographyField);
	    panel.add(historyLabel);
	    panel.add(historyField);
	    panel.add(calculateButton);
	    panel.add(feedbackLabel);
	    panel.add(total);
	    frame.add(panel);
	    
	    calculateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int englishMarks = Integer.parseInt(englishField.getText());
				int hindiMarks = Integer.parseInt(hindiField.getText());
				int marathiMarks = Integer.parseInt(marathiField.getText());
				int scienceMarks = Integer.parseInt(scienceField.getText());
				int mathsMarks = Integer.parseInt(mathsField.getText());
				int geographyMarks = Integer.parseInt(geographyField.getText());
				int historyMarks = Integer.parseInt(historyField.getText());
				
				
				// Total Marks
				int res = englishMarks + hindiMarks + marathiMarks + scienceMarks + mathsMarks + geographyMarks + historyMarks;
                total.setText("Total Marks = "+res);
				
                
                
                // Average
                int average = res/7;
                feedbackLabel.setText("Average Percentage = "+average+"%");
                
                
                // Grades
                if (average > 90 && average < 101)
                {
                    feedbackLabel.setText("Outstanding!! You Got A+ ");
                }
                
                else if(average > 80 && average < 91)
                {
                    feedbackLabel.setText("Outstanding!! You Got A ");
                }
                
                else if(average > 74 && average < 81)
                {
                    feedbackLabel.setText("Congrats!! You Got A- ");
                }
                
                else if(average > 70 && average < 75)
                {
                    feedbackLabel.setText("Well Done You Got B+ ");
                }
                
                else if(average > 60 && average < 71)
                {
                    feedbackLabel.setText("Well Done You Got B ");
                }
                
                else if(average > 54 && average < 61)
                {
                    feedbackLabel.setText("Well Done You Got B- ");
                }
                
                else if(average > 50 && average < 55)
                {
                    feedbackLabel.setText("You Got C+ You Can Try Hard");
                }
                
                else if(average > 40 && average < 51)
                {
                    feedbackLabel.setText("You Got C You Can Try Hard");
                }
                
                else if(average > 32 && average < 41)
                {
                    feedbackLabel.setText("You Got D Can Do Better");
                }
                
                else if(average > 20 && average < 33)
                {
                    feedbackLabel.setText("You Got E ");
                }
                
                else if(average < 21)
                {
                    feedbackLabel.setText("You Got F ");
                }
                
                else {
                    feedbackLabel.setText("Enter Valid Numbers and Check if you have Entered m");
                }
                
				
                



			}
	    	
	    });
	    
        frame.setVisible(true);


	}

}

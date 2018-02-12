package solarSystemQuiz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * The SolarSystemQuiz class creates a quiz with a number of questions. The user inputs
 * their answers into a text field. Once the user clicks a submit button, a 
 * messagebox tells the user whether they are correct. The user is allowed unlimited 
 * attempts for each question and can also restart the quiz when they get to the end.
 * 
 * @author Sadhana Yatapanage
 * <p>
 * Created on: 10-02-2018
 */

public class SolarSystemQuiz {

	private JFrame frame;
	private JTextField textField;
	private static int count; 
	private static int newcount;
	private static String[] question;
	private static String[] answercaps;
	private static String[] answer;
	private static int scorecount;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		count = 0;
		scorecount = 0;
		question = new String[6];
		question[0] = "Question 1: What is the largest planet in our solar system?";
		question[1] = "Question 2: Which planet has the strongest winds?";
		question[2] = "Question 3: What is the hottest planet in our solar system?";
		question[3] = "Question 4: Which planet spins on its side?";
		question[4] = "Question 5: Which planet has a moon named Titan?";
		question[5] = "";
		
		answercaps = new String[5];
		answercaps[0] = "Jupiter";
		answercaps[1] = "Neptune";
		answercaps[2] = "Venus";
		answercaps[3] = "Uranus";
		answercaps[4] = "Saturn";
		
		answer = new String[5];
		answer[0] = "jupiter";
		answer[1] = "neptune";
		answer[2] = "venus";
		answer[3] = "uranus";
		answer[4] = "saturn";
		
		scorecount = 0;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolarSystemQuiz window = new SolarSystemQuiz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creates the application.
	 */
	public SolarSystemQuiz() {
		initialize();
	}

	/**
	 * Initializes the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.setBounds(100, 100, 671, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(240, 248, 255));;
		
		//Creates the text field for the user to input their answer.
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(220, 204, 150, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		//Creates the label for the questions.
		JLabel lblQuestion = new JLabel("");
		lblQuestion.setForeground(new Color(153, 51, 153));
		lblQuestion.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQuestion.setBounds(102, 145, 543, 23);
		frame.getContentPane().add(lblQuestion);
		
		//Creates the label stating 'Answer'.
		JLabel lblAnswer = new JLabel("Answer:");
		lblAnswer.setForeground(new Color(0, 0, 255));
		lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnswer.setBounds(153, 206, 57, 17);
		frame.getContentPane().add(lblAnswer);
		
		//Creates the label to tell the user they have finished the quiz.
		JLabel lblEnd = new JLabel("You've finished the quiz! Your score is: ");
		lblEnd.setForeground(new Color(0, 0, 255));
		lblEnd.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEnd.setBounds(153, 82, 330, 29);
		frame.getContentPane().add(lblEnd);
		lblEnd.setVisible(false);
		
		//Creates the label to tell the user their score.
		JLabel lblScore = new JLabel("");
		lblScore.setForeground(new Color(0, 0, 255));
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblScore.setBounds(275, 123, 95, 29);
		frame.getContentPane().add(lblScore);
		lblScore.setVisible(false);
		
		//Creates the title label.
		JLabel lblTitle = new JLabel("SOLAR SYSTEM QUIZ");
		lblTitle.setForeground(new Color(199, 21, 133));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setBounds(208, 11, 204, 20);
		frame.getContentPane().add(lblTitle);
		
		//Creates the instructions label.
		JLabel lblInstructions = new JLabel("Click the 'Question' button to begin and to move "
				+ "onto the next question if you're stuck.");
		lblInstructions.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInstructions.setForeground(new Color(0, 0, 255));
		lblInstructions.setBounds(20, 42, 613, 29);
		frame.getContentPane().add(lblInstructions);
		
		//Creates the submit button.
		JButton btnSubmit = new JButton("Submit");

		//Creates the answers button. When clicked, it lists the answers in red.
		JButton btnAnswers = new JButton("Answers");
		btnAnswers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, new JLabel(
					"<html>Q1: What is the largest planet in our solar system? "
					+ "<font color='red'>Jupiter</font><br/>"
					+ "Q2: Which planet has the strongest winds? "
					+ "<font color='red'>Neptune</font><br/>"
					+ "Q3: What is the hottest planet in our solar system? "
					+ "<font color='red'>Venus</font><br/>"
					+ "Q4: Which planet spins on its side? <font color='red'>Uranus</font><br/>"
					+ "Q5: Which planet has a moon named Titan? "
					+ "<font color='red'>Saturn</font></html>"));
			}
		});
		btnAnswers.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAnswers.setBounds(177, 186, 89, 23);
		frame.getContentPane().add(btnAnswers);
		btnAnswers.setVisible(false);
		
		//Creates the new question button.
		JButton btnNewQ = new JButton("Question");
		
		//Creates the button to restart the quiz.
		JButton btnRestart = new JButton("Restart");
		btnRestart.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSubmit.setVisible(true);
				lblAnswer.setVisible(true);
				textField.setVisible(true);
				btnNewQ.setVisible(true);
				lblEnd.setVisible(false);
				lblScore.setVisible(false);
				btnAnswers.setVisible(false);
				lblInstructions.setVisible(true);
				btnRestart.setVisible(false);
				count = 0;
			}
		});
		btnRestart.setBounds(323, 187, 89, 23);
		frame.getContentPane().add(btnRestart);
		btnRestart.setVisible(false);

		//Makes the new question button move onto the next question when clicked.
		btnNewQ.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				lblQuestion.setText(question[count]);
				count += 1;
				if(count > 5){
					count = 5;
					btnSubmit.setVisible(false);
					lblAnswer.setVisible(false);
					textField.setVisible(false);
					btnNewQ.setVisible(false);
					lblEnd.setVisible(true);
					lblScore.setVisible(true);
					btnAnswers.setVisible(true);
					btnRestart.setVisible(true);
					lblInstructions.setVisible(false);
					lblScore.setText("" + scorecount + " / 5");
				}
			}
		});
		btnNewQ.setBounds(228, 82, 142, 29);
		frame.getContentPane().add(btnNewQ);
		
		//Tests whether the answer in the text field is correct.
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String value = textField.getText();
				newcount = count-1;
		        if(newcount != -1 && (value.equals(answer[newcount]) 
		        		|| value.equals(answercaps[newcount]))){
					JOptionPane.showMessageDialog(null, "Correct!");
					textField.setText("");
					lblQuestion.setText(question[count]);
					count += 1;
					scorecount +=1;
					if(count > 5){
						count = 5;
						btnSubmit.setVisible(false);
						lblAnswer.setVisible(false);
						textField.setVisible(false);
						btnNewQ.setVisible(false);
						lblEnd.setVisible(true);
						lblScore.setVisible(true);
						btnAnswers.setVisible(true);
						btnRestart.setVisible(true);
						lblInstructions.setVisible(false);
						lblScore.setText("" + scorecount + " / 5");
					}
		        }
		        else{
					JOptionPane.showMessageDialog(null, "Incorrect. Please try again.");
		        }
			}
		});
		btnSubmit.setBounds(380, 205, 111, 23);
		frame.getContentPane().add(btnSubmit);
		

		
	}
}


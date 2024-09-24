import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class StonePaperScissorsGame extends JFrame implements ActionListener {

    private JLabel resultLabel;
    private JButton stoneButton, paperButton, scissorsButton;
    private JLabel userChoiceLabel, computerChoiceLabel;

    public StonePaperScissorsGame() {
        // Frame settings
        setTitle("Stone Paper Scissors Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Result display
        resultLabel = new JLabel("Choose: Stone, Paper, or Scissors");
        add(resultLabel);

        // Buttons
        stoneButton = new JButton("Stone");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");

        add(stoneButton);
        add(paperButton);
        add(scissorsButton);

        // Labels for choices
        userChoiceLabel = new JLabel("Your choice: ");
        computerChoiceLabel = new JLabel("Computer choice: ");
        add(userChoiceLabel);
        add(computerChoiceLabel);

        // Button actions
        stoneButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] choices = {"Stone", "Paper", "Scissors"};
        Random random = new Random();
        int computerChoice = random.nextInt(3);

        String userChoice = "";
        if (e.getSource() == stoneButton) {
            userChoice = "Stone";
        } else if (e.getSource() == paperButton) {
            userChoice = "Paper";
        } else if (e.getSource() == scissorsButton) {
            userChoice = "Scissors";
        }

        // Update choice labels
        userChoiceLabel.setText("Your choice: " + userChoice);
        computerChoiceLabel.setText("Computer choice: " + choices[computerChoice]);

        // Determine result
        if (userChoice.equals(choices[computerChoice])) {
            resultLabel.setText("It's a Tie!");
        } else if ((userChoice.equals("Stone") && choices[computerChoice].equals("Scissors")) ||
                (userChoice.equals("Paper") && choices[computerChoice].equals("Stone")) ||
                (userChoice.equals("Scissors") && choices[computerChoice].equals("Paper"))) {
            resultLabel.setText("You Win!");
        } else {
            resultLabel.setText("You Lose!");
        }
    }

    public static void main(String[] args) {
        // Run the game
        StonePaperScissorsGame game = new StonePaperScissorsGame();
        game.setVisible(true);
    }
}

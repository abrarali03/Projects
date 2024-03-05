import javax.swing.JOptionPane;
import java.util.Random;

public class challenge5 {

    public static void main(String[] args) {
        startGame();
    }
    public static void startGame(){
        while (true){
            int computerChoice = computerChoice(); //stores computer choice as int after calling the computerChoice method
            String playerChoice = playerChoice(); //stores player choice as string after calling the playerChoice method

            JOptionPane.showMessageDialog(null, "The computer's choice is " +convertCompChoice(computerChoice)+".");
            JOptionPane.showMessageDialog(null, "Your choice was "+playerChoice+".");

            int outcome = gameOutcome(playerChoice, computerChoice); // gets the outcome of the two choices by calling gameOutcome() and sending the two arguments

            if(outcome ==1 ){ //tied
                JOptionPane.showMessageDialog(null, "It's a tie. Play again!");
            } else if (outcome == 2) { //computer wins
                JOptionPane.showMessageDialog(null, "You Lost!");
            }else { //user wins
                JOptionPane.showMessageDialog(null, "You Win!");
            }
            String playAgain = JOptionPane.showInputDialog(null, "Do you want to play again(yes/no)? ");
            if(playAgain.equalsIgnoreCase("no")){
                JOptionPane.showMessageDialog(null, "Thanks for playing!");
                break;
            }
        }
    }
    public static int computerChoice(){ //creates the random number for the computer (1=rock,2=paper,3=scissors)
        Random randomNum = new Random();
        int computerNum = randomNum.nextInt(3) + 1;
        return computerNum;
    }
    public static String playerChoice(){
        String user_choice = JOptionPane.showInputDialog(null, "Enter rock, paper, or scissors: ");
        user_choice = user_choice.toLowerCase();
        return user_choice;
    }

    public static String convertCompChoice(int computerNum) { //converts the random computer number to a string
        String convertedChoice = "";
        if (computerNum == 1) {
            convertedChoice = "rock";
        } else if (computerNum == 2) {
            convertedChoice = "paper";
        }else {
            convertedChoice = "scissors";
        }
        return convertedChoice;
    }

    public static int gameOutcome(String playerChoice, int computerChoice){ //decides who wins the game by accepting the player input and random computer number
        String convertCompChoice = convertCompChoice(computerChoice); //converts random computer number to a string by using the converting method
        int outcome;
        if(playerChoice.equals(convertCompChoice)){
            outcome = 1;//tied
        }else if(playerChoice.equalsIgnoreCase("rock") && convertCompChoice.equalsIgnoreCase("paper")
                || playerChoice.equalsIgnoreCase("paper") && convertCompChoice.equalsIgnoreCase("scissors")
                ||playerChoice.equalsIgnoreCase("scissors") && convertCompChoice.equalsIgnoreCase("rock")){
            outcome = 2;//computer wins
        }else{
            outcome = 3;//user wins
        }
        return outcome;
    }
}

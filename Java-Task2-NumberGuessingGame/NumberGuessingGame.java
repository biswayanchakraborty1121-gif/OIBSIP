
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        ArrayList<String> scoreHistory = new ArrayList<>();

        System.out.println("================================");
        System.out.println("       NUMBER GUESSING GAME");
        System.out.println("================================");

        // Select difficulty level
        System.out.println("\nSelect Difficulty:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        int maxNumber;
        int maxAttempts;

        switch (choice) {

            case 1:
                maxNumber = 50;
                maxAttempts = 10;
                break;

            case 2:
                maxNumber = 100;
                maxAttempts = 7;
                break;

            case 3:
                maxNumber = 200;
                maxAttempts = 5;
                break;

            default:
                System.out.println("Invalid choice! Selecting Medium.");
                maxNumber = 100;
                maxAttempts = 7;
        }

        int round = 1;
        String playAgain;

        // Play multiple rounds
        do {

            int secretNumber = random.nextInt(maxNumber) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n================================");
            System.out.println("Round: " + round);
            System.out.println("Guess a number between 1 and " + maxNumber);
            System.out.println("You have " + maxAttempts + " attempts.");
            System.out.println("================================");

            // Guessing process
            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");
                int guess;

while (true) {

    if (sc.hasNextInt()) {

        guess = sc.nextInt();

        if (guess >= 1 && guess <= maxNumber) {
            break;
        } else {
            System.out.println("Please enter a number between 1 and " + maxNumber);
        }

    } else {

        System.out.println("Invalid input! Please enter a number.");
        sc.next();
    }
}

                attempts++;

                if (guess == secretNumber) {

                    System.out.println("\nCorrect! You guessed the number!");
                    System.out.println("Attempts used: " + attempts);

                    guessedCorrectly = true;
                    break;

                } else if (guess > secretNumber) {

                    System.out.println("Too High! Try a smaller number.");

                } else {

                    System.out.println("Too Low! Try a larger number.");

                }

                System.out.println("Attempts remaining: "
                        + (maxAttempts - attempts));
            }

            // Win or lose result
            if (guessedCorrectly) {

                scoreHistory.add("Round " + round
                        + " - Guessed in " + attempts + " attempts");

            } else {

                System.out.println("\nYou Lost!");
                System.out.println("The correct number was: " + secretNumber);

                scoreHistory.add("Round " + round + " - Not guessed");
            }

            // Display score history
            System.out.println("\n========== SCORE HISTORY ==========");

            for (String score : scoreHistory) {
                System.out.println(score);
            }

            System.out.println("===================================");

            round++;

            System.out.print("\nDo you want to play again? (yes/no): ");
            while (true) {

    playAgain = sc.next().toLowerCase();

    if (playAgain.equals("yes") || playAgain.equals("no")) {
        break;
    } else {
        System.out.print("Invalid choice! Please enter yes or no: ");
    }
}

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\n================================");
        System.out.println("       THANKS FOR PLAYING!");
        System.out.println("================================");

        System.out.println("Total rounds played: " + (round - 1));

        sc.close();
    }
}

// Author: Het Patel
// Date: july 5, 2024
// File Name: BowlingGame

import java.util.Scanner;

public class BowlingGame {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            String player1Name = getPlayerName(1);
            String player2Name = getPlayerName(2);

            int[] player1Scores = new int[10];
            int[] player2Scores = new int[10];

            for (int frame = 0; frame < 10; frame++) {
                player1Scores[frame] = getFrameScore(player1Name);
                player2Scores[frame] = getFrameScore(player2Name);
            }

            displayGameResults(player1Name, player2Name, player1Scores, player2Scores);
        } while (playAnotherGame());
    }

    private static String getPlayerName(int playerNumber) {
        System.out.print("Enter player " + playerNumber + "'s name: ");
        return scanner.nextLine();
    }

    private static int getRollScore(String playerName) {
        int score;
        do {
            System.out.print("Enter score for " + playerName + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer between 0 and 10.");
                scanner.next(); // consume the invalid input
            }
            score = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over
            if (score < 0 || score > 10) {
                System.out.println("Invalid score. Please enter a score between 0 and 10.");
            }
        } while (score < 0 || score > 10);
        return score;
    }

    private static int getFrameScore(String playerName) {
        int firstRoll = getRollScore(playerName);
        int secondRoll = 0;
        if (firstRoll != 10) {
            do {
                secondRoll = getRollScore(playerName);
                if (firstRoll + secondRoll > 10) {
                    System.out.println("Invalid score. The total score for the frame cannot exceed 10. Please re-enter the second roll.");
                }
            } while (firstRoll + secondRoll > 10);
        }
        return firstRoll + secondRoll;
    }

    private static void displayGameResults(String player1Name, String player2Name, int[] player1Scores, int[] player2Scores) {
        int player1Total = 0;
        int player2Total = 0;
        System.out.println("Game Results:");
        System.out.printf("  Frame | %-10s | %-10s%n", player1Name, player2Name);
        for (int frame = 0; frame < 10; frame++) {
            player1Total += player1Scores[frame];
            player2Total += player2Scores[frame];
            System.out.printf("  %5d | %10d | %10d%n", frame + 1, player1Scores[frame], player2Scores[frame]);
        }
        System.out.printf("  Total | %10d | %10d%n", player1Total, player2Total);
        if (player1Total > player2Total) {
            System.out.println(player1Name + " wins!");
        } else if (player2Total > player1Total) {
            System.out.println(player2Name + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    private static boolean playAnotherGame() {
        System.out.print("Do you want to play another game? (yes/no): ");
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("yes");
    }
}

// Author: Het Patel
// Date: june 14, 2024
// File Name: sieve method
// Description: The output of this program will be all prime numbers up to a user-specified limit using the prime numbers.

import java.util.Scanner;

public class PrimeNumberAnalyz {
    public static void main(String[] args) {
        int upperBound = 0;
        Scanner sc = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter an upper bound (2-1000): ");
            if (sc.hasNextInt()) {
                upperBound = sc.nextInt();
                if (upperBound >= 2 && upperBound <= 1000) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a number between 2 and 1000.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.next();
            }
        }
        sc.close();

        // Find the total numbers of Prime Number between 2 and upperbound
        int primeCount = 0;
        for (int i = 2; i <= upperBound; i++) {
            if (isPrime(i)) {
                primeCount++;
            }
        }

        // Create the prime number array
        int[] primeNumbers = new int[primeCount];

        // Store values into array
        int index = 0;
        for (int i = 2; i <= upperBound; i++) {
            if (isPrime(i)) {
                primeNumbers[index++] = i;
            }
        }
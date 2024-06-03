import java.util.Scanner;

/**
 * @author Het Patel
 * 2024-06-03
 */

public class projectiles {

    public static void main(String[] args) {
        // Constants
        final int GRAVITY = -9810; // Scale gravity by 1000 to handle integer arithmetic

        // Create a scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Variables to store user inputs
        int angle = 0;
        int velocity = 0;
        int time = 0;

        // Prompt for angle and validate
        while (true) {
            System.out.print("Enter the initial angle (in degrees): ");
            if (scanner.hasNextInt()) {
                angle = scanner.nextInt();
                if (angle > 0) break;
            }
            scanner.nextLine(); // clear invalid input
            System.out.println("Please enter a positive number for the angle.");
        }

        // Prompt for velocity and validate
        while (true) {
            System.out.print("Enter the initial velocity (in m/s): ");
            if (scanner.hasNextInt()) {
                velocity = scanner.nextInt();
                if (velocity > 0) break;
            }
            scanner.nextLine(); // clear invalid input
            System.out.println("Please enter a positive number for the velocity.");
        }

        // Prompt for time and validate
        while (true) {
            System.out.print("Enter the time (in seconds): ");
            if (scanner.hasNextInt()) {
                time = scanner.nextInt();
                if (time > 0) break;
            }
            scanner.nextLine(); // clear invalid input
            System.out.println("Please enter a positive number for the time.");
        }

        // Convert angle to radians (scaled by 1000 for integer arithmetic)
        double angleRadians = Math.toRadians(angle);
        int angleRadiansScaled = (int) (angleRadians * 1000);

        // Calculate horizontal distance (scaled by 1000)
        int d_x = (int) ((velocity * Math.cos(angleRadiansScaled / 1000.0)) * time * 1000);

        // Calculate vertical distance (scaled by 1000)
        int d_y = (int) ((velocity * Math.sin(angleRadiansScaled / 1000.0)) * time * 1000 + 0.5 * GRAVITY * time * time / 1000);

        // Convert results back to normal scale (divide by 1000)
        d_x = d_x / 1000;
        d_y = d_y / 1000;

        // Display results
        System.out.println("At time " + time + " seconds:");
        System.out.println("Horizontal distance (d_x): " + d_x + " meters");
        System.out.println("Vertical distance (d_y): " + d_y + " meters");

        // Close the scanner
        scanner.close();
    }
}
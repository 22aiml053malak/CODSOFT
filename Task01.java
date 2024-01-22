
//I am going to add explaination of each and every line
//class Task01 is having Random generator in that we have a method which is gen
import java.util.Scanner;

class Task01 {
    public static class RandomGenerator {
        public int gen(int max, int min) {
            // What is this gen doing here:-{ it will genrate a random number byvthe given
            // range }
            return (int) (Math.random() * (max - min + 1) + min);
        }
    }

    // main method the entry gate of a java program which is having scanner class
    // for the inputs.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // object rg for random genrator
        RandomGenerator rg = new RandomGenerator();
        int totalAttempts = 0;
        // initializing with zeros
        int win = 0;

        // our loop which is having our game logic
        while (true) {
            System.out.println("Enter the Maximum Number:");
            int max = sc.nextInt();
            System.out.println("Enter the Minimum Number:");
            int min = sc.nextInt();
            int cn = rg.gen(max, min);
            int attempts = 0;

            while (true) {
                System.out.print("Guess Your Number between " + max + " and " + min + ": ");
                int gn = sc.nextInt();
                attempts++;

                // if genrated number is bigger then our number so pring its greater else if
                // lower and if its the same then print yo won.
                if (gn > cn) {
                    System.out.println("It is greater");
                } else if (gn < cn) {
                    System.out.println("It is lower");
                } else {
                    System.out.println("Congrats You Won!!");
                    win++;
                    break;
                }
            }

            // printing attemps and wins
            totalAttempts += attempts;
            System.out.println("Attempts = " + attempts);
            System.out.println("Win = " + win);

            if (totalAttempts > 0) {
                // logic for winning rate
                float winRate = ((float) win / totalAttempts) * 100;
                System.out.printf("Your Winning Rate Is %.2f%%\n", winRate);
            } else {
                System.out.println("Your Winning Rate Is 0.00%");
            }

            // asking for play again if no then exit.
            System.out.println("Do you want to play it again? yes or No :");
            String answer = sc.next();

            if (!answer.equalsIgnoreCase("yes")) {
                System.out.println("Thank you for playing!");
                System.out.println("This is Task01 codsoft");
                // created by Malak Soni
                // This was our Task01 the number game thank you.

                System.exit(0);
            }
        }
    }
}

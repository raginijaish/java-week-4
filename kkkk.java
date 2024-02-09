import java.util.Scanner;

public class kkkk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Haunted House Adventure Game!");
        System.out.println("You find yourself standing in front of a mysterious haunted house. Will you enter? (yes/no)");

        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("yes")) {
            System.out.println("You enter the house and the door slams shut behind you. You're now trapped inside!");
            exploreHouse(scanner);
        } else {
            System.out.println("You decide not to enter the house. Game over.");
        }

        scanner.close();
    }

    public static void exploreHouse(Scanner scanner) {
        System.out.println("You find yourself in the foyer of the house. There are three doors in front of you labeled '1', '2', and '3'.");
        System.out.println("Which door do you choose?");
        int doorChoice = getUserChoice(scanner, 3);

        switch (doorChoice) {
            case 1:
                System.out.println("You chose door 1. You find a dark hallway. Do you want to continue? (yes/no)");
                String continueChoice1 = scanner.nextLine().toLowerCase();
                if (continueChoice1.equals("yes")) {
                    System.out.println("You continue down the hallway and encounter a ghost! Game over.");
                } else {
                    System.out.println("You decide not to continue down the hallway. You return to the foyer.");
                    exploreHouse(scanner);
                }
                break;
            case 2:
                System.out.println("You chose door 2. You find a room full of treasure! Congratulations, you win!");
                break;
            case 3:
                System.out.println("You chose door 3. You find a staircase leading down to the basement. Do you want to go down? (yes/no)");
                String continueChoice3 = scanner.nextLine().toLowerCase();
                if (continueChoice3.equals("yes")) {
                    System.out.println("You go down to the basement and find a hidden passage. You escape the house and win!");
                } else {
                    System.out.println("You decide not to go down to the basement. You return to the foyer.");
                    exploreHouse(scanner);
                }
                break;
            default:
                System.out.println("Invalid choice. Please choose a door number between 1 and 3.");
                exploreHouse(scanner);
        }
    }

    public static int getUserChoice(Scanner scanner, int maxChoice) {
        int choice = 0;
        boolean isValidInput = false;
        do {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= maxChoice) {
                    isValidInput = true;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and " + maxChoice);
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        } while (!isValidInput);
        return choice;
    }
}

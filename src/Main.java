import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("|------------------------- Password Generator -------------------------|");
        System.out.println("|                   Welcome to the Password Generator!                 |");
        System.out.println("|       Follow the upcoming instructions to generate a password.       |");
        System.out.println("|----------------------------------------------------------------------|");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        System.out.println("In the following you can choose which elements your password should contain.");
        System.out.println("Type 'y' for yes and 'n' for no.");
        System.out.println();
        System.out.println("Do you want to use lowercase letters? (y/n)");
        String choiceLow = getValidInput(scanner);
        System.out.println("Do you want to use uppercase letters? (y/n)");
        String choiceUp = getValidInput(scanner);
        System.out.println("Do you want to use numbers? (y/n)");
        String choiceNum = getValidInput(scanner);
        System.out.println("Do you want to use special characters? (y/n)");
        String choiceChar = getValidInput(scanner);

        int length;

        do {
            System.out.println("What length should your password be?");
            length = scanner.nextInt();

            if (length <= 0){
                System.out.println("Your password cant be equal or smaller than 0.");
            }
        } while (length <= 0);

        if (choiceLow.equals("n") && choiceUp.equals("n") && choiceNum.equals("n") && choiceChar.equals("n")) {
            System.out.println("No elements no password. Sorry :(");
            System.exit(0);
        }

        Generator generator = new Generator();

        String password = generator.generator(length, choiceLow, choiceUp, choiceNum, choiceChar);

        System.out.println("Your password: " + password);

        scanner.close();
    }

    private static String getValidInput(Scanner scanner) {
        String input;
        do {
            input = scanner.next().toLowerCase();
            if (isValidInput(input)) {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        } while (isValidInput(input));
        return input;
    }

    private static boolean isValidInput(String input) {
        return !input.equals("y") && !input.equals("n");
    }
}

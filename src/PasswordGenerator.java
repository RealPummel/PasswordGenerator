import java.util.Scanner;

public class PasswordGenerator {

    public static void main(String[] args) {
        System.out.println("""
                   ___                                 __  _____                      __         \s
                  / _ \\___ ____ ____    _____  _______/ / / ___/__ ___  ___ _______ _/ /____  ____
                 / ___/ _ `(_-<(_-< |/|/ / _ \\/ __/ _  / / (_ / -_) _ \\/ -_) __/ _ `/ __/ _ \\/ __/
                /_/   \\_,_/___/___/__,__/\\___/_/  \\_,_/  \\___/\\__/_//_/\\__/_/  \\_,_/\\__/\\___/_/  \s
                                                                                                 \s""");
        System.out.println("    |----------------------------------------------------------------------|");
        System.out.println("    |                   Welcome to the Password Generator!                 |");
        System.out.println("    |     Follow the upcoming instructions to generate a password or       |");
        System.out.println("    |                           check its strength.                        |");
        System.out.println("    |----------------------------------------------------------------------|");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        boolean runAgain = true;

        while (runAgain) {
            System.out.println("To generate a password type 'gen'. To check the strength of a password type 'check'. To exit type 'exit'.");
            String choice = scanner.next().toLowerCase();

            if (choice.equals("exit")) {
                scanner.close();
                runAgain = false;
                continue;
            }

            try {
                if (choice.equals("check")) {
                    System.out.println("Please enter the password you want to check.");
                    String password = scanner.next();
                    PasswordStrength passwordStrength = new PasswordStrength();
                    System.out.println(passwordStrength.check(password));
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter 'generate', 'check' or 'exit'.");
                continue;
            }

            System.out.println("In the following you can choose which elements your password should contain.");
            System.out.println("Type 'y' for yes and 'n' for no.");
            System.out.println();
            System.out.println("Do you want to use lowercase letters? (y/n)");
            String choiceLow = getValidInput(scanner);
            System.out.println();
            System.out.println("Do you want to use uppercase letters? (y/n)");
            String choiceUp = getValidInput(scanner);
            System.out.println();
            System.out.println("Do you want to use numbers? (y/n)");
            String choiceNum = getValidInput(scanner);
            System.out.println();
            System.out.println("Do you want to use special characters? (y/n)");
            String choiceChar = getValidInput(scanner);
            System.out.println();

            String stringLength;
            int length = 0;

            do {
                System.out.println("What length should your password be?");
                stringLength = scanner.next();
                try {
                    length = Integer.parseInt(stringLength);
                } catch (NumberFormatException e) {
                    System.out.println("That's not a valid length.");
                }

                if (length <= 0) {
                    System.out.println("Your password cant be equal or smaller than 0.");
                }
            } while (length <= 0);

            if (choiceLow.equals("n") && choiceUp.equals("n") && choiceNum.equals("n") && choiceChar.equals("n")) {
                System.out.println("No elements no password. Sorry :(");
                continue;
            }

            Generator generator = new Generator();

            String choiceRegen;
            do {
                String password = generator.generator(length, choiceLow, choiceUp, choiceNum, choiceChar);
                System.out.println("Your password: " + '\n' + password + '\n');
                System.out.println("Do you want to regenerate the password? (y/n)" + '\n');
                choiceRegen = getValidInput(scanner);

            } while (choiceRegen.equals("y"));
        }
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
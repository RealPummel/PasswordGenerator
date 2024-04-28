import java.lang.*;
import java.security.SecureRandom;

public class Generator {

    private final char[] lowercaseAlphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private final char[] uppercaseAlphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private final int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final char[] specialCharacter = {'!', '?', '#', '$', '%', '&', '*', '(', ')', '{', '}', '[', ']', '§', '+', '-'};

    String generator(int length, String choiceLow, String choiceUp, String choiceNum, String choiceChar) {
        String password;

        StringBuilder pas = new StringBuilder();

        SecureRandom random = new SecureRandom();

        int i = 0;

        while (i < length) {
            int randomNum = random.nextInt(5);
            switch (randomNum) {
                case 0:
                    if (choiceLow.equals("y")) {
                        int lowAlph = random.nextInt(lowercaseAlphabet.length);
                        pas.append(lowercaseAlphabet[lowAlph]);
                        i++;
                        break;
                    }
                    break;
                case 1:
                    if (choiceUp.equals("y")) {
                        int upAlph = random.nextInt(uppercaseAlphabet.length);
                        pas.append(uppercaseAlphabet[upAlph]);
                        i++;
                        break;
                    }
                    break;
                case 2:
                    if (choiceNum.equals("y")) {
                        int num = random.nextInt(numbers.length);
                        pas.append(numbers[num]);
                        i++;
                        break;
                    }
                    break;
                case 3:
                    if (choiceChar.equals("y")) {
                        int specChar = random.nextInt(specialCharacter.length);
                        pas.append(specialCharacter[specChar]);
                        i++;
                        break;
                    }
                    break;
            }
        }

        password = pas.toString();
        return password;
    }

}

//     _______   ____  ____  ___      ___  ___      ___   _______  ___
//    |   __ "\ (" _|  |_ " ||"  \    /"  ||"  \    /"  | /"     "||"  |
//    (. |__) :)|   (  ) : | \   \  //   | \   \  //   |(: ______)||  |
//    |:  ____/ (:  |  | . ) /\\  \/.    | /\\  \/.    | \/    |  |:  |
//    (|  /      \\ \__/ // |: \.        ||: \.        | // ___)_  \  |___
//   /|__/ \     /\\ __ //\ |.  \    /:  ||.  \    /:  |(:      "|( \_|:  \
//  (_______)   (__________)|___|\__/|___||___|\__/|___| \_______) \_______)
//


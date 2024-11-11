/*
Class to check the strength of a password
 */

public class PasswordStrength {
    boolean hasLower = false;
    boolean hasUpper = false;
    boolean hasNumber = false;
    boolean hasSpecChar = false;
    boolean hasLengthStrong = false;
    boolean hasLengthMedium = false;

    private static final char[] specialCharacter = {'!', '?', '#', '$', '%', '&', '*', '(', ')', '{', '}', '[', ']', '§', '+', '-'};

    String check(String password) {
        int length = password.length();

        char[] passwordChar = password.toCharArray();
        
        for (int i = 0; i < length; i++) {
            if (isNumeric(passwordChar[i])) {
                hasNumber = true;
            }
        }

        for (int i = 0; i < length; i++) {
            if (isLower(passwordChar[i])) {
                hasLower = true;
            }
        }

        for (int i = 0; i < length; i++) {
            if (isUpper(passwordChar[i])) {
                hasUpper = true;
            }
        }

        for (int i = 0; i < length; i++) {
            if (isSpecial(passwordChar[i])) {
                hasSpecChar = true;
            }
        }

        if (length >= 12) {
            hasLengthStrong = true;
        }

        if (length >= 8) {
            hasLengthMedium = true;
        }

        if (hasLower && hasUpper && hasNumber && hasSpecChar && hasLengthStrong) {
            return "The password is very strong.";
        } else if (hasLower && hasUpper && hasNumber && hasSpecChar && hasLengthMedium) {
            return "The password is strong.";
        } else if (hasLower && hasUpper && hasNumber && hasSpecChar) {
            return "The password is medium.";
        } else if (hasLower && hasUpper && hasNumber) {
            return "The password is weak.";
        } else {
            return "The password is very weak.";
        }



    }

    private boolean isNumeric(char a){
            try {
                int num = Integer.parseInt(String.valueOf(a));
            } catch (NumberFormatException nfe){
                return false;
            }
        return true;
    }

    public static boolean isLower(char a){
        return Character.isLowerCase(a);
    }

    public static boolean isUpper(char a){
        return Character.isUpperCase(a);
    }

    public static boolean isSpecial(char a){
        for (int i = 0; i < specialCharacter.length; i++) {
            if (a == specialCharacter[i]) {
                return true;
            }
        }
        return false;
    }
}

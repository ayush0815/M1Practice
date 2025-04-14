import java.util.Scanner;
class TechXam {
    String username;
    public TechXam(String username) {
        this.username = username;
    }
    public boolean isValidUsername() {
        if (username.length() != 8) {
            return false;
        }

        String firstFour = username.substring(0, 4);
        char fifthChar = username.charAt(4);
        String lastThree = username.substring(5);
        if (!firstFour.matches("[A-Z]{4}")) {
            return false;
        }
        if (fifthChar != '@') {
            return false;
        }
        if (!lastThree.matches("\\d{3}")) {
            return false;
        }
        int courseId = Integer.parseInt(lastThree);
        return courseId >= 101 && courseId <= 115;
    }

    public String generatePassword() {
        String firstFourLower = username.substring(0, 4).toLowerCase();
        int asciiSum = 0;
        for (char c : firstFourLower.toCharArray()) {
            asciiSum += (int) c;
        }
        String lastTwoDigits = username.substring(6);
        return "TECH_" + asciiSum + lastTwoDigits;
    }
}

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the username");
        String username = sc.nextLine().trim();
        TechXam techXam = new TechXam(username);

        if (!techXam.isValidUsername()) {
            System.out.println(username + " is an invalid username");
        } else {
            String password = techXam.generatePassword();
            System.out.println("Password: " + password);
        }
    }
}

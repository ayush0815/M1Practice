import java.util.Scanner;
class NameCompatibility {
    private String name1;
    private String name2;
    public NameCompatibility(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }

    public boolean isValidName(String name) {
        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean isSubsequence(String name1, String name2) {
        int j = 0;
        for (int i = 0; i < name2.length() && j < name1.length(); i++) {
            if (name1.charAt(j) == name2.charAt(i)) {
                j++;
            }
        }
        return j == name1.length();
    }

    public int calculateCompatibilityValue(String name1, String name2) {
        int i = 0, j = 0, edits = 0;
        while (i < name1.length() && j < name2.length()) {
            if (name1.charAt(i) != name2.charAt(j)) {
                edits++;
                if (name1.length() > name2.length()) {
                    i++;
                } else if (name1.length() < name2.length()) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            } else {
                i++;
                j++;
            }
        }
        edits += (name1.length() - i) + (name2.length() - j);
        return edits;
    }

    public void checkCompatibility() {
        if (!isValidName(name1) && !isValidName(name2)) {
            System.out.println("Both " + name1 + " and " + name2 + " are invalid names");
            return;
        } else if (!isValidName(name1)) {
            System.out.println(name1 + " is an invalid name");
            return;
        } else if (!isValidName(name2)) {
            System.out.println(name2 + " is an invalid name");
            return;
        }
        String name1NoSpaces = name1.replaceAll("\\s+", "");
        String name2NoSpaces = name2.replaceAll("\\s+", "");

        if (isSubsequence(name1NoSpaces, name2NoSpaces) || isSubsequence(name2NoSpaces, name1NoSpaces)) {
            System.out.println(name1 + " and " + name2 + " are made for each other");
            int compatibilityValue = calculateCompatibilityValue(name1NoSpaces, name2NoSpaces);
            System.out.println("Compatibility Value is " + compatibilityValue);
        } else {
            System.out.println(name1 + " and " + name2 + " are not made for each other");
        }
    }
}

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the man name");
        String manName = sc.nextLine().trim();
        System.out.println("Enter the woman name");
        String womanName = sc.nextLine().trim();
        NameCompatibility nameCompatibility = new NameCompatibility(manName, womanName);
        nameCompatibility.checkCompatibility();
    }
}

import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of entries");
        int numberOfEntries = Integer.parseInt(sc.nextLine().trim());
        for (int i = 1; i <= numberOfEntries; i++) {
            System.out.println("Enter entry " + i + " details");
            String entryDetails = sc.nextLine().trim();
            String[] parts = entryDetails.split(":");
            String employeeId = parts[0];
            String entryType = parts[1];
            int duration = Integer.parseInt(parts[2]);

            try {
                EntryUtility.validateEmployeeId(employeeId);
                EntryUtility.validateDuration(duration);
                System.out.println("Valid entry details");
            } catch (InvalidEntryException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

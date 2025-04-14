import java.util.Scanner;
public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of gadget entries");
        int numberOfEntries = Integer.parseInt(sc.nextLine().trim());
        GadgetValidatorUtil validator = new GadgetValidatorUtil();
        for (int i = 1; i <= numberOfEntries; i++) {
            System.out.println("Enter gadget " + i + " details");
            String entryDetails = sc.nextLine().trim();
            String[] parts = entryDetails.split(":");
            String gadgetID = parts[0];
            String gadgetType = parts[1];
            int warrantyPeriod = Integer.parseInt(parts[2]);

            try {
                validator.validateGadgetID(gadgetID);
                validator.validateWarrantyPeriod(warrantyPeriod);
                System.out.println("Warranty accepted, stock updated");
            } catch (InvalidGadgetException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

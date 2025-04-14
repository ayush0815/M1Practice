public class GadgetValidatorUtil {
    public boolean validateGadgetID(String gadgetID) throws InvalidGadgetException {
        if (!gadgetID.matches("[A-Z]\\d{3}")) {
            throw new InvalidGadgetException("Invalid gadget ID");
        }
        return true;
    }

    public boolean validateWarrantyPeriod(int period) throws InvalidGadgetException {
        if (period < 6 || period > 36) {
            throw new InvalidGadgetException("Invalid warranty period");
        }
        return true;
    }
}

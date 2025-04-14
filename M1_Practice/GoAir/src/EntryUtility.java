class EntryUtility {
    public static boolean validateEmployeeId(String employeeId) throws InvalidEntryException {
        if (employeeId.length() != 10 || !employeeId.startsWith("GOAIR/") || !employeeId.substring(6,10).matches("\\d{4}")) {
            throw new InvalidEntryException("Invalid entry details");
        }
        return true;
    }

    public static boolean validateDuration(int duration) throws InvalidEntryException {
        if (duration < 1 || duration > 5) {
            throw new InvalidEntryException("Invalid entry details");
        }
        return true;
    }
}

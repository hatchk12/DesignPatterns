package contacts;

public class ContactManagerAdapter implements TableData{
    ContactManager contactManager;

    public ContactManagerAdapter(ContactManager contactManager) {
        this.contactManager = contactManager;
    }

    @Override
    public int getColumnCount() {
       return 4;//firstname lastname phone email
    }

    @Override
    public int getRowCount() {
        return contactManager.getContactCount();
    }

    @Override
    public int getColumnSpacing() {
        return 2;
    }

    @Override
    public int getRowSpacing() {
        return 2;
    }

    @Override
    public char getHeaderUnderline() {
        return '_';
    }

    @Override
    public String getColumnHeader(int col) {
        return switch (col) {
            case 0 -> "First Name";
            case 1 -> "Last Name";
            case 2 -> "Phone";
            case 3 -> "Email";
            default -> "ummm";
        };

    }

    @Override
    public int getColumnWidth(int col) {
        return switch (col) {
            case 0 -> 12;
            case 1 -> 12;
            case 2 -> 10;
            case 3 -> 20;
            default -> 10;
        };
    }

    @Override
    public Justification getColumnJustification(int col) {
        return Justification.Left;
    }

    @Override
    public String getCellValue(int row, int col) {
        return switch (col) {
            case 0 -> contactManager.getContact(row).getFirstName();
            case 1 -> contactManager.getContact(row).getLastName();
            case 2 -> contactManager.getContact(row).getPhone();
            case 3 -> contactManager.getContact(row).getEmail();
            default -> "ummm";
        };
    }
}

package contacts;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ConcurrentModificationException;

public class main {
    public static void main(String[] args) throws IOException {
        Contact contact1 = new Contact("Steve","Rogers","1234567","america@gmail.com");
        Contact contact2 = new Contact("Tony","Stark","2345678","iamironman@gmail.com");
        Contact contact3 = new Contact("Bruce","Banner","3456789","hawkeye@gmail.com");
        Contact contact4 = new Contact("Thor","Odinson","0123456","strongestavenger@gmail.com");
        Contact contact5 = new Contact("Natasha","Romanoff","4567890","blackwidow@gmail.com");

        ContactManager contactManager = new ContactManager();
        contactManager.addContact(contact1);
        contactManager.addContact(contact2);
        contactManager.addContact(contact3);
        contactManager.addContact(contact4);
        contactManager.addContact(contact5);
        TableData adapter = new ContactManagerAdapter(contactManager);
        Writer writer = new FileWriter("out.txt");
        Table table = new Table(writer,adapter);
        table.display();
        writer.flush();
        writer.close();
    }

}

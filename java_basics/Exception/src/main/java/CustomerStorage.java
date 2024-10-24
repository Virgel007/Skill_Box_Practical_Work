import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws Exception {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            if (components.length != 4) {
                throw new IncorrectNumberOfComponentsInThePassedLine(components.length);
            }
            if (components[INDEX_NAME].matches("[^а-яА-Я]{2,}+")) {
                throw new IncorrectNameFormat(components[INDEX_NAME]);
            }
            if (components[INDEX_SURNAME].matches("[^а-яА-Я]{2,}+")) {
                throw new IncorrectNameFormat(components[INDEX_SURNAME]);
            }
            if (components[INDEX_EMAIL].matches("[a-zA-Zа-яА-Я]+")) {
                throw new IncorrectEmailFormat(components[INDEX_EMAIL]);
            }
            if (!components[INDEX_PHONE].matches("[+][0-9]{11}")) {
                throw new IncorrectPhoneNumberFormat(components[INDEX_PHONE]);
            }
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }
    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}
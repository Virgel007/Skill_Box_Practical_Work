package practice;

import java.util.*;

public class PhoneBook {
    private final Map<String, String> treeMap = new TreeMap<>();
    public void addContact(String phone, String name) {
        if (phone.isEmpty() || name.isEmpty()) {
            return;
        }
        if (phone.equals(name)) {
            return;
        }
        treeMap.put(phone, name);
    }
    public String getContactByPhone(String contactPhone) {
        if (treeMap.containsKey(contactPhone)) {
            return treeMap.get(contactPhone) + " - " + contactPhone;
        } else {
            return "";
        }
    }
    public Set<String> getContactByName(String contactName) {
        Set<String> contact = new TreeSet<>();
        if (treeMap.containsValue(contactName)) {
            for (Map.Entry<String, String> entry : treeMap.entrySet()) {
                String name = entry.getKey();
                String phone = entry.getValue();
                if (contactName.equals(phone)) {
                    contact.add(phone + " - " + name);
                }
            } return contact;
        } else {
            return new TreeSet<>();
        }
    }
    public Set<String> getAllContacts() {
        Map<String, String> allContacts = new TreeMap<>();
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            String name = entry.getKey();
            String phone = entry.getValue();
            if (allContacts.containsKey(phone)) {
                allContacts.put(phone, allContacts.get(phone) + ", " + name);
            } else {
                allContacts.put(phone, phone + " - " + name);
            }
        }
        return new TreeSet<>(allContacts.values());
    }

    public boolean containsName(String name) {
        return treeMap.containsValue(name);
    }

    public boolean containsPhone(String phone) {
        return treeMap.containsKey(phone);
    }
}
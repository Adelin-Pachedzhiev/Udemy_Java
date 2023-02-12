import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact) < 0){
            myContacts.add(contact);
            return true;
        }
        return false;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int oldContactIndex = findContact(oldContact);
        if(oldContactIndex >= 0 ){
            myContacts.set(oldContactIndex, newContact);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact contact){
        int contactIndex = findContact(contact);
        if(contactIndex >= 0 ){
            myContacts.remove(contactIndex);
            return true;
        }
        return false;
    }

    private int findContact(Contact contact){
        return findContact(contact.getName());
    }

    private int findContact(String name){
        for(int i= 0; i < myContacts.size(); i++){
            if(myContacts.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    public Contact queryContact(String name){
        int contactIndex = findContact(name);
        if (contactIndex < 0){
            return null;
        }
        return myContacts.get(contactIndex);
    }

    public void printContacts(){
        System.out.println("Contact List:");
        for(int i= 0; i <myContacts.size(); i++){
            Contact contact = myContacts.get(i);
            System.out.println(i+1 + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}

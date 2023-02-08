package SpingApplication;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {


    @Id
    @GeneratedValue
    private long id;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<BuddyInfo> buddyInfolist;

    public AddressBook() {
        buddyInfolist = new ArrayList();
    }

    public BuddyInfo removeBuddy(int index) {
        BuddyInfo buddy = buddyInfolist.remove(index);
        //System.out.println("Buddy has been removed. Buddy information: ");
        //buddy.printInfo();
        return buddy;
    }

    public BuddyInfo removeBuddy(BuddyInfo buddyInfo) {
        buddyInfolist.remove(buddyInfo);
        //System.out.println("Buddy has been removed. Buddy information: ");
        //buddy.printInfo();
        return buddyInfo;
    }

    public void addBuddy(BuddyInfo buddy) {
        if (buddyInfolist.add(buddy)) {
            //System.out.println("Buddy has been added. Buddy information: ");
            //buddy.printInfo();
        }
        else {
            //System.out.println("Error. Buddy was not added");
        }
    }

    public void printAllBuddies(){
        //System.out.println("Printing all buddies: ");
        for (int i = 0; i < buddyInfolist.size(); i++) {
            printBuddy(buddyInfolist.get(i));
        }
    }

    public void printBuddy (BuddyInfo buddy) {
        //buddy.printInfo();
        buddy.toString();
    }

    public int numOfBuddies () {
        return buddyInfolist.size();
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }


    public List<BuddyInfo> getBuddyInfolist() {
        return buddyInfolist;
    }

    public String toString() {
        String temp = String.format(
                "Address Book[id=%d]",
                id);
        for (BuddyInfo buddy: buddyInfolist) {
            temp += "\n";
            temp += buddy.toString();
        }
        return temp;
    }
    public void setBuddyInfolist(List<BuddyInfo> buddyInfolist) {
        this.buddyInfolist = buddyInfolist;
    }
//    public static void main(String[] args) {
//        AddressBook addressBook = new AddressBook();
//        BuddyInfo buddy1 = new BuddyInfo("613-123-4567", "Omar");
//        BuddyInfo buddy2 = new BuddyInfo("613-921-3056", "Prathosh");
//        addressBook.addBuddy(buddy1);
//        addressBook.addBuddy(buddy2);
//        addressBook.printAllBuddies();
//    }
}
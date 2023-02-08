package SpingApplication;

import jakarta.persistence.*;

@Entity
public class BuddyInfo{

    @Id
    @GeneratedValue
    private long id;


    private String name;

    private String number;

    public BuddyInfo(String name, String number)
    {
        this.name = name;
        this.number = number;
    }

    public BuddyInfo() {

    }

    public String getName() {
        return name;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String phoneNumber) {
        this.number = phoneNumber;
    }


    @Override
    public String toString() {
        return String.format(
                "Buddy[id=%d, name='%s', phone number='%s']",
                id, name, number);
//        return "BuddyInfo{" +
//                "id=" + id +
//                ", addressBook=" + addressBook +
//                ", name='" + name + '\'' +
//                ", number='" + number + '\'' +
//                '}';
    }

    //    public void printInfo() {
//        System.out.println("Name: " + name + ". Phone Number: " + number);
//    }
}
package SpingApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressRestController {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    @PostMapping("/addressbook")
    public AddressBook createAddressBook(){
        AddressBook addressBook = new AddressBook();
        addressBookRepository.save(addressBook);
        return addressBook;
    }

    @PostMapping("/buddyinfo/add")
    public AddressBook addBuddy(@RequestParam("addressBookID") String addressBookID, @RequestParam("buddyName") String buddyName, @RequestParam("buddyNumber") String buddyNumber) {
        AddressBook addressBook = addressBookRepository.findById(Long.parseLong(addressBookID));
        BuddyInfo buddyInfo = new BuddyInfo(buddyName, buddyNumber);
        addressBook.addBuddy(buddyInfo);
        buddyInfoRepository.save(buddyInfo);
        addressBookRepository.save(addressBook);

        return addressBook;
    }

    @PostMapping("/buddyinfo/remove")
    public AddressBook removeBuddy(@RequestParam("addressBookID") String addressBookID, @RequestParam("buddyID") String buddyID) {
        AddressBook addressBook = addressBookRepository.findById(Long.parseLong(addressBookID));
        BuddyInfo buddyInfo = buddyInfoRepository.findById(Long.parseLong(buddyID));

        addressBook.removeBuddy(buddyInfo);
        buddyInfoRepository.delete(buddyInfo);
        addressBookRepository.save(addressBook);

        return addressBook;
    }
}

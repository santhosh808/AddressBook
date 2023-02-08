package SpingApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AddressBookController {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @GetMapping("/addressbook/view")
    public String displayAddressBook(@RequestParam("addressBookID") String addressBookID, Model model) {
        AddressBook addressBook = addressBookRepository.findById(Long.parseLong(addressBookID));
        List<BuddyInfo> buddyInfoList = addressBook.getBuddyInfolist();
        model.addAttribute("buddyInfoList", buddyInfoList);
        return "addressbook";
    }
}

package SpingApplication;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AddressBookControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void addressBookTest() throws Exception {
        this.mockMvc.perform(post("/addressbook")).andExpect(status().isOk()).andExpect(content().string(containsString("{\"id\":1,\"buddyInfolist\":[]}")));

        this.mockMvc.perform(post("/buddyinfo/add?addressBookID=1&buddyName=San&buddyNumber=613-123-4546")).andExpect(status().isOk()).andExpect(content().string(containsString("{\"id\":1,\"buddyInfolist\":[{\"id\":1,\"name\":\"San\",\"number\":\"613-123-4546\"}]}")));

        this.mockMvc.perform(post("/buddyinfo/remove?addressBookID=1&buddyID=1")).andExpect(status().isOk()).andExpect(content().string(containsString("{\"id\":1,\"buddyInfolist\":[]}")));
    }
    /*
    @Test
    public void createAddressBookTest() throws Exception{
        this.mockMvc.perform(post("/addressbook")).andExpect(status().isOk()).andExpect(content().string(containsString("{\"id\":1,\"buddyInfolist\":[]}")));
    }

    @Test
    public void addBuddyInfoTest() throws Exception {
        this.mockMvc.perform(post("/addressbook"));
        this.mockMvc.perform(post("/buddyinfo/add?addressBookID=1&buddyName=San&buddyNumber=613-123-4546")).andExpect(status().isOk()).andExpect(content().string(containsString("{\"id\":1,\"buddyInfolist\":[{\"id\":1,\"name\":\"San\",\"number\":\"613-123-4546\"}]}")));
    }

    @Test
    public void removeBuddyInfoTest() throws Exception {
        //this.mockMvc.perform(post("/addressbook"));
        //this.mockMvc.perform(post("/buddyinfo/add?addressBookID=1&buddyName=San&buddyNumber=613-123-4546"));
        this.mockMvc.perform(post("/buddyinfo/remove?addressBookID=1&buddyID=1")).andExpect(status().isOk()).andExpect(content().string(containsString("{\"id\":1,\"buddyInfolist\":[]}")));
    }*/
}

package SpingApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AddressBookApplication {

	private static final Logger log = LoggerFactory.getLogger(AddressBookApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AddressBookApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner demoBuddy(BuddyInfoRepository repository) {
		return (args) -> {
			// save a few BuddyInfos
			repository.save(new BuddyInfo("Omar", "613-123-4567"));
			repository.save(new BuddyInfo("San", "613-637-8264"));
			repository.save(new BuddyInfo("Prat", "613-987-2387"));
			repository.save(new BuddyInfo("David", "613-576-8524"));
			repository.save(new BuddyInfo("Hannah", "613-987-6543"));


			// fetch all BuddyInfos
			log.info("BuddyInfos found with findAll():");
			log.info("-------------------------------");
			for (BuddyInfo buddyInfo : repository.findAll()) {
				log.info(buddyInfo.toString());
			}
			log.info("");

			// fetch an individual BuddyInfo by ID
			BuddyInfo buddyInfo = repository.findById(1L);
			log.info("BuddyInfo found with findById(1L):");
			log.info("--------------------------------");
			log.info(buddyInfo.toString());
			log.info("");

			// fetch BuddyInfos by name
			log.info("BuddyInfo found with findByLastName('San'):");
			log.info("--------------------------------------------");
			repository.findByName("San").forEach(san -> {
				log.info(san.toString());
			});
			// for (BuddyInfo san : repository.findByLastName("san")) {
			//  log.info(san.toString());
			// }
			log.info("");
		};
	}

	@Bean
	public CommandLineRunner demoBook(AddressBookRepository repository2) {
		return (args) -> {

			AddressBook addressBook = new AddressBook();

			// save a few BuddyInfos
			addressBook.addBuddy(new BuddyInfo("Omar", "613-123-4567"));
			addressBook.addBuddy(new BuddyInfo("San", "613-637-8264"));
			addressBook.addBuddy(new BuddyInfo("Prat", "613-987-2387"));
			addressBook.addBuddy(new BuddyInfo("David", "613-576-8524"));
			addressBook.addBuddy(new BuddyInfo("Hannah", "613-987-6543"));
			repository2.save(addressBook);

			// fetch an individual AddressBook by ID
			AddressBook addressBook1 = repository2.findById(1L);
			log.info("AddressBook found with findById(1L):");
			log.info("--------------------------------");
			log.info(addressBook1.toString());
			//log.info(addressBook.toString());
			log.info("");
		};
	}*/
}

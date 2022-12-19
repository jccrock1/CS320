package Contact;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	ContactService newList = new ContactService();
	
	@BeforeEach
	void createList() {
		newList = new ContactService();
	}
	
	//Tests for throws
		//Tests Name
		@Test
		void testContactNameIsTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {newList.newContact("Jonathan Carmichael", "", "1234567","1234 myhouse st.");});
		}
		
		@Test
		void testContactNameIsNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {newList.newContact(null,"Carmichael","1234567","1234 myhouse st.");});
		}
		
		//Tests Phone Number
		@Test
		void testContactPhoneNumberIsTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {newList.newContact("Jonathan","Carmichael","12345678910","1234 myhouse st.");});
		}
		@Test
		void testContactPhoneNumberIsNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {newList.newContact("Jonathan","Carmichael", null,"1234 myhouse st.");});
		}
		
		//Tests Address
		@Test
		void testContactAddressIsTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {newList.newContact("Jonathan","Carmichael","1234567","1234 myhouse st.1234 myhouse st.1234 myhouse st.");});
		}
		
		@Test
		void testContactAddressIsNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {newList.newContact("Jonathan","Carmichael","1234567", null);});
		}
		
		//Tests Update/Remove functions
		@Test
		void testContactUpdate() {
			Assertions.assertThrows(Exception.class, () -> {newList.updateFirstName(null,"Jonathan");});
		}
		
		@Test
		void testContactDelete() {
			Assertions.assertThrows(Exception.class, () -> {newList.deleteContact("1");});
		}
		
	//Test for Assertions
		//Tests add
		@Test
		void testAdd() throws Exception {
			newList.newContact("Jonathan", "Carmichael", "1234567", "1234 myhouse st.");
			assertTrue(newList.searchForContact("1").getFirstName().equals("Jonathan"));
		}
		
		//Tests Update
		@Test
		void testUpdate() throws Exception {
			newList.newContact("Jonathan", "Carmichael", "1234567", "1234 myhouse st.");
			newList.updateLastName("1", "NewName");
			assertTrue(newList.searchForContact("1").getLastName().equals("NewName"));
		}
		
		//Tests Delete
		@Test
		void testDelete() throws Exception {
			newList.newContact("Jonathan", "Carmichael", "1234567", "1234 myhouse st.");
			assertTrue(newList.searchForContact("1").getPhoneNumber().equals("1234567"));
			newList.deleteContact("1");
			testContactDelete();
		}
}
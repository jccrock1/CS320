package Contact;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {
	
	//Tests for successful constructor
	@Test
	void testContactClass() {
		Contact contact = new Contact("12345","Jonathan","Carmichael", "1234567", "1234 myhouse st.");
		assertTrue(contact.getContactId().equals("12345"));
		assertTrue(contact.getFirstName().equals("Jonathan"));
		assertTrue(contact.getLastName().equals("Carmichael"));
		assertTrue(contact.getPhoneNumber().equals("1234567"));
		assertTrue(contact.getAddress().equals("1234 myhouse st."));
	}
	
	//Tests ID field
	@Test
	void testContactIdIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Contact("12345678910","Jonathan","Carmichael","1234567","1234 myhouse st.");});
	}
	
	@Test
	void testContactIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Contact( null,"Jonathan","Carmichael","1234567","1234 myhouse st.");});
	}	
}
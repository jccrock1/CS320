package Appointment;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class AppointmentTest {
	LocalDate initialDate = LocalDate.of(2099, 11, 26);

	//Tests construction
	@Test
	void testAppClass() {
		Appointment testApp = new Appointment("12345", initialDate,"Task Description");
		assertTrue(testApp.getAppointId().equals("12345"));
		assertTrue(testApp.getAppointDate().equals(initialDate.toString()));
		assertTrue(testApp.getDescription().equals("Task Description"));
	}

	//Tests ID
	@Test
	void testAppIdIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Appointment("12345678910",initialDate,"Task Description");});
	}
	
	//Tests if ID throws when null
	@Test
	void testAppIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Appointment( null,initialDate,"Task Description");});
	}
		
	//Tests if Date throws when null
	@Test
	void testAppDateIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Appointment( "12345",null,"Task Description");});
	}
}
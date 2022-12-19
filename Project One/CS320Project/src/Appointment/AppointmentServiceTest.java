package Appointment;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
	AppointmentService newList = new AppointmentService();

	@BeforeEach
	void createList() {
		newList = new AppointmentService();
	}
	
	//Test fields for throws

		//Tests Date - Cannot be in the past!
		@Test
		void testAppNameIsTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {newList.newAppointment(1990, 1, 31 ,"Just a description.");});
		}
			
		//Tests Description - Limit of fifty characters AND can't be null!
		@Test
		void testAppDiscIsTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {newList.newAppointment(2099, 1, 31, ">>>>>>>>>>>>>>>>>>>>>>>>>TaskDescription<<<<<<<<<<<<<<<<<<<<<<<<");});
		}
			
		@Test
		void testAppDiscIsNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {newList.newAppointment(2099, 1, 31, null);});
		}
			
		@Test
		void testAppDelete() {
			Assertions.assertThrows(Exception.class, () -> {newList.deleteAppointment("1");});
		}
	
	//Tests for Assertions
			
		//Tests add
		@Test
		void testAdd() throws Exception {
			newList.newAppointment(2099, 1, 31, "Task Description");
			assertTrue(newList.searchForAppointment("1").getDescription().equals("Task Description"));
		}
			
		//Tests Delete
		@Test
		void testDelete() throws Exception {
			newList.newAppointment(2099, 1, 31, "Description");
			assertTrue(newList.searchForAppointment("1").getDescription().equals("Description"));
			newList.deleteAppointment("1");
			testAppDelete();
		}

}
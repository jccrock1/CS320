package Task;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

	//Tests construction of task object
	@Test
	void testTaskClass() {
		Task task = new Task("12345","Task","Task Description");
		assertTrue(task.getTaskId().equals("12345"));
		assertTrue(task.getTaskName().equals("Task"));
		assertTrue(task.getDescription().equals("Task Description"));
	}

	//Tests ID as TaskService generates ID
	@Test
	void testTaskIdIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Task("12345678910","Task","Task Description");});
	}
		
	//Tests if task ID throws when null
	@Test
	void testTaskIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Task( null,"Task","Task Description");});
	}	
}
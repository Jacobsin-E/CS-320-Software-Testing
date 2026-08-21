import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	// ** Happy Path: Add Contact **
	@Test
	void testAddContactSuccess() {
		ContactService service = new ContactService();
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

		// If the add method is working, this line will execute with not warnings
		service.addContact(contact);

	}

	// Unhappy Path: Add Duplicate Contact **
	@Test
	void testAddDuplicateContactFails() {
		ContactService service = new ContactService();
		Contact contact1 = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
		Contact contact2 = new Contact("12345", "Jane", "Smith", "0987654321", "456 Oak St");

		// Add the first contact successfully
		service.addContact(contact1);

		// Attempting to add a second contact with the exact same ID ("12345") should
		// crash
		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(contact2);
		});
	}

	// Happy Path: Delete Contact **
	@Test
	void testDeleteContactSuccess() {
		ContactService service = new ContactService();
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
		service.addContact(contact);

		// This should execute successfully without throwing an error
		service.deleteContact("12345");
	}

	// Unhappy Path: Delete Non-existent Contact **
	@Test
	void testDeleteContactFails() {
		ContactService service = new ContactService();

		// Attempting to delete an ID that was never added should crash
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("99999");
		});
	}
	
	// Happy Path: Update Contact **
	@Test
	void testUpdateSuccess() {
		ContactService service = new ContactService();
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
		service.addContact(contact);
		
		//Update the contact's first name, last name, and phone number
		//This should update without throwing an error
		service.updateContact("12345", "Jane", "Smith", "0987654321", "123 Main St");
		
	}
	
	//Unhappy Path: Update Non-existent Contact **
	@Test
	void testUpdateContactFails() {
		ContactService service = new ContactService();
		
		//Attempt to update an ID that was never added should crash
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact("99999", "Jane", "Smith", "0987654321", "456 Oak St");
		});
	}

}

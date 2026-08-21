import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactTest {

	// ** Valid Happy Path Test **

	@Test
	void testContactCreationSuccess() {
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

		// Check to see if the data saved matches what we expect
		assertEquals("12345", contact.getContactId());
		assertEquals("John", contact.getFirstName());
		assertEquals("Doe", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("123 Main St", contact.getAddress());

	}

	// **Valid Unhappy Path Test Contact length **
	@Test
	void testContactIdTooLong() {
		// Trigger Contact Id failure
		// JUnit should expect this to crash and throw an exception
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
		});
	}

	// ** Valid Unhappy Path Test (First Name null) **
	@Test
	void testContactFirstNameIsNull() {
		// Trigger First Name null failure
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", null, "Doe", "1234567890", "123 Main St");
		});
	}

	// ** Valid Unhappy Path Test (First Name Too long) **
	@Test
	void testContactFirstNameIsTooLong() {
		// Trigger First Name too long failure
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "RobinsonDoe", "Doe", "1234567890", "123 Main St");
		});
	}

	// ** Valid Unhappy Path Test (Last Name Null) **
	@Test
	void testContactLastNameNull() {
		// Trigger Last Name Null
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Robinson", null, "1234567890", "123 Main St");
		});
	}

	// ** Valid Unhappy Path Test (Last Name Too Long) **
	@Test
	void testContactLastNameTooLong() {
		// Trigger Last Too Long
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Robinson", "DoeRobinson", "1234567890", "123 Main St");
		});
	}

	// ** Valid Unhappy Path Test (Phone is Null) **
	@Test
	void testContactPhoneNull() {
		// Trigger Phone Null
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Robinson", "Doe", null, "123 Main St");
		});
	}

	// ** Valid Unhappy Path Test (Phone Too Short) **
	@Test
	void testContactPhoneTooShort() {
		// Trigger Phone Too Short
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Robinson", "Doe", "807738475", "123 Main St");
		});
	}

	// ** Valid Unhappy Path Test (Phone Too Long) **
	@Test
	void testContactPhoneTooLong() {
		// Trigger Phone Too Long
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Robinson", "Doe", "80773847523", "123 Main St");
		});
	}

	// ** Valid Unhappy Path Test (Phone Has Letters) **
	@Test
	void testContactPhoneHasLetters() {
		// Trigger Phone Has Letters
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Robinson", "Doe", "807738ABCD", "123 Main St");
		});
	}

	// ** Valid Unhappy Path Test (Address Null) **
	@Test
	void testContactAddressNull() {
		// Trigger Address Null
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Robinson", "Doe", "1234567890", null);
		});
	}

	// ** Valid Unhappy Path Test (Address Too Long) **
	@Test
	void testContactAddressTooLong() {
		// Trigger Address Too Long
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Robinson", "Doe", "1234567890", "123 Main St Ave, Texas, United States Of America");
		});
	}

	// ** Valid Unhappy Path Test ( Setter First Name Null) **
	@Test
	void testSetFirstNameNull() {
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(null);
		});

	}

	// ** Valid Unhappy Path Test ( Setter First Name Too Long) **
	@Test
	void testSetFirstNameTooLong() {
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("RobinsonDoe");
		});

	}

	// ** Valid Unhappy Path Test ( Setter Last Name Null) **
	@Test
	void testSetLastNameNull() {
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName(null);
		});

	}

	// ** Valid Unhappy Path Test ( Setter Last Name Too Long) **
	@Test
	void testSetLastNameTooLong() {
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("DoeRobinson");
		});

	}

	// ** Valid Unhappy Path Test ( Setter Phone Null) **
	@Test
	void testSetPhoneNull() {
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone(null);
		});

	}

	// ** Valid Unhappy Path Test ( Setter Phone Too Short) **
	@Test
	void testSetPhoneTooShort() {
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("807738475");
		});

	}

	// ** Valid Unhappy Path Test ( Setter Phone Too Long) **
	@Test
	void testSetPhoneTooLong() {
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("80773847523");
		});

	}

	// ** Valid Unhappy Path Test ( Setter Phone Has Letters) **
	@Test
	void testSetPhoneHasLetters() {
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("807738ABCD");
		});

	}

	// ** Valid Unhappy Path Test ( Setter Address Null) **
	@Test
	void testSetAddressNull() {
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress(null);
		});

	}

	// ** Valid Unhappy Path Test ( Setter Address Too Long) **
	@Test
	void testSetAddressTooLong() {
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("123 Main St Ave, Texas, United States Of America");
		});

	}

}
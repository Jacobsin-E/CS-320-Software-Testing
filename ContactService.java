import java.util.HashMap;
import java.util.Map;

public class ContactService {

	// In-memory data structure
	private final Map<String, Contact> contacts = new HashMap<>();

	// ** Add Method **
	public void addContact(Contact contact) {
		if (contact == null || contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Contact already exists or is null");
		}
		// Otherwise, put the new contact into the memory structure
		contacts.put(contact.getContactId(), contact);

	}

	// ** Delete Method **
	public void deleteContact(String contactId) {
		// Check if a folder with this Contact ID actually exists
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID does not exist");
		}
		// If it does exist, remove it
		contacts.remove(contactId);
	}

	// ** Update Method **
	public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
		// Check if the Contact ID actually exists
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID does not exist");

		}

		// If it does exist, grab it so we can edit it
		Contact contactToUpdate = contacts.get(contactId);

		// Only update fields if the new data is not null
		if (firstName != null) {
			contactToUpdate.setFirstName(firstName);

		}
		if (lastName != null) {
			contactToUpdate.setLastName(lastName);
		}
		if (phone != null) {
			contactToUpdate.setPhone(phone);

		}
		if (address != null) {
			contactToUpdate.setAddress(address);
		}

	}

}

package edu.miu.cs.cs489appsd.contactCLI;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.miu.cs.cs489appsd.contactCLI.model.Contact;
import edu.miu.cs.cs489appsd.contactCLI.model.EmailAddress;
import edu.miu.cs.cs489appsd.contactCLI.model.PhoneNumber;

@SpringBootApplication
public class ContactCliApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ContactCliApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Contact davidSanger = new Contact("David", "Sanger", "Argos LLC", "Sales Manager");
		davidSanger.addPhoneNumber("240-133-0011", "Home");
		davidSanger.addPhoneNumber("240-112-0123", "Mobile");
		davidSanger.addEmailAddress("dave.sang@gmail.com", "Home");
		davidSanger.addEmailAddress("dsanger@argos.com", "Work");

		Contact carlosJimenez = new Contact("Carlos", "Jimenez", "Zappos", "Director");
		// carlosJimenez.addPhoneNumber("Phone number not provided", "N/A");
		// carlosJimenez.addEmailAddress("Email address not provided", "N/A");

		Contact aliGafar = new Contact("Ali", "Gafar", "BMI Services", "HR Manager");
		aliGafar.addPhoneNumber("412-116-9988", "Work");
		aliGafar.addEmailAddress("ali@bmi.com", "Work");

		Contact[] contacts = { davidSanger, carlosJimenez, aliGafar };

		Arrays.sort(contacts, (c1, c2) -> c1.getLastName().compareToIgnoreCase(c2.getLastName()));

		// Print each contact's data in JSON format
		ObjectMapper mapper = new ObjectMapper();
		for (Contact contact : contacts) {
			try {
				String contactJson = mapper.writeValueAsString(contact);
				System.out.println(contactJson);
			} catch (Exception e) {
				System.err.println("Error converting contact to JSON: " + e.getMessage());
			}
		}

	}

}

package ca.cgi.fsa;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ca.cgi.fsa.entities.Person;

@SpringBootTest
class FsaApplicationTests {

	@Test
	public void createPerson_success() {
		Person newPerson = new Person("Greg", "Pascucci", "greg.pascucci@gmail.com");
		String firstName = "Greg";

		// then
		assertTrue(firstName.equals(newPerson.getFirstName()));
	}

}

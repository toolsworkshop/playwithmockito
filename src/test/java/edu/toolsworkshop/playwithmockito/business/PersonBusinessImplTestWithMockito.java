package edu.toolsworkshop.playwithmockito.business;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.*;

import org.junit.Test;

import edu.toolsworkshop.playwithmockito.data.Person;
import edu.toolsworkshop.playwithmockito.data.PersonService;
import edu.toolsworkshop.playwithmockito.data.Person.Gender;

public class PersonBusinessImplTestWithMockito {

	@Test
	public void testGetFullNameOfLuckyPerson_female() {
		PersonService personService = mock(PersonService.class);
		Person femalePerson = new Person("maneesha", "jain", Gender.Female, 52);
		stub(personService.getRandomPerson()).toReturn(femalePerson);
		PersonBusinessImpl personBusinessImpl = new PersonBusinessImpl(personService);
		String fullName = personBusinessImpl.getFullNameOfLuckyPerson();
		assertTrue("Expecting Ms", fullName.startsWith("Ms"));
	}
	
	@Test
	public void testGetFullNameOfLuckyPerson_male() {
		PersonService personService = mock(PersonService.class);
		Person malePerson = new Person("Imbrahim", "Tamimi", Gender.Male, 52);
		when(personService.getRandomPerson()).thenReturn(malePerson);
		PersonBusinessImpl personBusinessImpl = new PersonBusinessImpl(personService);
		String fullName = personBusinessImpl.getFullNameOfLuckyPerson();
		assertTrue("Expecting Mr", fullName.startsWith("Mr"));
	}
	
	@Test(expected=IllegalStateException.class)
	public void testGetFullNameOfLuckyPerson_null() {
		PersonService personService = mock(PersonService.class);
		PersonBusinessImpl personBusinessImpl = new PersonBusinessImpl(personService);
		personBusinessImpl.getFullNameOfLuckyPerson();
	}
	
	@Test
	public void testIsSeniorTrue() {
		PersonService personService = mock(PersonService.class);
		PersonBusinessImpl personBusinessImpl = new PersonBusinessImpl(personService);
		Person malePerson = new Person("Imbrahim", "Tamimi", Gender.Male, 70);
		when(personService.find(anyString())).thenReturn(malePerson);
		assertTrue(personBusinessImpl.isSenior("1"));
	}

}

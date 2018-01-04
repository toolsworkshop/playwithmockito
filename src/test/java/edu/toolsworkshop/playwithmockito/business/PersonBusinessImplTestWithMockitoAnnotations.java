package edu.toolsworkshop.playwithmockito.business;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import edu.toolsworkshop.playwithmockito.data.Person;
import edu.toolsworkshop.playwithmockito.data.PersonService;
import edu.toolsworkshop.playwithmockito.data.Person.Gender;

@RunWith(MockitoJUnitRunner.class)
public class PersonBusinessImplTestWithMockitoAnnotations {
	
	@Mock
	PersonService personService;
	
	///I assume that this should not work as PersonService is a hard dependency in class PersonBusinessImpl
	//But unexpectedly it works :)
	@InjectMocks
	PersonBusinessImpl personBusinessImpl;

	@Test
	public void testGetFullNameOfLuckyPerson_female() {
		Person femalePerson = new Person("maneesha", "jain", Gender.Female, 52);
		stub(personService.getRandomPerson()).toReturn(femalePerson);
		String fullName = personBusinessImpl.getFullNameOfLuckyPerson();
		assertTrue("Expecting Ms", fullName.startsWith("Ms"));
	}
	
	@Test
	public void testGetFullNameOfLuckyPerson_male() {
		Person malePerson = new Person("Imbrahim", "Tamimi", Gender.Male, 52);
		when(personService.getRandomPerson()).thenReturn(malePerson);
		String fullName = personBusinessImpl.getFullNameOfLuckyPerson();
		assertTrue("Expecting Mr", fullName.startsWith("Mr"));
	}
	
	@Test(expected=IllegalStateException.class)
	public void testGetFullNameOfLuckyPerson_null() {
		personBusinessImpl.getFullNameOfLuckyPerson();
	}
	
	@Test
	public void testIsSeniorTrue() {
		Person malePerson = new Person("Imbrahim", "Tamimi", Gender.Male, 70);
		when(personService.find(anyString())).thenReturn(malePerson);
		assertTrue(personBusinessImpl.isSenior("1"));
	}

}

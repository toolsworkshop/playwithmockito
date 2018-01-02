package edu.toolsworkshop.playwithmockito.business;

import static org.junit.Assert.*;


import org.junit.Test;

import edu.toolsworkshop.playwithmockito.data.PersonService;
import edu.toolsworkshop.playwithmockito.data.PersonServiceStubForFemale;
import edu.toolsworkshop.playwithmockito.data.PersonServiceStubForMale;

public class PersonBusinessImplTest {


	@Test
	public void testGetFullNameOfLuckyPerson_female() {
		PersonService personService = new PersonServiceStubForFemale();
		PersonBusinessImpl personBusinessImpl = new PersonBusinessImpl(personService);
		String fullName = personBusinessImpl.getFullNameOfLuckyPerson();
		assertTrue(fullName.startsWith("Ms"));
	}
	
	@Test
	public void testGetFullNameOfLuckyPerson_male() {
		PersonService personService = new PersonServiceStubForMale();
		PersonBusinessImpl personBusinessImpl = new PersonBusinessImpl(personService);
		String fullName = personBusinessImpl.getFullNameOfLuckyPerson();
		assertTrue(fullName.startsWith("Mr"));
	}

}

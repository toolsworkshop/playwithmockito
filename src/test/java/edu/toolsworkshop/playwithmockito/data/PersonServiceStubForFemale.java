package edu.toolsworkshop.playwithmockito.data;

import edu.toolsworkshop.playwithmockito.data.Person.Gender;

/**
 * So sad that we have to create a stub for every test case.
 * @author maneeshajain
 *
 */
public class PersonServiceStubForFemale implements PersonService {

	@Override
	public Person find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person getRandomPerson() {
		return new Person("maneesha", "jain", Gender.Female, 52);
	}

}

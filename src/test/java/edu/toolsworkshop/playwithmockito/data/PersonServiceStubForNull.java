package edu.toolsworkshop.playwithmockito.data;

/**
 * So sad that we have to create a stub for every test case.
 * @author maneeshajain
 *
 */
public class PersonServiceStubForNull implements PersonService {

	@Override
	public Person find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person getRandomPerson() {
		return null;
	}

}

package edu.toolsworkshop.playwithmockito.business;

import edu.toolsworkshop.playwithmockito.data.Person;
import edu.toolsworkshop.playwithmockito.data.Person.Gender;
import edu.toolsworkshop.playwithmockito.data.PersonService;

public class PersonBusinessImpl {
	private PersonService personService = new PersonServiceImpl();

	
	
	/**
	 * Get a random person and return the full name with prefix (Mr. or Ms. based on gender).
	 * @return
	 */
	public String getFullNameOfLuckyPerson() {
		Person luckyPerson = personService.getRandomPerson();
		if (luckyPerson == null) {
			throw new IllegalStateException("How is it that no one is found?");
		}
		
		if (Gender.Male.equals(luckyPerson.getGender())) {
			return String.format("Mr. %s %s", luckyPerson.getFirstname(), luckyPerson.getLastname());
		} else {
			return String.format("Ms. %s %s", luckyPerson.getFirstname(), luckyPerson.getLastname());
		}
	}
	
	/**
	 * Returns true if age of the person is greater than 65
	 * @param id
	 * @return
	 */
	public boolean isSenior(String id) {
		Person person = personService.find(id);
		if (person == null) {
			throw new IllegalArgumentException("Person not found with Id:" + id);
		}
		if (person.getAge() > 65) {
			return true;
		} else {
			return false;
		}
	}
	class PersonServiceImpl implements PersonService{

		@Override
		public Person find(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Person getRandomPerson() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}

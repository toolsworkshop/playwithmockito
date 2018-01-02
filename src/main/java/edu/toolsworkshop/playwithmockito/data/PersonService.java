package edu.toolsworkshop.playwithmockito.data;

public interface PersonService {
	
	Person find(String id);
	
	Person getRandomPerson();
}

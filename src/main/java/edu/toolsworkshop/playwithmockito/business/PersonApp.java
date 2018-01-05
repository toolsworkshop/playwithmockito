package edu.toolsworkshop.playwithmockito.business;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class PersonApp {

	public static void main(String[] args) {
		
		Injector guice = Guice.createInjector(new PersonServiceModule());
		PersonBusinessImpl personBusinessImpl = guice.getInstance(PersonBusinessImpl.class);
		System.out.println(personBusinessImpl.getFullNameOfLuckyPerson());
	}
}

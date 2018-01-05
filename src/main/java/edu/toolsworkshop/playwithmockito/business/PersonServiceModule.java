package edu.toolsworkshop.playwithmockito.business;

import com.google.inject.AbstractModule;

import edu.toolsworkshop.playwithmockito.data.PersonService;
import edu.toolsworkshop.playwithmockito.data.PersonServiceImpl;

public class PersonServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(PersonService.class).to(PersonServiceImpl.class);
	}

}
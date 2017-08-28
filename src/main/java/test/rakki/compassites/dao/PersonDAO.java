package test.rakki.compassites.dao;

import java.util.List;

import test.rakki.compassites.model.Person;

public interface PersonDAO {
public void save(Person p);
	
	public List<Person> list();
}

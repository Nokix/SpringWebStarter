package com.example.SpringWebStarter.service;

import com.example.SpringWebStarter.dao.PersonDao;
import com.example.SpringWebStarter.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("mapDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        System.out.println(person);
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPersons() {
        return personDao.selectAllPersons();
    }

    public int deletePerson(UUID id) {
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person person) {
        return personDao.updatePerson(id, person);
    }

    public Optional<Person> getPerson(UUID id) {
        return personDao.getPersonById(id);
    }
}

package com.example.SpringWebStarter.dao;

import com.example.SpringWebStarter.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(Person person);

    List<Person> selectAllPersons();

    Optional<Person> getPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePerson(UUID id, Person person);
}

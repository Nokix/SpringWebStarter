package com.example.SpringWebStarter.dao;

import com.example.SpringWebStarter.model.Person;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("mapDao")
public class PersonDataBaseMap implements PersonDao{

    private static final HashMap<UUID, Person> database;
    static {
        database = new HashMap<>();
    }

    @Override
    public int insertPerson(Person person) {
        UUID id = person.getId();
        if (id != null  && database.containsKey(id)) return 0;
        if (id == null) id = UUID.randomUUID();
        database.put(id, new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPersons() {
        return database.values().stream().toList();
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        return database.containsKey(id) ? Optional.of(database.get(id)) : Optional.empty();
    }

    @Override
    public int deletePersonById(UUID id) {
        if (database.containsKey(id)) {
            database.remove(id);
            return 1;
        }
        return 0;
    }

    @Override
    public int updatePerson(UUID id, Person person) {
        if (database.containsKey(id)) {
            database.remove(id);
            if (person.getId() == null) person = new Person(id, person.getName());
            database.put(person.getId(), person);
            return 1;
        }
        return 0;
    }
}

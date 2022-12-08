package com.example.SpringWebStarter.api;

import com.example.SpringWebStarter.model.Person;
import com.example.SpringWebStarter.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }

    @GetMapping(path = "{id}")
    public void getPerson(@PathVariable("id") UUID id) {
        personService.getPerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @Validated @NonNull @RequestBody Person person) {
        personService.updatePerson(id, person);
    }
}

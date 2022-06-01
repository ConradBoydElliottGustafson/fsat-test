package ca.cgi.fsa.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ca.cgi.fsa.entities.Person;
import ca.cgi.fsa.repositories.PersonRepository;

@RestController()
public class PersonController {
    private PersonRepository People;

    public PersonController(PersonRepository people) {
        this.People = people;
    }

    @GetMapping("/people")
    public List<Person> getPeople() {
        return People.findAll();
    }

    @PostMapping("/person/create")
    public ResponseEntity<Person> create(@RequestBody Person person) throws URISyntaxException {
        Person createdPerson = People.save(person);
        if (createdPerson == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdPerson.getPersonId())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(createdPerson);
        }
    }

    @DeleteMapping("/person/{id}")
    public List<Person> deletePeople(@PathVariable Long id) {
        People.deleteById(id);
        return People.findAll();
    }

}

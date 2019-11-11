package ch.zhaw.gpi.boundary;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.gpi.entity.Person;
import ch.zhaw.gpi.entity.PersonRepository;

@RestController
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/persons")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/persons/{id}")
    public Person getPerson(@PathVariable Long id) {
        return personRepository.findById(id).get();
    }
    
    @RequestMapping(method = RequestMethod.PUT, path = "/persons")
    public void putPerson(@RequestBody Person person) {
        Person p = personRepository.findById(person.getId()).get();
        p.setName(person.getName());
        personRepository.save(person);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/persons")
    public void postPerson(@RequestBody Person person) {
        person.setId(null);
        personRepository.save(person);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/persons/{id}")
    public void deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
    }
}


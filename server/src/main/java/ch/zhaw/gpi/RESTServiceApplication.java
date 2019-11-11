package ch.zhaw.gpi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.zhaw.gpi.entity.Person;
import ch.zhaw.gpi.entity.PersonRepository;


@SpringBootApplication
public class RESTServiceApplication implements CommandLineRunner {

    @Autowired
    PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(RESTServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Person p = new Person("Hugo");
        personRepository.save(p);
        p = new Person("Michael");
        personRepository.save(p);
        
    }
}

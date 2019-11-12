package ch.zhaw.gpi;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import ch.zhaw.gpi.entity.Person;

@SpringBootApplication
@EnableProcessApplication
public class CamundaBpmnRestClient implements CommandLineRunner {
   
    @Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
    }

    @Autowired
    private RestTemplate restTemplate;


    public static void main(String[] args) {
        SpringApplication.run(CamundaBpmnRestClient.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
        Person person = restTemplate.getForObject("http://localhost:8081/persons/2", Person.class);
        System.out.println("Person Name" + person.getName());
	}
    
}

package ch.zhaw.gpi.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.Variables.SerializationDataFormats;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.camunda.spin.Spin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import ch.zhaw.gpi.entity.Person;

@Named("nameRequestDelegate")
public class NameRequestDelegate implements JavaDelegate {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void execute(DelegateExecution de) throws Exception {

        Person[] pa = restTemplate.getForObject("http://localhost:8081/persons", Person[].class);
        
        Map<String, String> names = new HashMap<String, String>();
        for (Person p : pa) {
            names.put(p.getId().toString(),p.getName());
        }
        
        de.setVariable("persons",Spin.JSON(names));

    }

    
}
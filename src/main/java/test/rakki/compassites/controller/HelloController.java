package test.rakki.compassites.controller;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.rakki.compassites.dao.PersonDAO;
import test.rakki.compassites.model.Person;



@Controller
public class HelloController {  
   /* @RequestMapping("/hello")  
    public ModelAndView helloWorld() {  
        String message = "Whats wrong with this";  
        return new ModelAndView("hellopage", "message", message);  
    } */ 
    @RequestMapping(value ="/Success",method = RequestMethod.GET,headers="Accept=application/json")  
    public ResponseEntity<Person> Success() {  
    	/**
    	 * this used to inject the necessary fields in this method. 
    	 */
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		PersonDAO personDAO = context.getBean(PersonDAO.class);
		
		Person person = new Person();
		person.setName("Rakki2"); person.setCountry("India");
		
		//personDAO.save(person);
		
		System.out.println("Person::"+person);
		
		List<Person> list = personDAO.list();
		
		for(Person p : list){
			System.out.println("Person List::"+p);
		}
		//close resources
		context.close();  
		String message = "Data added to database"; 
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
	    responseHeaders.set("MyResponseHeader", "MyValue");
		return new ResponseEntity<Person>(person,responseHeaders,HttpStatus.OK);
        //return new ModelAndView("hellopage", "message", message);  
    }  
    
    /*@RequestMapping(value ="/getPerson", method = RequestMethod.GET, produces = "application/json")  
    public Person getPerson() {  
    	*//**
    	 * this used to inject the necessary fields in this method. 
    	 *//*
    	Person person = new Person();
		person.setName("Rakki2"); person.setCountry("India");
		
		//personDAO.save(person);
		
		System.out.println("Person::"+person);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
	    responseHeaders.set("MyResponseHeader", "MyValue");
		
		return person;
        //return new ModelAndView("hellopage", "message", message);  
    }  */
    @RequestMapping(value = "/getPerson",method = RequestMethod.GET, produces = "application/json")
    public String getAllEmployeesJSON(Model model) 
    {
    	System.out.println("Comes in");
    	Person person = new Person();
		person.setName("Rakki2"); person.setCountry("India");
		
        model.addAttribute("employe", person);
        return "jsonTemplate";
    }
}  
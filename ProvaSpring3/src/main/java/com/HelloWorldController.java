package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	public HelloWorldController() {
		// TODO Auto-generated constructor stub
	}

	
	@RequestMapping("/hello") //controlla se nell'url c'è il parametro name.. ne prende il valore e lo mette in sessione con il parametro msg.../hello?name=keke
	public String hello(@RequestParam(value = "name", required = false, defaultValue = "Hello World") String name,
			Model model) {

		model.addAttribute("msg", name);

		return "paginaVisione";

	}

	
	
	
	@RequestMapping("/student") // bisogna poter fare l'associazione studentForm con student uno dei modi è il seguente ovvero prima di richiamare la pagina si richiama un altra pagina che effettua l'associazione e rimanda alla jsp del form
	public String student(Model model) {

		model.addAttribute("studentForm", new Student());// nel modello di questa pagina, mettimi un attributo che si chiama studentForm

		return "Student";// giustissimo

	}
	
	
	
	
	// si puo fare cosi ma è molto piu semplice l altro modo
//	@RequestMapping(value = "/student", method = RequestMethod.GET)
//	public ModelAndView student() {
//		return new ModelAndView("student", "command", new Student());// (nomevista, nomedel model che puo essere richiamato nella vista, oggetto della vista)
//	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("studentForm") Student student,//(nome attirbuto )
//prendi l'ogetto studentForm che è di tipo Student e dagli il nome student.. si possono a questp punto richiamare i campi con student.NOMECAMPO
//con model Attribute noi gli stiamo dicendo: tutti i campi di imput della form mappali in automatico con i campi dell'oggetto studentForm
			
			ModelMap model) {
		model.addAttribute("name", student.getName());
		model.addAttribute("age", student.getAge());
		model.addAttribute("id", student.getId());

		return "Result";
		
	}
	
	
	}



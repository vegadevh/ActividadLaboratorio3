package com.uca.capas.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Student;

@Controller
public class MainController {
	
	//@GetMapping -> @RequestMapping(method=RequestMethod.GET)
	@GetMapping(path = "/ejemplo1", produces = MediaType.TEXT_PLAIN_VALUE) //Como devolver otro tipo de texto que no sea http, dividiendo en GetMapping path y produces
	@ResponseBody //Para indicar que se deb=volvera texto http
	public String ejemplo1() {
		return "Bienvenido\n" + "Programacion de N-Capas";
	}
	
	@GetMapping("/ejemplo2")
	@ResponseBody
	public List<Student> ejemplo2(){
		return Arrays.asList(
				new Student("nombre1", "Apellido","10/10/10","Carrera x",true),
				new Student("nombre1", "Apellido","10/10/10","Ing en limones", true),
				new Student("nombre1", "Apellido","10/10/10","Shampoo", true));
				
	}
	
	@GetMapping("/index")
	public String inicio(Student student) {
		return "index";
	}
	
	@PostMapping("/formData")
	public ModelAndView procesar(Student student) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("prueba");
		mav.addObject("Estado", student.delegateEstado());
		mav.addObject("student",student);
		
		return mav;
	}
	
}

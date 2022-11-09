package com.university.app;

import com.university.app.entity.Alumno;
import com.university.app.entity.Direccion;
import com.university.app.entity.Persona;
import com.university.app.servicios.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppUniversityApplication {

	public static void main(String[] args) {
		String[] beanDefinitionNames = SpringApplication.run(AppUniversityApplication.class, args).getBeanDefinitionNames();
		/*for (String st : beanDefinitionNames) {
			System.out.println(st);
		}		 */
	}

}

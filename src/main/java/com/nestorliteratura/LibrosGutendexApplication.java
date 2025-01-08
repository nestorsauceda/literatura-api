package com.nestorliteratura;

import com.nestorliteratura.controller.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibrosGutendexApplication implements CommandLineRunner {

	private final Menu menu;

	@Autowired
	public LibrosGutendexApplication(Menu menu) {
		this.menu = menu;
	}

	public static void main(String[] args) {
		SpringApplication.run(LibrosGutendexApplication.class, args);
	}

	@Override
	public void run(String... args) {
		menu.mostrarMenu();
	}
}

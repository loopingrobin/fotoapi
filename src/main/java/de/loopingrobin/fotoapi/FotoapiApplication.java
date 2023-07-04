package de.loopingrobin.fotoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Die Klasse erstellt einen Server, der auf dem http://localhost:8080 läuft.
 */
@SpringBootApplication
public class FotoapiApplication {

	/**
	 * Die main()-Methode startet die SpringApplication.
	 * @param args wird nicht verwendet
	 */
	public static void main(String[] args) {
		SpringApplication.run(FotoapiApplication.class, args);
	}
}

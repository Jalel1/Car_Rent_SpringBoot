package com.locationVoiture;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.locationVoiture.SpringBootVoiture;

@SpringBootApplication 
public class SpringBootVoiture {
	public static void main(String[] args)  throws IOException
	{    
	SpringApplication.run(SpringBootVoiture.class, args); 
	openHomePage();
		}
	
	private static void openHomePage() throws IOException {
	       Runtime rt = Runtime.getRuntime();
	       rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8091/voiture/listeVoiture");
	    }
}

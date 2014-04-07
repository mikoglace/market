package com.mikoglace.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.SimpleCommandLinePropertySource;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    public static void main(String[] args) {
    	SpringApplication sApp = new SpringApplication(Application.class);

        SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);

        // Check if the selected profile has been set as argument.
        // if not the development profile will be added
        addDefaultProfile(sApp, source);
        
        sApp.run(args);
    }

	private static void addDefaultProfile(SpringApplication sApp,
			SimpleCommandLinePropertySource source) {
		if (!source.containsProperty("spring.profiles.active")) {
            sApp.setAdditionalProfiles("dev");
        }
	}

}
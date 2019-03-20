package com.frigg0.alienartifact;

import com.frigg0.alienartifact.services.manaDeck.ManaDeckService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlienArtifact implements CommandLineRunner {
    public static void main(String[] args){
        SpringApplication.run(AlienArtifact.class, args);
    }

    public void run(String... args){
        try {
            ManaDeckService manaDeckService = new ManaDeckService();
            System.out.println(" Draw 1 "+manaDeckService.drawCard());
            System.out.println(" Draw 2 "+manaDeckService.drawCard());
            System.out.println(" Draw 3 "+manaDeckService.drawCard());
            System.out.println(" Draw 4 "+manaDeckService.drawCard());
            System.out.println(" Draw 5 "+manaDeckService.drawCard());
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

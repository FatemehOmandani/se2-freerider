package de.freerider.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private Calculator calculator; // Calculator bean wird eingefügt

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        // Ausgabe der übergebenen Argumente
        System.out.println("\n-<5>--> run(String... args) called from CommandLineRunner Bean");
        Arrays.stream(args)
              .map(arg -> String.format(" - arg: %s", arg))
              .forEach(System.out::println);

			  int sum = calculator.add(10, 2);
			  System.out.println("Summe: " + sum);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {
            System.out.println("\n-<6>--> Bean objects created by Spring Boot in ApplicationContext:");
            String[] beanNames = context.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                if (!beanName.startsWith("org.")) {
                    System.out.println(" - bean: " + beanName);
                }
            }
        };
    }
}

@Component // Definiert den Calculator als Spring-Bean
class Calculator {
    public int add(int x, int y) {
        return x + y; // Implementierung der Additionsmethode
    }
}
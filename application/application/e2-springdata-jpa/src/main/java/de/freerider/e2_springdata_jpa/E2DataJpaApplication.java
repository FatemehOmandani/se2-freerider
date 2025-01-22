package de.freerider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class E2DataJpaApplication {

  private static final Logger log = LoggerFactory.getLogger(E2DataJpaApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(E2DataJpaApplication.class);
  }

  @Bean
public CommandLineRunner demo(CustomerRepository customerRepo, ReservationRepository reservationRepo) {
    return (args) -> {
        // Alle Kunden anzeigen
        customerRepo.findAll().forEach(customer -> {
            System.out.println(customer.toString());
        });

        // Alle Reservierungen von Kunde mit ID 2 anzeigen
        reservationRepo.findAll().forEach(reservation -> {
            if (reservation.getCustomerId() == 2) {
                System.out.println(reservation.toString());
            }
        });
    };
}
}
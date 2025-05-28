package io.symatic.consum8s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Consume8s application.
 * 
 * <p>This application serves as the consumer in the overall workflow.
 * It starts up the Spring Boot context and initializes all necessary beans.
 * </p>
 */
@SpringBootApplication
public class Consume8sApp {

    /**
     * Main method to launch the Consume8s application.
     *
     * @param argv Command line arguments.
     */
    public static void main(String[] argv) {
        SpringApplication.run(Consume8sApp.class, argv);
    }

}

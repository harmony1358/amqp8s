package io.symatic.front8s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Front8s application.
 * 
 * <p>This application represents the front-end service in the overall workflow.
 * It boots up the Spring Boot application context and initializes the web server.
 * </p>
 */
@SpringBootApplication
public class Front8sApp {

    /**
     * Main method to launch the Front8s application.
     *
     * @param argv Command line arguments.
     */
    public static void main(String[] argv) {
        SpringApplication.run(Front8sApp.class, argv);
    }

}

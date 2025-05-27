package io.symatic.red8s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Red8s application.
 * 
 * <p>This application serves as the backend service which among other things handles the counter operations.</p>
 */
@SpringBootApplication
public class Red8sApp {

    /**
     * Main method to launch the Red8s application.
     *
     * @param argv Command line arguments.
     */
    public static void main(String[] argv) {
        SpringApplication.run(Red8sApp.class, argv);
    }

}

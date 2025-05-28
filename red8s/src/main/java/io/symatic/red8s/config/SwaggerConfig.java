package io.symatic.red8s.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger configuration for the Red8s application.
 * 
 * <p>This configuration class sets up Swagger to generate API documentation for endpoints in the io.symatic.red8s package.</p>
 */
@Configuration
@EnableSwagger2
@Profile("swagger")
public class SwaggerConfig {

    /**
     * Configures and returns the Swagger Docket bean.
     *
     * @return the configured Docket instance.
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.symatic.red8s"))
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * Builds and returns the API information for Swagger documentation.
     *
     * @return ApiInfo containing title and other information.
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Red8s API")
                .build();
    }

}

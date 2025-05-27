package io.symatic.front8s.config;

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
 * Swagger configuration for the Front8s application.
 * 
 * <p>This configuration class sets up Swagger to generate API documentation
 * for endpoints in the io.symatic.front8s package.</p>
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
                .apis(RequestHandlerSelectors.basePackage("io.symatic.front8s"))
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * Builds and returns the API information for the Swagger documentation.
     *
     * @return ApiInfo containing the title and descriptive information.
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("TreeSet API")
                .build();
    }

}

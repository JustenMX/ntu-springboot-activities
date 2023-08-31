package sg.edu.ntu.simpleexpenses.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class CustomerApiConfig {

    @Bean
    public OpenAPI customerApi() {
        return new OpenAPI().info(
                new Info().title("Customer API").description("Simple Expenses Application API").version("v1.0.0"));
    }

}

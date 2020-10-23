package br.com.tst.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/rest/veiculo/{idRisco}")
            .allowedOrigins("http://localhost:4200")
            .allowedMethods("GET");
        
        registry.addMapping("/rest/veiculo")
        .allowedOrigins("http://localhost:4200")
        .allowedMethods("GET", "POST");
    }
}
